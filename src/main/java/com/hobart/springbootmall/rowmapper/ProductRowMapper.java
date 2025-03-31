package com.hobart.springbootmall.rowmapper;

import com.hobart.springbootmall.constant.ProductCategory;
import com.hobart.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

//        String categoryStr = resultSet.getString("category");
//        ProductCategory category = ProductCategory.valueOf(categoryStr);
//        product.setCategory(category);

        product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));


        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getObject("created_date", LocalDateTime.class));
        product.setLastModifiedDate(resultSet.getObject("last_modified_date", LocalDateTime.class));

        return product;

    }
}
