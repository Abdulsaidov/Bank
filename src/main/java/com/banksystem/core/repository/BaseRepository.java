package com.banksystem.core.repository;

import com.banksystem.core.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface BaseRepository<T, ID extends Serializable> extends CrudRepository<User, ID> {

    @Override
    List<User> findAll();

}
