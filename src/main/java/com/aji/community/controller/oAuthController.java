package com.aji.community.controller;

import com.aji.community.dataTransferObject.accessTokenDTO;
import com.aji.community.dataTransferObject.user_Github;
import com.aji.community.mapper.userMapper;
import com.aji.community.model.user;
import com.aji.community.thirdParty.InvokeGithubAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class oAuthController {

    @Autowired
    private InvokeGithubAPI githubAPI;

    @Value("${github.client_id}")
    private String client_id;

    @Value("${github.client_secret}")
    private String client_secret;

    @Value("${github.redirect_uri}")
    private String redirect_uri;

    @Autowired
    private userMapper userMapper;

    @GetMapping("/github_redirect")
    public String github_redirect(@RequestParam(name = "code") String code,
                                  @RequestParam(name = "state") String state,
                                  HttpServletRequest request,
                                  HttpServletResponse response){

        //send access token to github
        //get user information.(name, id, bio, etc.)
        accessTokenDTO accessTokenDTO = new accessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        String accessToken = githubAPI.getAccessToken(accessTokenDTO);
        user_Github user_github = githubAPI.getUser(accessToken);

        if (user_github != null && user_github.getId() != null) {

            //store user into databse
            user u = new user();
            String token = UUID.randomUUID().toString();
            u.setToken(token);
            u.setUsername(user_github.getName());
            u.setUserID(String.valueOf(user_github.getId()));
            u.setGmt_joindate(System.currentTimeMillis());
            u.setAvatarUrl(user_github.getAvatarUrl());
            userMapper.insertUser(u);

            //save cookie
            response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            //fail to login
            //retry
            return "redirect:/";
        }
    }
}
