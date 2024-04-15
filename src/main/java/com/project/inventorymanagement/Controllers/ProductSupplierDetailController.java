package com.project.inventorymanagement.Controllers;

import com.project.inventorymanagement.DTOs.Product;
import com.project.inventorymanagement.DTOs.ProductSupplier;
import com.project.inventorymanagement.Services.ProductService;
import com.project.inventorymanagement.Services.ProductSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductSupplierDetailController {
    @Autowired
    ProductSupplierService productSupplierService;

    @GetMapping("/getProductSupplier/{productSupplierId}")
    public ProductSupplier productSupplierDetailById(@PathVariable long productSupplierId)
    {  return productSupplierService.getProductSupplierById(productSupplierId); }

    @PostMapping("/addProductSupplier")
    public ProductSupplier addProductSupplier(@RequestBody ProductSupplier productSupplier){
        return productSupplierService.addProductSupplier(productSupplier);
    }

    @GetMapping("/getAllProductSupplier")
    public List<ProductSupplier> getAllProductSupplier(){  return productSupplierService.getAllProductSupplier(); }

    @PutMapping("/updateProductSupplier/{productSupplierId}")
    public ProductSupplier updateProductSupplierById(@PathVariable long productSupplierId,ProductSupplier productSupplier)
    { return productSupplierService.updateProductSupplier(productSupplierId,productSupplier); }



}
