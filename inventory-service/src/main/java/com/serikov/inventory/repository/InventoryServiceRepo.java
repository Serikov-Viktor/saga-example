package com.serikov.inventory.repository;

import com.serikov.enums.InventoryStatus;
import com.serikov.inventory.entity.InventoryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InventoryServiceRepo extends JpaRepository<InventoryOrder, UUID> {

    List<InventoryOrder> findAllByProductId(Integer productId);
    List<InventoryOrder> findAllByStatus(InventoryStatus status);
    List<InventoryOrder> findAllByUserId(Integer userId);
}
