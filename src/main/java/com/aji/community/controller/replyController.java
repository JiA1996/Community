package com.aji.community.controller;

import com.aji.community.dataTransferObject.newReplyDTO;
import com.aji.community.model.reply;
import com.aji.community.model.user;
import com.aji.community.service.replyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/7/18
 * \* Time: 16:20
 * \* Description:
 * \
 */
@Controller
public class replyController {

    @Autowired
    private replyService rService;

    @ResponseBody
    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    public void post(@RequestBody newReplyDTO rDTO,
                       HttpServletRequest request) {
        user u = (user) request.getSession().getAttribute("user");


        reply r = new reply();
        r.setPostID(rDTO.getPostId());
        if(u == null){
            r.setUserID("0");
        }else{
            r.setUserID(u.getUserID());
        }
        r.setGmt_create(System.currentTimeMillis());
        r.setNum_upvote(0);
        r.setNum_downvote(0);
        r.setContent(rDTO.getContent());

        rService.insertReply(r);
    }

}