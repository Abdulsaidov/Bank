package com.banksystem.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public class GenericRepository<T, ID> {

    private final EntityManager entityManager;

    @Autowired
    public GenericRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Optional<T> findById(ID id, Class<T> type) {
        return Optional.ofNullable(entityManager.find(type, id));
    }

}
