package com.project.inventorymanagement.Controllers;

import com.project.inventorymanagement.DTOs.Product;
import com.project.inventorymanagement.DTOs.ProductSupplier;
import com.project.inventorymanagement.DTOs.User;
import com.project.inventorymanagement.Services.ProductService;
import com.project.inventorymanagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/productDetail")
public class ProductDetailController {

    @Autowired
    ProductService productService;

    @GetMapping("/getProduct/{productId}")
    public Product productDetailById(@PathVariable long productId){  return productService.getProductById(productId); }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct(){  return productService.getAllProduct(); }

    @PutMapping("/updateProduct/{productId}")
    public Product updateProductById(@PathVariable long productId,Product product){ return productService.updateProduct(productId,product); }




}
