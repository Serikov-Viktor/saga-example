package com.serikov.order.controller;

import com.serikov.dto.InventoryResponseDTO;
import com.serikov.dto.ProductDTO;
import com.serikov.enums.InventoryStatus;
import com.serikov.order.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("product")
@AllArgsConstructor
public class InventoryProductController {

    private ProductService service;

    @PostMapping("/add")
    public ProductDTO addProduct(@RequestBody final ProductDTO requestDTO) {
        log.info("Add product to inventory: " + requestDTO);
        return service.addProduct(requestDTO);
    }

    @GetMapping()
    public List<ProductDTO> getAll() {
        log.info("Get all products");
        return service.getAll();
    }
}
