package com.serikov.inventory.controller;

import com.serikov.dto.ProductDTO;
import com.serikov.inventory.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public ProductDTO deduct(@RequestBody final ProductDTO requestDTO) {
        log.info("Add product to inventory: " + requestDTO);
        return service.addProduct(requestDTO);
    }

    @GetMapping()
    public List<ProductDTO> getAll() {
        log.info("Get all rows");
        return service.getAll();
    }
}
