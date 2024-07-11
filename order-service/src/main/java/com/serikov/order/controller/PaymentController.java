package com.serikov.order.controller;

import com.serikov.dto.PaymentResponseDTO;
import com.serikov.order.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @GetMapping()
    public List<PaymentResponseDTO> getOrders(@RequestParam(name = "userId") final Integer userId) {
        return service.getAllByUserId(userId);
    }

}
