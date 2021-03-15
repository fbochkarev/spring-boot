package com.jm.dao;

import com.jm.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Role> listRoles() {
        return em.createQuery("from Role").getResultList();
    }

    @Override
    public Role findOne(Long id) {
        return em.find(Role.class, id);

    }
}
