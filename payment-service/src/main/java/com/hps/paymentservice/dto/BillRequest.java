package com.hps.paymentservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BillRequest {

    private String phone;

    private Long clientId;

    private Long orderId;

    private BigDecimal amount;

}
