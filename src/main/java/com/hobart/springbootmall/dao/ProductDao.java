package com.hobart.springbootmall.dao;

import com.hobart.springbootmall.constant.ProductCategory;
import com.hobart.springbootmall.dto.ProductQueryParams;
import com.hobart.springbootmall.dto.ProductRequest;
import com.hobart.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);
    Product getProductById (Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);
    void deleteProductById(Integer productId);

}
