package com.hobart.springbootmall.controller;

import com.hobart.springbootmall.constant.ProductCategory;
import com.hobart.springbootmall.dto.ProductQueryParams;
import com.hobart.springbootmall.dto.ProductRequest;
import com.hobart.springbootmall.model.Product;
import com.hobart.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //查詢會返回商品列表與商品數據
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(
        @RequestParam(required = false) ProductCategory category,
        @RequestParam(required = false) String search
    ) {

        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);

        List<Product> productList = productService.getProducts(productQueryParams);

        return ResponseEntity.status(HttpStatus.OK).body(productList);

    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);


    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest) {


        Product product = productService.getProductById(productId);

        //檢查product是否存在
        if(product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改product的數據
        productService.updateProduct(productId, productRequest);
        Product updatedproduct = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedproduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {

        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }


}
