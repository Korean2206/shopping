package com.asm.service;

import java.util.List;
import java.util.Optional;

import com.asm.entity.Product;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategoryId(String cid);

    List<Product> findByidAndGender(String cid, boolean b);
    
}
