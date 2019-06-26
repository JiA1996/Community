package com.aji.community.controller;

import com.aji.community.mapper.postMapper;
import com.aji.community.model.post;
import com.aji.community.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private postMapper postmapper;

    @GetMapping("/newpost")
    public String newPost(){
        return "newpost";
    }

    @PostMapping("/newpost")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "body", required = false) String body,
            HttpServletRequest request,
            Model model) {

        model.addAttribute("title", title);
        model.addAttribute("body", body);

        if (title == null || title == "") {
            model.addAttribute("error", "Title cannot be empty.");
            return "newpost";
        }

        if (body == null || body == "") {
            model.addAttribute("error", "Your post doesn't have a main body.");
            return "newpost";
        }

        user u = (user) request.getSession().getAttribute("user");

        post p = new post();
        p.setTitle(title);
        p.setBody(body);
        p.setUserID(u.getUserID());
        p.setUsername(u.getUsername());
        p.setGmt_create(System.currentTimeMillis());

        postmapper.insertPost(p);

        return "redirect:/";
    }
}
