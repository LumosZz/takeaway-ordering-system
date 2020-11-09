package com.lumosss.repository;

import com.lumosss.entity.User;

public interface UserRepository {
    public User login(String username,String password);
}
