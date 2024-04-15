package com.project.inventorymanagement.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private long customerId;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "customerNumber")
    private String customerNumber;
    @Column(name = "customerCNIC")
    private String customerCNIC;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerAddressId")
    private Address customerAddress;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<ProductSale> productSaleList;
}
