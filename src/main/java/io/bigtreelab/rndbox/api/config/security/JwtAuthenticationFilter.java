package io.bigtreelab.rndbox.api.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class JwtAuthenticationFilter extends GenericFilterBean {

    private JwtTokenProvider jwtTokenProvider;

    // Jwt Provier 주입
    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

 // request 로 들어오는 Jwt 의 유효성을 검증 - JwtProvider.validationToken() 을 필터로서 FilterChain 에 추가
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        // request 에서 token 을 취한다.
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);

        // 검증
        if(((HttpServletRequest) request).getRequestURL().toString().indexOf("poking") < 0) {
            log.info("[Verifying token]");
            log.info(((HttpServletRequest) request).getRequestURL().toString());
        }

        if (token != null && jwtTokenProvider.validationToken(token)) {
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
