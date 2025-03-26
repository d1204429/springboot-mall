package com.hobart.springbootmall.dao.impl;

import com.hobart.springbootmall.dao.ProductDao;
import com.hobart.springbootmall.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product getProductById(Integer productId) {

        String sql = "SELECT product_id,product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE product_id = :product_id";

        return null;
    }
}
