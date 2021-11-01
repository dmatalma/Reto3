package com.g09.reto3.service;

import java.util.List;

import com.g09.reto3.entity.AdminUser;

public interface AdminUserService {

    List<AdminUser> findAllAdminUsers();

    AdminUser save(AdminUser adminUser);
    
}
