package com.xxxd.community;


import com.xxxd.community.dao.DiscussPostMapper;
import com.xxxd.community.dao.UserMapper;
import com.xxxd.community.entity.DiscussPost;
import com.xxxd.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("xingxx");
        user.setPassword("1453");
        user.setSalt("afg");
        user.setEmail("xingx@gmail.com");
        user.setHeaderUrl("http://images.nowcoder.com/head/2226t.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateUser(){
        int rows = userMapper.updateStatus(151,1);
        System.out.println(rows);
        rows = userMapper.updateHeader(151,"http://images.nowcoder.com/head/2225t.png");
        System.out.println(rows);
        rows = userMapper.updatePassword(151,"23454314");
        System.out.println(rows);

    }

    @Test
    public void testSelectDiscussPost(){
        List<DiscussPost>list =  discussPostMapper.selectDiscussPost(0, 0 ,5);
        for(DiscussPost post:list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);

    }

}
