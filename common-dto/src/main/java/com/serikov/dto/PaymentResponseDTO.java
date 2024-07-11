package com.serikov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.serikov.enums.PaymentStatus;
import lombok.Data;

import java.util.UUID;

@Data
@JsonPropertyOrder({"userId", "orderId", "amount", "status"})
public class PaymentResponseDTO {
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("orderId")
    private UUID orderId;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("status")
    private PaymentStatus status;
}
