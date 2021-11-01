package services;

import models.BankAccount;
import util.Printer;

import java.text.NumberFormat;
import java.util.Scanner;

public class DepositService {

    public static void runDeposit(BankAccount bankAccount, Scanner scanner) {
        try {
            System.out.print("Enter amount to deposit: ");
            String line = scanner.nextLine();
            System.out.println();

            if (line.equalsIgnoreCase("q")) {
                return;
            }

            double amountToDeposit = Double.parseDouble(line);

            if (amountToDeposit < 0) {
                throw new Exception("Amount can't be negative");
            }

            bankAccount.deposit(amountToDeposit);

            Printer.printDashLine();
            System.out.println("You just deposited " + NumberFormat.getInstance().format(amountToDeposit));
            Printer.printDashLine();


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
