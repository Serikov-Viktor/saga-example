package com.serikov.order.service;

import com.serikov.dto.InventoryResponseDTO;
import com.serikov.dto.ProductDTO;
import com.serikov.order.client.ProductServiceClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductServiceClient productServiceClient;

    public ProductDTO addProduct(final ProductDTO requestDTO) {
        return productServiceClient.addProduct(requestDTO);
    }

    public List<ProductDTO> getAll() {
        return productServiceClient.getAllProducts();
    }

    public List<InventoryResponseDTO> getAllInventoryOrdersByUserId(Integer userId) {
        return productServiceClient.getAllInventoryOrders(userId);
    }
}
