package com.serikov.order.service;

import com.serikov.dto.OrderResponseDTO;
import com.serikov.dto.PaymentResponseDTO;
import com.serikov.order.client.PaymentServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentServiceClient paymentServiceClient;

    public List<PaymentResponseDTO> getAllByUserId(final Integer userId) {

       return paymentServiceClient.getAllPaymentOrders(userId);
    }
}
