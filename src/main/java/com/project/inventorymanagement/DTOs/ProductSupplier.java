package com.project.inventorymanagement.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ProductSupplier")
public class ProductSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productSupplierId")
    private long productSupplierId;
    @ManyToOne
    @JoinColumn(name = "supplierId")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "transportExpense")
    private double transportExpense;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;


}
