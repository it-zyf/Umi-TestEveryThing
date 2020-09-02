package com.example.xyy.mapper;

import com.example.xyy.test.bean.Login;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface RegisterMapper {

    void insert(@PathParam("userName") String userName, @PathParam("passWord") String passWord, String mail);

    List<Login> findUserMail();

    void delete();
}
