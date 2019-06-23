package com.aji.community.controller;

import com.aji.community.mapper.userMapper;
import com.aji.community.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private userMapper mapper;


    @GetMapping("/")
    public String index(HttpServletRequest request){

        Cookie[] cookies = request.getCookies();

        //
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                user u = mapper.getUserByToken(token);
                if(u != null){
                    request.getSession().setAttribute("user", u);
                }
                break;
            }
        }

        return "index";
    }
}
