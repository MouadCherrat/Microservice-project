package com.hps.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillResponse {

    private Long id;
    private BigDecimal totalAmount;
    private Long clientId;
    private Long orderId;
}
