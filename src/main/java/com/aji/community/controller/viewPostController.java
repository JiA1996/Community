package com.aji.community.controller;

import com.aji.community.dataTransferObject.postDTO;
import com.aji.community.service.postService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/7/7
 * \* Time: 18:50
 * \* Description: controller for view post page
 * \
 */
@Controller
public class viewPostController {

    @Autowired
    private postService pService;

    @GetMapping("/post/{id}")
    public String post(@PathVariable(name = "id") Integer id, Model model) {
        postDTO pDTO = pService.getPostByID(id);

        model.addAttribute("post", pDTO);
        //model.addAttribute("comments", replies);
        return "post";
    }
}
