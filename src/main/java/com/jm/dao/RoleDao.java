package com.jm.dao;

import com.jm.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> listRoles();
    Role findOne(Long id);
}
