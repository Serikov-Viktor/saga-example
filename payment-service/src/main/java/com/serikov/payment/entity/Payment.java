package com.serikov.payment.entity;

import com.serikov.enums.PaymentStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@ToString
public class Payment {

    @Id
    private UUID id;
    private Integer userId;
    private Double amount;
    private PaymentStatus status;

}