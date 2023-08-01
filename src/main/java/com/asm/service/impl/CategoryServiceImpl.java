package com.asm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asm.DAO.CategoryDAO;
import com.asm.entity.Category;
import com.asm.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO cDao;
    @Override
    public List<Category> findAll() {
        return cDao.findAll();
    }
    
}
