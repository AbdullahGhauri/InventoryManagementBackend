package com.project.inventorymanagement.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "Supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierId")
    private long supplierId;
    @Column(name = "supplierName")
    private String supplierName;
    @Column(name = "supplierNumber")
    private String supplierNumber;
    @Column(name = "supplierCNIC")
    private String supplierCNIC;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplierAddressId")
    private Address supplierAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<ProductSupplier> productSupplierList;

}
