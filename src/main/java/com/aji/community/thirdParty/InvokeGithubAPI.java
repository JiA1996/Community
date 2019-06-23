package com.aji.community.thirdParty;

import com.aji.community.dataTransferObject.accessTokenDTO;
import com.aji.community.dataTransferObject.user_Github;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

@Component
public class InvokeGithubAPI {

    //Post to server to get access token from github
    public String getAccessToken(accessTokenDTO accessTokenDTO) {

        MediaType type_JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(type_JSON, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
        try {
            Response response = client.newCall(request).execute();
            String accessToken = response.body().string().split("=")[1].split("&")[0];
            return accessToken;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //send access token to github to get a json file containing user information.
    //Then get user object by parsing json.
    public user_Github getUser(String accessToken) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String originalString = response.body().string();
            user_Github user = JSON.parseObject(originalString, user_Github.class);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
