package com.user.service.service;

import com.user.service.entity.User;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    public UserRepository repository;
    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(User user, Integer userId) {
        User existingUser = repository.findById(userId).orElse(null);
        if(Objects.nonNull(existingUser)){
            existingUser.setUserFirstName(user.getUserFirstName());
            existingUser.setUserLastName(user.getUserLastName());
            existingUser.setUserEmail(user.getUserEmail());
            existingUser.setUserPhoneNumber(user.getUserPhoneNumber());
            existingUser.setUserCity(user.getUserCity());
            return repository.save(existingUser);
        }

        return user;
    }
}
