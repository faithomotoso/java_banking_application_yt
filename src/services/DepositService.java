package services;

import models.BankAccount;
import util.Printer;

import java.util.Scanner;

public class DepositService {

    public static void runDeposit(BankAccount bankAccount, Scanner scanner) {
        try {
            System.out.print("Enter amount to deposit: ");
            double amountToDeposit = Double.parseDouble(scanner.nextLine());

            if (amountToDeposit < 0) {
                throw new Exception("Amount can't be negative");
            }

            bankAccount.deposit(amountToDeposit);

            Printer.printDashLine();
            System.out.println("You just deposited " + amountToDeposit);
            Printer.printDashLine();


            System.out.println();
            AccountBalanceService.displayAccountBalance(bankAccount);

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount");
            runDeposit(bankAccount, scanner);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            runDeposit(bankAccount, scanner);
        }
    }
}
