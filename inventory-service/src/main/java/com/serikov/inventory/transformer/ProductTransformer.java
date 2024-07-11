package com.serikov.inventory.transformer;

import com.serikov.dto.ProductDTO;
import com.serikov.inventory.entity.Product;

public interface ProductTransformer {
    Product transformToEntity(ProductDTO requestDTO);

    ProductDTO transformToProductDto(Product productEntity);
}
