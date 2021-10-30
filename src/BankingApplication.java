import models.BankAccount;
import services.AccountBalanceService;
import services.DepositService;
import util.Printer;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("Frank Castle", "1994881994");

        char option = 0;
        System.out.println("Welcome " + bankAccount.getCustomerName() +"!\n");


        Scanner scanner = new Scanner(System.in);

        do {
            showOptions();

            option = scanner.nextLine().toLowerCase().charAt(0);
            System.out.println();

            switch (option) {
                case '1' -> {
                    // Print account balance
                    AccountBalanceService.displayAccountBalance(bankAccount);
                }

                case '2' -> {
                    // Run deposit operation
                    DepositService.runDeposit(bankAccount, scanner);
                }

                case '3' -> {
                    // Run withdrawal operation
                }

                case '4' -> {
                    // View last transaction
                }

                case 'q' -> {
                    Printer.printDashLine();
                    System.out.println("Thank you! Have a nice day!");
                    Printer.printDashLine();
                }

                default -> {
                    System.out.println();
                }
            }
            System.out.println();

        } while (option != 'q');

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
