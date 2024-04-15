package com.project.inventorymanagement.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "AvailableProduct")
public class AvailableProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "availableProductId")
    private long availableProductId;

    @Column(name = "availableCount")
    private int availableCount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;
}
