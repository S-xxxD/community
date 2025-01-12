package com.xxxd.community.dao;

import com.xxxd.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);
    User selectByUsername(String username);
    User selectByEmail(String email);

    int insertUser(User user); //返回插入数据的行数
    int updateStatus(int id, int status);
    int updateHeader(int id, String headerUrl);
    int updatePassword(int id, String password);

}
