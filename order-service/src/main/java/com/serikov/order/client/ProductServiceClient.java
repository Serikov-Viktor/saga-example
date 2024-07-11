package com.serikov.order.client;

import com.serikov.dto.InventoryResponseDTO;
import com.serikov.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;

@Component
public class ProductServiceClient {

    private final String inventoryServiceUrl;
    private final RestTemplate template;

    @Autowired
    public ProductServiceClient(final RestTemplateBuilder builder, @Value("${service.endpoints.inventory}") final String inventoryServiceUrl) {
        this.template = builder.build();
        this.inventoryServiceUrl = inventoryServiceUrl;
    }

    public ProductDTO addProduct(final ProductDTO requestDTO) {
        return template.postForObject(inventoryServiceUrl + "/product/add",
                requestDTO, ProductDTO.class);
    }

    public List<ProductDTO> getAllProducts() {
        ProductDTO[] products = template.getForObject(inventoryServiceUrl + "/product", ProductDTO[].class);
        if (products == null) {
            return emptyList();
        }
        return stream(products).collect(Collectors.toList());
    }

    public List<InventoryResponseDTO> getAllInventoryOrders(final Integer userId) {
        InventoryResponseDTO[] products = template
                .getForObject(inventoryServiceUrl + "/inventory?userId=" + userId, InventoryResponseDTO[].class);
        if (products == null) {
            return emptyList();
        }
        return stream(products).collect(Collectors.toList());
    }
}
