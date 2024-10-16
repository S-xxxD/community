package com.xxxd.community.dao;

import com.xxxd.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    // 用户id，每页起始行行号，每页的数据
    List<DiscussPost> selectDiscussPost(int userId, int offset, int limit);

    // @Param注解用于给参数取别名
    int selectDiscussPostRows(@Param("userId") int userId);

}
