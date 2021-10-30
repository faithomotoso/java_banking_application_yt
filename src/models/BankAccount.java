package models;

import java.math.BigDecimal;

public class BankAccount {
    private String customerName;
    private String accountNumber;
    private String pin = "1244"; // Default pin
    private BigDecimal accountBalance = BigDecimal.valueOf(39939.91);
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

    public void deposit(double amount) {
        this.accountBalance = this.accountBalance.add(BigDecimal.valueOf(amount));
        this.lastTransaction = new Transaction(amount, TransactionType.DEPOSIT);
    }

    public void withdraw(double amount) {
        this.accountBalance = this.accountBalance.subtract(BigDecimal.valueOf(amount));
        this.lastTransaction = new Transaction(amount, TransactionType.WITHDRAWAL);
    }

    /**
     * Checks to see if amount to withdraw is lower than current balance
     * @param amount - amount to withdraw
     * @return true if amount is lower, false if it is not
     */
    public boolean canWithdraw(double amount) {
        return this.accountBalance.compareTo(BigDecimal.valueOf(amount)) == 1;
    }
}
