package com.example.LibraryWeb.impl;

import com.example.LibraryWeb.model.Role;
import com.example.LibraryWeb.repository.RoleRepo;
import com.example.LibraryWeb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo){
        this.roleRepo = roleRepo;
    }

    @Override
    public Role findByName(String name){
        return roleRepo.findByName(name);
    }
}
