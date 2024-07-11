package com.serikov.order.controller;

import com.serikov.dto.InventoryResponseDTO;
import com.serikov.order.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("inventory")
@AllArgsConstructor
public class InventoryOrderController {

    private ProductService service;

    @GetMapping()
    public List<InventoryResponseDTO> getAllInventoryOrdersByUserId
            (@RequestParam(name = "userId") final Integer userId) {
        log.info("Get all inventory orders by user Id: " + userId);
        return service.getAllInventoryOrdersByUserId(userId);
    }
}
