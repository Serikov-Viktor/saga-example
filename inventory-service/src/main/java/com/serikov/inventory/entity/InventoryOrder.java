package com.serikov.inventory.entity;

import com.serikov.enums.InventoryStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@ToString
@Table(name = "inventory_order")
public class InventoryOrder {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "user_id")
    private Integer userId;
    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="product_id")
    private Product product;
    @Column(name = "status")
    private InventoryStatus status;
}