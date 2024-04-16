package com.project.inventorymanagement.Services;

import com.project.inventorymanagement.DTOs.ProductSupplier;
import com.project.inventorymanagement.DTOs.User;
import com.project.inventorymanagement.Exceptions.AlreadExistObjectException;
import com.project.inventorymanagement.Exceptions.NoSuchObjectExistsException;
import com.project.inventorymanagement.Repositories.ProductSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSupplierService {

    @Autowired
    ProductSupplierRepository productSupplierRepository;

    public ProductSupplier getProductSupplierRepoById(long prodductSupplierId){
        return productSupplierRepository.findById(prodductSupplierId).orElse(null);
    }

    public ProductSupplier getProductSupplierById(long prodductSupplierId){
        ProductSupplier productSupplierRepo =  getProductSupplierRepoById(prodductSupplierId);
        if(productSupplierRepo == null){
            throw new NoSuchObjectExistsException("No Product Found with ID:"+prodductSupplierId);
        }
        return productSupplierRepo;
    }
    public List<ProductSupplier> getAllProductSupplier(){
        List<ProductSupplier> repoProductSupplier = productSupplierRepository.findAll();
        if(repoProductSupplier.size()==0){
            throw new NoSuchObjectExistsException("No Product Found");
        }
        return repoProductSupplier;
    }

    public ProductSupplier addProductSupplier(ProductSupplier productSupplier){
        ProductSupplier repoProductSupplier = getProductSupplierRepoById(productSupplier.getProductSupplierId());
        if(repoProductSupplier == null){
            return productSupplierRepository.save(productSupplier);
        }
        else{
            throw new AlreadExistObjectException("Product already Exists");
        }
    }

    public ProductSupplier updateProductSupplier(long productSupplierId, ProductSupplier productSupplier){
        ProductSupplier repoProductSupplier = getProductSupplierRepoById(productSupplierId);
        if(repoProductSupplier == null){
            throw new NoSuchObjectExistsException("No Product Found with ID:"+productSupplierId);
        }
        else{
            repoProductSupplier = productSupplier;
            return productSupplierRepository.save(repoProductSupplier);
        }

    }
}
