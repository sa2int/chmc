package io.bigtreelab.rndbox.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.bigtreelab.rndbox.api.dto.jwt.TokenDto;
import io.bigtreelab.rndbox.api.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Api(tags = {"1. 로그인"}, value = "로그인")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class kakaoNaverSignController {

    @ApiOperation(value = "코드")
    @PostMapping("/kakao/success12")
    public String kakaoreturn(
            @RequestParam String code
    ) {

        System.out.println("code:" + code);
        try {
            URL url = new URL("https://kauth.kakao.com/oauth/token"); // 호출할 외부 API 를 입력한다.

            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // header에 데이터 통신 방법을 지정한다.
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            // Post인 경우 데이터를 OutputStream으로 넘겨 주겠다는 설정
            conn.setDoOutput(true);

            // Request body message에 전송
            OutputStreamWriter os = new OutputStreamWriter(conn.getOutputStream());
            String str ="grant_type=authorization_code"
                    +"&client_id=45107a1892935b483cd978d6d6746caa"
                    +"&redirect_uri=http://localhost:8080/kakao/success1"
                    +"&code="+code;

            os.write(str);
            os.flush();

            BufferedReader in = null;
            try {
                // 응답
                in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } catch (IOException e) {
                // 에러 리턴 주기
                e.printStackTrace();
            }

            JSONObject jsonObj = (JSONObject) JSONValue.parse(in.readLine());

            in.close();
            conn.disconnect();

            String accessToken = jsonObj.get("access_token").toString();
            //String result_txt = "response :: " + jsonObj.get("access_token");
            //System.out.println(result_txt);

            URL url2 = new URL("https://kapi.kakao.com/v2/user/me"); // 호출할 외부 API 를 입력한다.

            HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection(); // header에 데이터 통신 방법을 지정한다.
            conn2.setRequestMethod("POST");
            conn2.setRequestProperty("Authorization", "Bearer " + accessToken);
            conn2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

            // Post인 경우 데이터를 OutputStream으로 넘겨 주겠다는 설정
            conn2.setDoOutput(true);

            // Request body message에 전송
            OutputStreamWriter os2 = new OutputStreamWriter(conn2.getOutputStream());
            os2.flush();

            // 응답
            BufferedReader in2 = new BufferedReader(new InputStreamReader(conn2.getInputStream(), "UTF-8"));
            JSONObject jsonObj2 = (JSONObject) JSONValue.parse(in2.readLine());

            in.close();
            conn.disconnect();

            String result_txt2 = "response :: " + jsonObj2;
            System.out.println(result_txt2);
            JSONObject kakaoAccount = (JSONObject)JSONValue.parse(jsonObj2.get("kakao_account").toString());
            JSONObject profile = (JSONObject)JSONValue.parse(kakaoAccount.get("profile").toString());
            System.out.println(profile.get("nickname").toString());
            //response :: {"id":2722647112,"connected_at":"2023-03-26T05:07:09Z","kakao_account":{"email_needs_agreement":true,"profile_nickname_needs_agreement":false,"profile":{"is_default_image":false,"thumbnail_image_url":"http:\/\/k.kakaocdn.net\/dn\/verfR\/btrRMUHk7Qh\/5egsv58k0Fztkv4GtDg3mk\/img_110x110.jpg","nickname":"박태순","profile_image_url":"http:\/\/k.kakaocdn.net\/dn\/verfR\/btrRMUHk7Qh\/5egsv58k0Fztkv4GtDg3mk\/img_640x640.jpg"},"has_email":true,"profile_image_needs_agreement":false},"properties":{"profile_image":"http:\/\/k.kakaocdn.net\/dn\/verfR\/btrRMUHk7Qh\/5egsv58k0Fztkv4GtDg3mk\/img_640x640.jpg","nickname":"박태순","thumbnail_image":"http:\/\/k.kakaocdn.net\/dn\/verfR\/btrRMUHk7Qh\/5egsv58k0Fztkv4GtDg3mk\/img_110x110.jpg"}}

        }catch (Exception e){e.printStackTrace();}

        return "redirect:/";
    }


    @ApiOperation(value = "네이버 로그인", notes = "네이버 아이디로 로그인을 한다.")
    @GetMapping(value = "/reDirectNaver")
    public String signinByNaver(
            @ApiParam(value = "휴대폰번호", example = "1", required = true) @RequestParam String token,
            @ApiParam(value = "푸쉬 유저 구분자", example = "1", required = true) @RequestParam String state) {


        RestTemplate rt = new RestTemplate();
//
//        HttpHeaders accessTokenHeaders = new HttpHeaders();
//        accessTokenHeaders.add("Content-type", "application/x-www.form-urlencoded");
//
//        MultiValueMap<String, String> accessTokenParams = new LinkedMultiValueMap<>();
//        accessTokenParams.add("grant_type", "authorization_code");
//        accessTokenParams.add("client_id", "클라이언트 아이디가 들어간다");
//        accessTokenParams.add("client_secret", "클라이언트 시크릿키가 들어간다");
//        accessTokenParams.add("code", code);
//        accessTokenParams.add("state", state);
//
//        HttpEntity<MultiValueMap<String, String>> accessTokenRequest = new HttpEntity<>(accessTokenParams, accessTokenHeaders);
//
//        ResponseEntity<String> accessTokenResponse = rt.exchange(
//                "https://nid.naver.com/oauth2.0/token",
//                HttpMethod.POST,
//                accessTokenRequest,
//                String.class
//        );
//
//        //토큰 정보
//        accessTokenResponse.getBody();
//
//        log.info("accessTokenResponse : " + accessTokenResponse);
//        ObjectMapper objectMapper = new ObjectMapper();
//        NaverOauthParams naverOauthParams = null;
//        try {
//            naverOauthParams = objectMapper.readValue(accessTokenResponse.getBody(), NaverOauthParams.class);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

        HttpHeaders profileRequestHeader = new HttpHeaders();
        profileRequestHeader.add("Authorization", "Bearer " + token);

        HttpEntity<HttpHeaders> profileHttpEntity = new HttpEntity<>(profileRequestHeader);

        ResponseEntity<String> profileResponse = rt.exchange(
                "https://openapi.naver.com/v1/nid/me",
                HttpMethod.POST,
                profileHttpEntity,
                String.class
        );


        //사용자 정보
        profileResponse.getBody();
log.info(profileResponse.getBody());


        JSONObject jsonObj2 = (JSONObject) JSONValue.parse(profileResponse.getBody());

        String result_txt2 = "response :: " + jsonObj2;
        System.out.println(result_txt2);
        JSONObject kakaoAccount = (JSONObject)JSONValue.parse(jsonObj2.get("response").toString());
//        JSONObject profile = (JSONObject)JSONValue.parse(kakaoAccount.get("mobile").toString());
        System.out.println(kakaoAccount.get("mobile").toString());



return "";
//        TokenDto tokenDto = securityService.signinByCellphone(cellphone, registrationId);
//        return responseService.getResponseResult(tokenDto);
    }


}
