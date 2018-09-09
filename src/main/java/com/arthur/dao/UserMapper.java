package com.arthur.dao;

import com.arthur.pojo.User;
import com.arthur.pojo.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findUserById(Integer id);

    List<User> findUserByIdAndUsername(@Param("user1") User user1,@Param("user2") User user2);

    Integer getCountUsers();

    UserDTO findUserByUser(User user);

    List<User> findUserList(User user);

    List<User> findUserByList(List<Integer> idList);
}
