package com.aji.community.service;

import com.aji.community.dataTransferObject.replyDTO;
import com.aji.community.mapper.postMapper;
import com.aji.community.mapper.replyMapper;
import com.aji.community.mapper.userMapper;
import com.aji.community.model.post;
import com.aji.community.model.reply;
import com.aji.community.model.user;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/7/18
 * \* Time: 17:59
 * \* Description:
 * \
 */
@Service
public class replyService {

    @Autowired
    private replyMapper rMapper;

    @Autowired
    private postMapper pMapper;

    @Autowired
    private userMapper uMapper;


    public void insertReply(reply r) {


            post p = pMapper.getPostByID(r.getPostID());
            p.setNum_view(0);
            rMapper.insertReply(r);
            p.setNum_comment(p.getNum_comment()+1);
            pMapper.updateComment(p);

    }


    public List<replyDTO> getReplyListByPostId(Integer postID) {

        List<reply> replyList = rMapper.selectReplyListByPostId(postID);

        //empty post, return
        if (replyList.size() == 0) {
            return new ArrayList<>();
        }

        //get commentators id and remove duplicate
        Set<String> commentators = replyList.stream().map(reply -> reply.getUserID()).collect(Collectors.toSet());
        List<String> userIDs = new ArrayList();
        userIDs.addAll(commentators);

        //get user object by user id
        List<user> userList = uMapper.selectUserListByUserIDList(userIDs);

        //map by <userid, user object>
        Map<String, user> userMap = userList.stream().collect(Collectors.toMap(user -> user.getUserID(), user -> user));

        //get replyDTO
        List<replyDTO> replyDTOs = replyList.stream().map(reply -> {
            replyDTO rDTO = new replyDTO();
            BeanUtils.copyProperties(reply, rDTO);
            rDTO.setUserObject(userMap.get(reply.getUserID()));
            return rDTO;
        }).collect(Collectors.toList());

        return replyDTOs;
    }

}