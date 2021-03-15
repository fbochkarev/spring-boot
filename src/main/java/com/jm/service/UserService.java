package com.jm.service;

import com.jm.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    void add(User user);

    void removeUser(long id);

    User getUserById(long id);

    List<User> listUsers();

    UserDetails getUserByName(String username);
}
