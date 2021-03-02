package com.jm.service;

import com.jm.dao.RoleDao;
import com.jm.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional
    public Role findOne(Long id) {
        return roleDao.findOne(id);
    }

    @Override
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }
}
