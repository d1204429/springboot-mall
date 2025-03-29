package com.hobart.springbootmall.service.impl;


import com.hobart.springbootmall.constant.ProductCategory;
import com.hobart.springbootmall.dao.ProductDao;
import com.hobart.springbootmall.dto.ProductRequest;
import com.hobart.springbootmall.model.Product;
import com.hobart.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductCategory category, String search) {
        return productDao.getProducts(category, search);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {

        productDao.deleteProductById(productId);

    }
}
