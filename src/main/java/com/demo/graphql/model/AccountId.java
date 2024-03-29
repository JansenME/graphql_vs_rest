package com.demo.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountId {
    private String accountNumber;
    private String currencyCode;
    private String bic;
}
