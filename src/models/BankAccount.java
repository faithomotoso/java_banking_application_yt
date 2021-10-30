package models;

import java.math.BigDecimal;

public class BankAccount {
    private String customerName;
    private String accountNumber;
    private String pin = "1244"; // Default pin
    private final BigDecimal accountBalance = BigDecimal.ZERO;
    private Transaction lastTransaction;

    public BankAccount(String customerName, String accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

    public BigDecimal getAccountBalance() {
        return this.accountBalance;
    }

    public Transaction getLastTransaction() {
        return this.lastTransaction;
    }
}
