package com.project.inventorymanagement.Services;

import com.project.inventorymanagement.DTOs.Product;
import com.project.inventorymanagement.DTOs.User;
import com.project.inventorymanagement.Exceptions.AlreadExistObjectException;
import com.project.inventorymanagement.Exceptions.NoSuchObjectExistsException;
import com.project.inventorymanagement.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product getProductRepoById(long productId){
        return productRepository.findById(productId).orElse(null);
    }

    public Product getProductById(long productId){
        Product repoProduct = getProductRepoById(productId);
        if(repoProduct == null){
            throw new NoSuchObjectExistsException("No Product Found with ID:"+productId);
        }
        return repoProduct;

    }

    public Product addProduct(Product product){
        Product repoProduct = getProductRepoById(product.getProductId());
        if(repoProduct == null){
            return  productRepository.save(product);
        }
        else{
            throw new AlreadExistObjectException("Product already Exists");
        }
    }
    public Product updateProduct(long productId,Product product){
        Product repoProduct = getProductRepoById(productId);
        if(repoProduct == null){
            throw new NoSuchObjectExistsException("No Product Found with ID:"+productId);
        }
        repoProduct = product;
        return  productRepository.save(repoProduct);

    }
    public List<Product> getAllProduct() {

        List<Product> repoProducts = productRepository.findAll();
        if(repoProducts.size()==0){
            throw new NoSuchObjectExistsException("No Products Found");
        }
        return repoProducts;
    }
}
