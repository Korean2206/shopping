package com.asm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.asm.DAO.ProductDAO;
import com.asm.entity.Product;
import com.asm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    ProductDAO pDao;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return pDao.findAllP(pageable);
    }

    @Override
    public Product findById(Integer id) {
        // TODO Auto-generated method stub
        return pDao.findById(id).get();
    }

    @Override
    public List<Product> findByCategoryId(String cid) {
        return pDao.findByCategoryId(cid);
    }

    @Override
    public Page<Product> findByidAndGender(String cid, boolean b,Pageable pageable) {
        // TODO Auto-generated method stub
        return pDao.findByCategoryIdAndGender(cid, b,pageable);
    }

    @Override
    public List<Product> findbyBestSeller() {
        // TODO Auto-generated method stub
        return pDao.finByBestSeller();
    }

    
}
