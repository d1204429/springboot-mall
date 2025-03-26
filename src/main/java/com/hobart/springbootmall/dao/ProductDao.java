package com.hobart.springbootmall.dao;

import com.hobart.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);

}
