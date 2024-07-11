package com.serikov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.UUID;

@Data
@JsonPropertyOrder({"userId", "orderId", "productId", "quality"})
public class InventoryRequestDTO {
    @JsonProperty("userId")
    private Integer userId;
    @JsonProperty("orderId")
    private UUID orderId;
    @JsonProperty("productId")
    private Integer productId;
}
