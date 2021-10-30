package services;
import models.BankAccount;
import util.Printer;
import java.text.NumberFormat;

/**
 * Displays the account balance
 */

public class AccountBalanceService {

    public static void displayAccountBalance(BankAccount bankAccount) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        Printer.printDashLine();
        System.out.println("Account balance: " + numberFormat.format(bankAccount.getAccountBalance()));
        Printer.printDashLine();
    }
}
