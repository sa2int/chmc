package io.bigtreelab.rndbox.api.config.security;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import io.bigtreelab.rndbox.api.advice.exception.CAuthenticationEntryPointException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import io.bigtreelab.rndbox.api.dto.jwt.TokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.Base64UrlCodec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtTokenProvider { // JWT 토큰을 생성 및 검증 모듈

    @Value("${spring.jwt.secret}")
    private String secretKey;
    private String ROLES = "roles";
    private final Long accessTokenValidMillisecond = 10220 * 24 * 60 * 60 * 1000L; // 2050년   60 * 60 * 1000L; // 1 hour
    // private final Long accessTokenValidMillisecond = 5 * 60 * 1000L; // 1 hour
    private final Long refreshTokenValidMillisecond = 10225 * 24 * 60 * 60 * 1000L; // 14 day  14 * 24 * 60 * 60 * 1000L; // 14 day
    private final UserDetailsService userDetailsService;

    @Autowired
    private MessageSource messageSource;

    @PostConstruct
    protected void init() {
        // 암호화
        secretKey = Base64UrlCodec.BASE64URL.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    // Jwt 생성
    public TokenDto createTokenDto(Long userPk, List<String> roles) {

        // Claims 에 user 구분을 위한 User pk 및 authorities 목록 삽입
        Claims claims = Jwts.claims().setSubject(String.valueOf(userPk));
        claims.put(ROLES, roles);

        // 생성날짜, 만료날짜를 위한 Date
        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String accessToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setClaims(claims)
                .setIssuedAt(now).setExpiration(new Date(now.getTime() + accessTokenValidMillisecond))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        String refreshToken = Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setExpiration(new Date(now.getTime() + refreshTokenValidMillisecond))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return TokenDto.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .accessTokenExpireDate(sdf.format(new Date(now.getTime() + accessTokenValidMillisecond)))
                .build();
    }

    // Jwt 로 인증정보를 조회
    public Authentication getAuthentication(String token) {

        // Jwt 에서 claims 추출
        Claims claims = parseClaims(token);

        // 권한 정보가 없음
        if (claims.get(ROLES) == null) {
            throw new CAuthenticationEntryPointException();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // Jwt 토큰 복호화해서 가져오기
    private Claims parseClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    // HTTP Request 의 Header 에서 Token Parsing -> "X-AUTH-TOKEN: jwt"
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    // jwt 의 유효성 및 만료일자 확인
    public boolean validationToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (SecurityException | MalformedJwtException e) {
            //잘못된 Jwt 서명입니다.
            log.error(messageSource.getMessage("securityError.msg", null, LocaleContextHolder.getLocale()));
            return false;
        } catch (ExpiredJwtException e) {
            //만료된 토큰입니다
            log.error(messageSource.getMessage("expiredJwt.msg", null, LocaleContextHolder.getLocale()));
            return false;
        } catch (UnsupportedJwtException e) {
            //지원하지 않는 토큰입니다.
            log.error(messageSource.getMessage("unsupportedJwt.msg", null, LocaleContextHolder.getLocale()));
            return false;
        } catch (IllegalArgumentException e) {
            //잘못된 토큰입니다.
            log.error(messageSource.getMessage("illegalArgument.msg", null, LocaleContextHolder.getLocale()));
            return false;
        }
    }
}
