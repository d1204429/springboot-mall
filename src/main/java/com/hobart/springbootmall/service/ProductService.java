package com.hobart.springbootmall.service;


import com.hobart.springbootmall.dto.ProductQueryParams;
import com.hobart.springbootmall.dto.ProductRequest;
import com.hobart.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);

    //沒有返回值
    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
