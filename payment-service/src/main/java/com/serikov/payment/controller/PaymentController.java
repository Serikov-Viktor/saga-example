package com.serikov.payment.controller;

import com.serikov.dto.PaymentRequestDTO;
import com.serikov.dto.PaymentResponseDTO;
import com.serikov.enums.PaymentStatus;
import com.serikov.payment.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("payment")
@AllArgsConstructor
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/debit")
    public PaymentResponseDTO debit(@RequestBody PaymentRequestDTO requestDTO) {
        log.info("Process payment debit for request: " + requestDTO);
        return service.debit(requestDTO);
    }

    @PostMapping("/reverse")
    public void credit(@RequestBody PaymentRequestDTO requestDTO) {
        log.info("Reverse payment for request: " + requestDTO);
        this.service.reversePayment(requestDTO);
    }

    @GetMapping
    public List<PaymentResponseDTO> getAllPaymentOrdersByUserId(
            @RequestParam(name = "userId") final Integer userId) {
        log.info("Get all payment orders by user id");
        return this.service.getAllPaymentOrdersByUserId(userId);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int counter1 = 0;
        int counter2 = 0;

        int[] calculatedarray = new int[n+m];

        for(int i = 0; i <= n+m; i++) {

            if(nums1[counter1] > nums2[counter2]){
                calculatedarray[i] = nums1[counter1];
                counter1++;
            } else{
                calculatedarray[i] = nums2[counter2];
                counter2++;
            }

        };
        nums1 = calculatedarray;
    }

}
