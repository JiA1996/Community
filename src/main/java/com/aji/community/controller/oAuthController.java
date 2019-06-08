package com.aji.community.controller;

import com.aji.community.dataTransferObject.accessTokenDTO;
import com.aji.community.dataTransferObject.user_Github;
import com.aji.community.thirdParty.InvokeGithubAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/github_redirect")
    public String github_redirect(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){

        accessTokenDTO accessTokenDTO = new accessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);

        String accessToken = githubAPI.getAccessToken(accessTokenDTO);
        user_Github user = githubAPI.getUser(accessToken);

        return "index";
    }
}
