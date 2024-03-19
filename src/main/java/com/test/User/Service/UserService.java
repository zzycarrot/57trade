package com.test.User.Service;

import com.test.User.POJO.User;

import java.util.List;

public interface UserService {
    User login(User user) ;

    List<User> selectAll();

    void insert(User user);

    Integer delete(String username);

    User select(String username);
}
