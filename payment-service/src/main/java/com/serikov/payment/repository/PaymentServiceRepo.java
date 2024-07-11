package com.serikov.payment.repository;

import com.serikov.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentServiceRepo extends JpaRepository<Payment, UUID> {

    List<Payment> findAlByUserId(Integer userId);
}
