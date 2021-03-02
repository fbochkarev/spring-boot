package com.jm.service;

import com.jm.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    void add(User user);
    void removeUser(long id);
    void updateUser(User user);
    User getUserById(long id);
    List listUsers();
    UserDetails getUserByName(String username);
}
