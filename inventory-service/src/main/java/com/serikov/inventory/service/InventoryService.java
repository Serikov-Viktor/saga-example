package com.serikov.inventory.service;

import com.serikov.dto.InventoryRequestDTO;
import com.serikov.dto.InventoryResponseDTO;
import com.serikov.enums.InventoryStatus;
import com.serikov.inventory.entity.InventoryOrder;
import com.serikov.inventory.entity.Product;
import com.serikov.inventory.exception.ProductNotFoundException;
import com.serikov.inventory.repository.InventoryServiceRepo;
import com.serikov.inventory.repository.ProductRepo;
import com.serikov.inventory.transformer.InventoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.serikov.enums.InventoryStatus.AVAILABLE;
import static com.serikov.enums.InventoryStatus.UNAVAILABLE;

@Slf4j
@Service
@AllArgsConstructor
public class InventoryService {

    private static final Integer INVENTORY_LIMIT = 3;

    private final InventoryServiceRepo inventoryRepo;
    private final ProductRepo productRepo;
    private final InventoryTransformer transformer;

    public InventoryResponseDTO deductInventory(final InventoryRequestDTO requestDTO) {

        final int inventoryAmountPerUser = (int) inventoryRepo.findAllByProductId(requestDTO.getProductId())
                .stream()
                .filter(inventoryOrder -> Objects.equals(inventoryOrder.getProduct().getId(), requestDTO.getProductId()))
                .filter(inventoryOrder -> AVAILABLE.equals(inventoryOrder.getStatus()))
                .count();

        Product product = productRepo.findById(requestDTO.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Not such product with Id: " + requestDTO.getProductId()));

        final InventoryOrder paymentEntity = new InventoryOrder();
        paymentEntity.setUserId(requestDTO.getUserId());
        paymentEntity.setId(requestDTO.getOrderId());
        paymentEntity.setProduct(product);
        paymentEntity.setStatus(inventoryAmountPerUser + 1 < INVENTORY_LIMIT ? AVAILABLE : UNAVAILABLE);

        inventoryRepo.save(paymentEntity);
        return transformer.transformEntityToResponse(paymentEntity);
    }

    public void revertInventory(final InventoryRequestDTO requestDTO) {
        Optional<InventoryOrder> inventoryOrder = inventoryRepo.findById(requestDTO.getOrderId());
        inventoryOrder.ifPresent(inventory -> inventory.setStatus(UNAVAILABLE));
    }

    public List<InventoryResponseDTO> getAllByUserId(final Integer userId) {
        return inventoryRepo.findAllByUserId(userId).stream()
                .map(transformer::transformEntityToResponse)
                .collect(Collectors.toList());
    }
}
