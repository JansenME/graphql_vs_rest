package com.demo.graphql.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Balance {
    private final BigDecimal amount;
    private final String currencyCode;
}
