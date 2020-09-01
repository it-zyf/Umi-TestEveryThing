package com.example.xyy.mapper;

import org.apache.ibatis.annotations.Mapper;

import javax.websocket.server.PathParam;
@Mapper
public interface RegisterMapper {

    void insert(@PathParam("userName") String userName,@PathParam("passWord") String passWord);
}
