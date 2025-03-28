package com.hobart.springbootmall.dao;

import com.hobart.springbootmall.dto.ProductRequest;
import com.hobart.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);

}
