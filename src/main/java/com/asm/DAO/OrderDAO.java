package com.asm.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.asm.entity.Order;


public interface OrderDAO extends JpaRepository<Order,Long>{

    @Query(value="SELECT * FROM orders  WHERE username Like ?1",nativeQuery=true)
    List<Order> findByUsername(String username);
    
}
