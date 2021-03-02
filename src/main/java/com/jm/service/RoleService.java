package com.jm.service;

import com.jm.model.Role;

import java.util.List;

public interface RoleService {
    Role findOne(Long id);
    List<Role> listRoles();
}
