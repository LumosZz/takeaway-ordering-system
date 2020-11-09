package com.lumosss.repository;

import com.lumosss.entity.Admin;

public interface AdminRepository {
    public Admin login(String username,String password);
}
