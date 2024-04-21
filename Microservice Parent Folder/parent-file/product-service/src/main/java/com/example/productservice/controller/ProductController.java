package com.example.productservice.controller;

import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public String addProduct(@RequestBody ProductRequest productRequest){
        productService.addProduct(productRequest);
        return "Product added Successfully!";
    }

    @GetMapping("allProduct")
    public List<ProductResponse> allProduct(){
        return productService.allProduct();
    }
}
