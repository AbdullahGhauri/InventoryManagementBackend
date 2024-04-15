package com.project.inventorymanagement.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private long productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productCode")
    private String productCode;
    @Column(name = "productDetail")
    private String productDetail;
    @Column(name = "productPurchaseRate")
    private double productPurchaseRate;
    @Column(name = "productSaleRate")
    private double productSaleRate;
    @Column(name = "productMfgDate")
    private Date productMfgDate;
    @Column(name = "productExpDate")
    private Date productExpDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productAddressId")
    private Address productAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductSupplier> productSupplierList;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductSale> productSaleList;

    @JsonIgnore
    @OneToOne(mappedBy = "product")
    private AvailableProduct availableProduct;
}
