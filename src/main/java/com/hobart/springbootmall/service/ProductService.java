package com.hobart.springbootmall.service;

import com.hobart.springbootmall.constant.ProductCategory;
import com.hobart.springbootmall.dto.ProductRequest;
import com.hobart.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);

    //沒有返回值
    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
