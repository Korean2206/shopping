package com.asm.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asm.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority,Integer> {
    
}
