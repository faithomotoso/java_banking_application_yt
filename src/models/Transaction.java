package models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final BigDecimal amount;
    private final TransactionType transactionType;
    private final LocalDateTime transactionDate;

    Transaction(double amount, TransactionType transactionType) {
        this.amount = BigDecimal.valueOf(amount);
        this.transactionType = transactionType;
        this.transactionDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return transactionType + "\n" + "Amount: " + this.amount + "\n" +
                "Date: " + transactionDate;
    }
}

