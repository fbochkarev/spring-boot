package com.jm.dao;

import com.jm.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    private EntityManager em;

    public List<Role> listRoles() {
        return em.createQuery("from Role").getResultList();
    }

    @Override
    public Role findOne(Long id) {
        return em.find(Role.class, id);

    }

    @Override
    public Role findOneByName(String rolename) {
        Role role = em.createQuery(
                "SELECT name from roles r WHERE r.name = 'ROLE_USER'", Role.class)
//                "SELECT r from Role r WHERE r.name = :rolename", Role.class)
//                .setParameter("rolename", rolename)
                .getSingleResult();
        System.out.println(getClass() + " - findOneByName - " + role.toString());
        return role;
    }

}
