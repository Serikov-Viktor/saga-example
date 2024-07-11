package com.serikov.inventory.transformer;

import com.serikov.dto.InventoryResponseDTO;
import com.serikov.inventory.entity.InventoryOrder;
import org.springframework.stereotype.Component;

@Component
public class InventoryTransformer {

    public InventoryResponseDTO transformEntityToResponse(InventoryOrder entity) {
        final InventoryResponseDTO responseDTO = new InventoryResponseDTO();
        responseDTO.setOrderId(entity.getId());
        responseDTO.setProductId(entity.getProduct().getId());
        responseDTO.setUserId(entity.getUserId());
        responseDTO.setStatus(entity.getStatus());
        return responseDTO;
    }
}
