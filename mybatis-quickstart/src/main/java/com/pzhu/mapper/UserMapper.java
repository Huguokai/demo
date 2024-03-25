package com.pzhu.mapper;

import com.pzhu.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}