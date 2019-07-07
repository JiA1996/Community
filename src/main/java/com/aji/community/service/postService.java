package com.aji.community.service;

import com.aji.community.dataTransferObject.postDTO;
import com.aji.community.mapper.postMapper;
import com.aji.community.mapper.userMapper;
import com.aji.community.model.post;
import com.aji.community.model.user;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/7/5
 * \* Time: 17:56
 * \* Description: combine post mapper and user mapper.
 *                 Return full list of posts(contain user object)
 * \
 */

@Service
public class postService {

    @Autowired
    private userMapper userMapper;

    @Autowired
    private postMapper postMapper;


    public List<postDTO> getPostList() {
        List<post> posts = postMapper.getAllPosts();
        List<postDTO> postDTOList = new ArrayList<>();
        for (post p : posts){
            user u = userMapper.getUserByID(p.getUserID());
            postDTO pDTO = new postDTO();
            BeanUtils.copyProperties(p, pDTO);
            pDTO.setUserObject(u);
            postDTOList.add(pDTO);
        }
        return postDTOList;
    }

    public postDTO getPostByID(Integer id) {
        post p = postMapper.getPostByID(id);
        user u = userMapper.getUserByID(p.getUserID());
        postDTO pDTO = new postDTO();

        BeanUtils.copyProperties(p, pDTO);
        pDTO.setUserObject(u);
        return pDTO;
    }

}
