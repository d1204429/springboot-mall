package com.hobart.springbootmall.dto;

import com.hobart.springbootmall.constant.ProductCategory;
import jakarta.validation.constraints.NotNull;

//dto層主要是用來接收前端傳送的數值，故僅保留需由前端傳進來的參數
//NotNull依據實際需求設定
public class ProductRequest {

//    private Integer productId;
    @NotNull
    private String productName;
    @NotNull
    private ProductCategory category;
    @NotNull
    private String imageUrl;
    @NotNull
    private Integer price;
    @NotNull
    private Integer stock;
    private String description;
//    private LocalDateTime createDate;
//    private LocalDateTime lastModifiedDate;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
