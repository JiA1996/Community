package com.aji.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/23
 * \* Time: 19:05
 * \* Description:
 * \
 */

@Controller
public class newPostController {

    @GetMapping("/newpost")
    public String newPost(){
        return "newpost";
    }
}
