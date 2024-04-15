package com.project.inventorymanagement.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "Address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private long addressId;
    @Column(name = "plotNumber")
    private String plotNumber;
    @Column(name = "blockNumber")
    private String blockNumber;
    @Column(name = "town")
    private String town;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "country")
    private String country;
    @Column(name = "addressDetail")
    private String addressDetail;

    @JsonIgnore
    @OneToOne(mappedBy = "supplierAddress")
    private Supplier supplier;

    @JsonIgnore
    @OneToOne(mappedBy = "userAddress")
    private User user;

    @JsonIgnore
    @OneToOne(mappedBy = "productAddress")
    private Product product;

    @JsonIgnore
    @OneToOne(mappedBy = "customerAddress")
    private Customer customer;

}
