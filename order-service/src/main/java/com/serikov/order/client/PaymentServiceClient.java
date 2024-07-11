package com.serikov.order.client;

import com.serikov.dto.PaymentResponseDTO;
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
public class PaymentServiceClient {

    private final String inventoryServiceUrl;
    private final RestTemplate template;

    @Autowired
    public PaymentServiceClient(final RestTemplateBuilder builder, @Value("${service.endpoints.payment}") final String inventoryServiceUrl) {
        this.template = builder.build();
        this.inventoryServiceUrl = inventoryServiceUrl;
    }

    public List<PaymentResponseDTO> getAllPaymentOrders(final Integer userId) {
        PaymentResponseDTO[] paymentOrders = template.getForObject(inventoryServiceUrl + "/payment?userId=" + userId, PaymentResponseDTO[].class);
        if (paymentOrders == null) {
            return emptyList();
        }
        return stream(paymentOrders).collect(Collectors.toList());
    }
}
