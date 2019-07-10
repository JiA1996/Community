package com.aji.community.service;

import com.aji.community.mapper.userMapper;
import com.aji.community.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/7/10
 * \* Time: 21:40
 * \* Description:  This service is used to prevent duplicate registration
 *                  when the same user login.
 * \
 */

@Service
public class userService {
    @Autowired
    private userMapper mapper;

    public void whenUserLogin(user user) {
        user oneUser = mapper.getUserByID(user.getUserID());

        //a new user
        if (oneUser == null) {
            // insert
            user.setGmt_joindate(System.currentTimeMillis());
            mapper.insertUser(user);
        } else {
            //an existed user, update info
            mapper.updateByID(user);
        }
    }

}
