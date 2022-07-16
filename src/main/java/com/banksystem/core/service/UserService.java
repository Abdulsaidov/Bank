package com.banksystem.core.service;

import com.banksystem.core.dto.RequestUserDTO;
import com.banksystem.core.entity.User;
import com.banksystem.core.exception.NotFoundException;
import com.banksystem.core.repository.BaseRepository;
import com.banksystem.core.repository.GenericRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class UserService {

    public final BaseRepository<User, Long> repository;
    public final GenericRepository<User, Long> genericRepository;

    @Autowired
    public UserService(BaseRepository<User, Long> repository,
                       GenericRepository<User, Long> genericRepository) {
        this.repository = repository;
        this.genericRepository = genericRepository;
    }

    public User create(RequestUserDTO requestUserDTO) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(requestUserDTO, user);
        user.setIsDeleted(false);
        //можно повыдумывать по поводу часовых поясов потом
        user.setAddedDate(OffsetDateTime.now());
        user.setModifiedDate(null);
        return repository.save(user);
    }

    public User getUserById(Long id) {
        return genericRepository.findById(id, User.class)
                .orElseThrow(() -> new NotFoundException(id, User.class));
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void updateUser(Long userId, RequestUserDTO requestUserDTO) {
        User current = getUserById(userId);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(requestUserDTO, current);
        current.setModifiedDate(OffsetDateTime.now());
    }

    public void removeUserById (Long id) {
        repository.deleteById(id);
    }


}
