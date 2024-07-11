package com.serikov.inventory.transformer;

import com.serikov.dto.ProductDTO;
import com.serikov.inventory.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductTransformerImpl implements ProductTransformer {
    @Override
    public Product transformToEntity(ProductDTO requestDTO) {
        final Product productEntity = new Product();
        productEntity.setDescription(requestDTO.getDescription());
        productEntity.setType(requestDTO.getType());
        productEntity.setWeight(requestDTO.getWeight());

        return productEntity;
    }

    @Override
    public ProductDTO transformToProductDto(Product productEntity) {
        final ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productEntity.getId());
        productDTO.setDescription(productEntity.getDescription());
        productDTO.setType(productEntity.getType());
        productDTO.setWeight(productEntity.getWeight());

        return productDTO;
    }
}
