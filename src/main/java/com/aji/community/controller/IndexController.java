package com.aji.community.controller;

import com.aji.community.dataTransferObject.postDTO;
import com.aji.community.service.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private postService postService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model){

        List<postDTO> posts = postService.getPostList();
        model.addAttribute("posts", posts);

        return "index";
    }
}
