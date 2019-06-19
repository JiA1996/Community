package com.aji.community.controller;

import com.aji.community.dataTransferObject.accessTokenDTO;
import com.aji.community.dataTransferObject.user_Github;
import com.aji.community.model.user;
import com.aji.community.thirdParty.InvokeGithubAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/github_redirect")
    public String github_redirect(@RequestParam(name = "code") String code,
                                  @RequestParam(name = "state") String state,
                                  HttpServletRequest request){

        accessTokenDTO accessTokenDTO = new accessTokenDTO();
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);

        String accessToken = githubAPI.getAccessToken(accessTokenDTO);
        user_Github user_github = githubAPI.getUser(accessToken);

        if (user_github != null && user_github.getId() != null) {
            request.getSession().setAttribute("user_github", user_github);
            user user = new user();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setUsername(user_github.getName());
            user.setUserID(String.valueOf(user_github.getId()));
            //response.addCookie(new Cookie("token", token));
            return "redirect:/";
        } else {
            //fail to login
            //retry
            return "redirect:/";
        }
    }
}
