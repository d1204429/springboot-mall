package com.hobart.springbootmall.service.impl;


import com.hobart.springbootmall.dao.ProductDao;
import com.hobart.springbootmall.dto.ProductRequest;
import com.hobart.springbootmall.model.Product;
import com.hobart.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
