package com.asm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.DAO.AccountDAO;
import com.asm.entity.Account;
import com.asm.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    AccountDAO aDao;

    @Override
    public Account findById(String username) {
        return aDao.findById(username).get();
    }
}
