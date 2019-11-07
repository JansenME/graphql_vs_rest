package com.demo.graphql.backends;

import com.demo.graphql.model.Account;
import com.demo.graphql.model.Balance;
import com.demo.graphql.model.Currency;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceInformation {
    private static final BigDecimal MIN = BigDecimal.valueOf(0);
    private static final BigDecimal MAX = BigDecimal.valueOf(10000);

    public static Map<Account, Balance> addBalancesToAccounts(final List<Account> accounts) {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Map<Account, Balance> map = new HashMap<>();

        accounts.forEach(account -> addBalance(account, map));

        return map;
    }

    private static void addBalance(final Account account, final Map<Account, Balance> map) {
        map.put(account, new Balance(getRandomAmount(), Currency.randomCurrency().name()));
    }

    private static BigDecimal getRandomAmount() {
        BigDecimal randomBigDecimal = MIN.add(BigDecimal.valueOf(Math.random()).multiply(MAX.subtract(MIN)));
        return randomBigDecimal.setScale(2, BigDecimal.ROUND_UP);
    }
}
