import models.BankAccount;
import services.*;
import util.Printer;

import java.util.Arrays;
import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        boolean run = true;

        BankAccount bankAccount = new BankAccount("Frank Castle", "1994881994");

        char option;
        System.out.println("Welcome " + bankAccount.getCustomerName() + "!\n");


        Scanner scanner = new Scanner(System.in);

        while(run) {
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

            switch (option) {
                case '1', '2', '3', '4' -> {
                    // For every transaction, authenticate
                    if (PinAuthService.authenticate(bankAccount, scanner)) {
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

                        }
                    }
                    else {
                        // break doesn't, work most likely because of the inner switch
                        run = false;
                    }
                }
                default -> {
                    Printer.printDashLine();
                    System.out.println("Invalid option. Try again.");
                    Printer.printDashLine();
                }
            }
            System.out.println();

        }

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
