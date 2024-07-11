package com.serikov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.UUID;

@Data
@JsonPropertyOrder({"userId", "orderId", "amount"})
public class PaymentRequestDTO {
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("orderId")
    private UUID orderId;
    @JsonProperty("amount")
    private Double amount;
}
