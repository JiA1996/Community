package com.aji.community.controller;

import com.aji.community.dataTransferObject.postDTO;
import com.aji.community.dataTransferObject.replyDTO;
import com.aji.community.service.postService;
import com.aji.community.service.replyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

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

    @Autowired
    private replyService rService;

    @GetMapping("/post/{id}")
    public String post(@PathVariable(name = "id") Integer postID, Model model) {
        pService.increaseViews(postID);
        postDTO pDTO = pService.getPostByID(postID);
        List<replyDTO> replies = rService.getReplyListByPostId(postID);
        System.out.println(replies);
        model.addAttribute("post", pDTO);
        model.addAttribute("repliesss", replies);
        return "post";
    }
}
