package com.serikov.inventory.service;

import com.serikov.dto.ProductDTO;
import com.serikov.inventory.entity.Product;
import com.serikov.inventory.repository.ProductRepo;
import com.serikov.inventory.transformer.ProductTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductTransformer transformer;

    public ProductDTO addProduct(final ProductDTO requestDTO) {
        Product ProductEntity = productRepo.save(transformer.transformToEntity(requestDTO));
        return transformer.transformToProductDto(ProductEntity);
    }

    public List<ProductDTO> getAll() {
        return productRepo.findAll().stream()
                .map(transformer::transformToProductDto)
                .collect(Collectors.toList());
    }
}
