package com.serikov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.serikov.enums.OrderStatus;
import lombok.Data;

import java.util.UUID;

@Data
@JsonPropertyOrder({"orderId", "userId", "productId", "amount", "status"})
public class OrderResponseDTO {
    @JsonProperty("orderId")
    private UUID orderId;
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("productId")
    private Integer productId;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("status")
    private OrderStatus status;

}
