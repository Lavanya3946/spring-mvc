package com.xworkz.userapp.repository;

import com.xworkz.userapp.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository


public class UserRepoImpl implements UserRepo {


    @Override
    public boolean save(UserEntity userEntity) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lavanya");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            if (userEntity != null) {
                entityManager.getTransaction().begin();
                entityManager.persist(userEntity);
                entityManager.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return  false;

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
