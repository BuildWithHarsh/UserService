package com.user.service.service;

import com.user.service.entity.User;

public interface UserService {
    public User createUser(User user);
    public User updateUser(User user, Integer userId);
}
