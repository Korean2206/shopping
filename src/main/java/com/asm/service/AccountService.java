package com.asm.service;

import   com.asm.entity.Account;
import com.fasterxml.jackson.databind.JsonNode;

public interface AccountService {
    
        public Account findById(String username);

        public Account create(Account user) throws Exception;

        public void update(Account user);

}
