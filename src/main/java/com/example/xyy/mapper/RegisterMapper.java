package com.example.xyy.mapper;

import com.example.xyy.entity.User_R;
import com.example.xyy.test.bean.Login;
import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface RegisterMapper {

    void insert(User_R user);

    List<Login> findUserMail();

    void delete();
}
