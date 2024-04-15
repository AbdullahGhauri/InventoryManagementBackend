package com.project.inventorymanagement.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "userNumber")
    private String userNumber;
    @Column(name = "userCNIC")
    private String userCNIC;
    @Column(name = "userType")
    private String userType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userAddressId")
    private Address userAddress;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private ProductSupplier productSupplier;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private ProductSale productSale;



}
