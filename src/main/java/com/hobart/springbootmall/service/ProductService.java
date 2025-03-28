package com.hobart.springbootmall.service;

import com.hobart.springbootmall.dto.ProductRequest;
import com.hobart.springbootmall.model.Product;

public interface ProductService {

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);

}
