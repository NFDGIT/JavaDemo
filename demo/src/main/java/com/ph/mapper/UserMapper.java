package com.ph.mapper;

import java.util.List;

import com.ph.model.UserModel;

public interface UserMapper {
     public List<UserModel> selectAllUser() throws Exception;
     public void insertUser(UserModel userModel) throws Exception;
     public void updateUser(UserModel userModel) throws Exception;
}
