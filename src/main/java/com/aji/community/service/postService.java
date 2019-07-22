package com.aji.community.service;

import com.aji.community.dataTransferObject.postDTO;
import com.aji.community.mapper.postMapper;
import com.aji.community.mapper.userMapper;
import com.aji.community.model.post;
import com.aji.community.model.user;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    public List<postDTO> getPostList(String search) {

        List<post> posts;

        if (StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, " ");
            search = Arrays.stream(tags).collect(Collectors.joining("|"));
            posts = postMapper.getAllPostsBySearch(search);
        }else {
            posts = postMapper.getAllPosts();
        }

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

    public void increaseViews(Integer id) {
        post p = new post();
        p.setId(id);
        p.setNum_view(postMapper.getPostByID(id).getNum_view() + 1);
        postMapper.updateViews(p);
    }
}
