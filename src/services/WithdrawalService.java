package services;

import models.BankAccount;
import util.Printer;

import java.util.Scanner;

public class WithdrawalService {
    public static void runWithdrawal(BankAccount bankAccount, Scanner scanner) {
        try {
            System.out.print("Enter amount to withdraw: ");

            String line = scanner.nextLine();
            System.out.println();

            if (line.equalsIgnoreCase("q")) {
                return;
            }

            double amountToWithdraw = Double.parseDouble(line);

            if (amountToWithdraw < 0) {
                throw new Exception("Amount can't be negative");
            }

            if (!bankAccount.canWithdraw(amountToWithdraw)) {
                Printer.printDashLine();
                System.out.println("Insufficient balance");
                Printer.printDashLine();
                System.out.println();
                return;
            }

            bankAccount.withdraw(amountToWithdraw);

            Printer.printDashLine();
            System.out.println("Withdrawal successful!");
            Printer.printDashLine();

            AccountBalanceService.displayAccountBalance(bankAccount);

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid amount");
            runWithdrawal(bankAccount, scanner);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            runWithdrawal(bankAccount, scanner);
        }
    }
}
