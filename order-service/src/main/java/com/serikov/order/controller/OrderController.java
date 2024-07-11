package com.serikov.order.controller;

import com.serikov.dto.OrderRequestDTO;
import com.serikov.dto.OrderResponseDTO;
import com.serikov.order.entity.PurchaseOrder;
import com.serikov.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("order")
@AllArgsConstructor
public class OrderController {

    private OrderService service;

    @PostMapping("/create")
    public PurchaseOrder createOrder(@RequestBody OrderRequestDTO requestDTO) {
        requestDTO.setOrderId(UUID.randomUUID());
        return this.service.createOrder(requestDTO);
    }

    @GetMapping("/all")
    public List<OrderResponseDTO> getOrders() {
        return this.service.getAll();
    }

}
