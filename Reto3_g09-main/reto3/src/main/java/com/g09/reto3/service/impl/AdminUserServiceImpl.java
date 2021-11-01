package com.g09.reto3.service.impl;

import java.util.List;

import com.g09.reto3.entity.AdminUser;
import com.g09.reto3.repository.AdminUserRepository;
import com.g09.reto3.service.AdminUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService{

    @Autowired
    AdminUserRepository adminUserRepository;

    @Override
    public List<AdminUser> findAllAdminUsers() {
        return (List<AdminUser>) adminUserRepository.findAll();
    }

    @Override
    public AdminUser save(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    
}
