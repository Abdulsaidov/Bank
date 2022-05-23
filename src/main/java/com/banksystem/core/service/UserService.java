package com.banksystem.core.service;

import com.banksystem.core.entity.User;
import com.banksystem.core.exception.NotFoundException;
import com.banksystem.core.repository.BaseRepository;
import com.banksystem.core.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
// прослойка между контроллером и моделью, здесь пишется бизнес логика
    // вычисления

    public final BaseRepository<User, Long> repository;
    public final GenericRepository<User, Long> genericRepository;

    @Autowired
    public UserService(BaseRepository<User, Long> repository,
                       GenericRepository<User, Long> genericRepository) {
        this.repository = repository;
        this.genericRepository = genericRepository;
    }

    // for example
    public User create(User user) {
        return repository.save(user);
    }

    public User getUserById(Long id) {
        return genericRepository.findById(id, User.class)
                .orElseThrow(() -> new NotFoundException(id, User.class));

//        return repository
//                .findById(id)
//                .orElseThrow(() -> new NotFoundException(id, User.class));
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // update
    public User updateUser (User updatedUser) {
        return repository.save(updatedUser);
    }
    // delete
    public void removeUserById (Long id) {
        repository.deleteById(id);
    }


}
