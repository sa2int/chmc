package io.bigtreelab.rndbox.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeComtroller {

    @GetMapping(value="/")
    public String sfdsdf(){
        return "index";
    }

    @GetMapping(value="/kakao/success1")
    public String kakaoreturn(HttpServletRequest req) {
        System.out.println(req.getParameter("grant_type"));
        System.out.println(req.getParameter("client_id"));
        System.out.println(req.getParameter("redirect_uri"));
        System.out.println(req.getParameter("code"));
        System.out.println(req.getParameter("client_secret"));
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
                    +"&code="+req.getParameter("code");

            os.write(str);
            os.flush();

            // 응답
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
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
            //response :: {"id":2722647112,"connected_at":"2023-03-26T05:07:09Z","kakao_account":{"email_needs_agreement":true,"profile_nickname_needs_agreement":false,"profile":{"is_default_image":false,"thumbnail_image_url":"http:\/\/k.kakaocdn.net\/dn\/verfR\/btrRMUHk7Qh\/5egsv58k0Fztkv4GtDg3mk\/img_110x110.jpg","nickname":"박태순","profile_image_url":"http:\/\/k.kakaocdn.net\/dn\/verfR\/btrRMUHk7Qh\/5egsv58k0Fztkv4GtDg3mk\/img_640x640.jpg"},"has_email":true,"profile_image_needs_agreement":false},"properties":{"profile_image":"http:\/\/k.kakaocdn.net\/dn\/verfR\/btrRMUHk7Qh\/5egsv58k0Fztkv4GtDg3mk\/img_640x640.jpg","nickname":"박태순","thumbnail_image":"http:\/\/k.kakaocdn.net\/dn\/verfR\/btrRMUHk7Qh\/5egsv58k0Fztkv4GtDg3mk\/img_110x110.jpg"}}

        }catch (Exception e){e.printStackTrace();}

        return "redirect:/";
    }

}
