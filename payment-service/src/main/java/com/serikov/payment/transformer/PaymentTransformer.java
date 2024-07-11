package com.serikov.payment.transformer;

import com.serikov.dto.PaymentResponseDTO;
import com.serikov.payment.entity.Payment;

public interface PaymentTransformer {

    PaymentResponseDTO transformEntityToResponse(Payment payment);
}
