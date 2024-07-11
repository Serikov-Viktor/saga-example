package com.serikov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.serikov.enums.ProductType;
import lombok.Data;

@Data
@JsonPropertyOrder({"id", "description", "weight", "type"})
public class ProductDTO {
    @JsonProperty("id")
    Integer id;
    @JsonProperty("description")
    String description;
    @JsonProperty("weight")
    Double weight;
    @JsonProperty("type")
    ProductType type;

}
