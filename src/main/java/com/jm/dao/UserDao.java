package com.jm.dao;

import com.jm.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void removeUser(long id);

    User getUserById(long id);

    List<User> listUsers();

    User getUserByName(String name);
}
