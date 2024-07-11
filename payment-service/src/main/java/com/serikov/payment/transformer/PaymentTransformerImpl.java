package com.serikov.payment.transformer;

import com.serikov.dto.PaymentResponseDTO;
import com.serikov.payment.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentTransformerImpl implements PaymentTransformer {
    @Override
    public PaymentResponseDTO transformEntityToResponse(Payment payment) {
        PaymentResponseDTO responseDTO = new PaymentResponseDTO();
        responseDTO.setAmount(payment.getAmount());
        responseDTO.setUserId(payment.getUserId());
        responseDTO.setOrderId(payment.getId());
        responseDTO.setStatus(payment.getStatus());
        return responseDTO;
    }
}
