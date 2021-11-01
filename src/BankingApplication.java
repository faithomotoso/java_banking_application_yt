import models.BankAccount;
import services.*;
import util.Printer;

import java.util.Arrays;
import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("Frank Castle", "1994881994");

        char option;
        System.out.println("Welcome " + bankAccount.getCustomerName() + "!\n");


        Scanner scanner = new Scanner(System.in);

        do {
            showOptions();

            option = scanner.nextLine().toLowerCase().charAt(0);
            System.out.println();

            // To exit the application
            if (option == 'q') {
                Printer.printDashLine();
                System.out.println("Thank you! Have a nice day!");
                Printer.printDashLine();
                break;
            }

            // For every transaction, authenticate
            if (PinAuthService.authenticate(bankAccount, scanner))
                switch (option) {
                    case '1' ->
                            // Print account balance
                            AccountBalanceService.displayAccountBalance(bankAccount);


                    case '2' ->
                            // Run deposit operation
                            DepositService.runDeposit(bankAccount, scanner);

                    case '3' ->
                            // Run withdrawal operation
                            WithdrawalService.runWithdrawal(bankAccount, scanner);


                    case '4' ->
                            // View last transaction
                            LastTransactionService.displayLastTransaction(bankAccount);


                    default -> System.out.println("Invalid option. Try again.");
                }
            else {
                break;
            }
            System.out.println();

        } while (true);

        scanner.close();
    }

    static void showOptions() {
        String[] options = {
                "1. Check balance",
                "2. Deposit",
                "3. Withdraw",
                "4. View last transaction",
                "Q. Exit"
        };

        System.out.println("Please select an option");
        Printer.printEqualsLine();
        Arrays.stream(options).forEach(System.out::println);
        Printer.printEqualsLine();
    }

}
