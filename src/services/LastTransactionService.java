package services;

import models.BankAccount;
import util.Printer;

public class LastTransactionService {

    public static void displayLastTransaction(BankAccount bankAccount) {
        Printer.printDashLine();
        if (bankAccount.getLastTransaction() == null) {
            System.out.println("No transaction available.");
        } else {
            System.out.println("Last transaction");
            System.out.println(bankAccount.getLastTransaction());
        }
        Printer.printDashLine();
    }
}
