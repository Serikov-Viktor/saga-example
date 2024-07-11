package com.serikov.payment.service;

import com.serikov.dto.PaymentRequestDTO;
import com.serikov.dto.PaymentResponseDTO;
import com.serikov.payment.entity.Payment;
import com.serikov.payment.repository.PaymentServiceRepo;
import com.serikov.payment.transformer.PaymentTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.serikov.enums.PaymentStatus.PAYMENT_APPROVED;
import static com.serikov.enums.PaymentStatus.PAYMENT_REJECTED;

@Slf4j
@Service
@AllArgsConstructor
public class PaymentService {

    private static final Double MAX_DEBIT_AMOUNT = 1000.0;

    private final PaymentServiceRepo repository;
    private final PaymentTransformer transformer;

    public PaymentResponseDTO debit(final PaymentRequestDTO requestDTO) {

        final Double debitSum = repository.findAlByUserId(requestDTO.getUserId())
                .stream()
                .filter(payment -> PAYMENT_APPROVED.equals(payment.getStatus()))
                .map(Payment::getAmount).mapToDouble(f -> f).sum();

        final Payment paymentEntity = new Payment();
        paymentEntity.setAmount(requestDTO.getAmount());
        paymentEntity.setUserId(requestDTO.getUserId());
        paymentEntity.setId(requestDTO.getOrderId());
        paymentEntity.setStatus(debitSum + requestDTO.getAmount() < MAX_DEBIT_AMOUNT ? PAYMENT_APPROVED : PAYMENT_REJECTED);

        repository.save(paymentEntity);
        return transformer.transformEntityToResponse(paymentEntity);

    }

    public void reversePayment(final PaymentRequestDTO requestDTO) {
        Optional<Payment> payment = repository.findById(requestDTO.getOrderId());
        payment.ifPresent(p -> p.setStatus(PAYMENT_REJECTED));
    }


    public List<PaymentResponseDTO> getAllPaymentOrdersByUserId(Integer userId) {
        return repository.findAlByUserId(userId).stream()
                .map(transformer::transformEntityToResponse)
                .collect(Collectors.toList());
    }
}
