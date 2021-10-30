import models.BankAccount;
import util.Printer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount("Frank Castle", "1994881994");

        char option = 0;
        System.out.println("Welcome " + bankAccount.getCustomerName() +"!\n");

        Scanner scanner = new Scanner(System.in);

        do {
            option = scanner.nextLine().toLowerCase().charAt(0);

            switch (option) {
                case '1' -> {
                    // Print account balance
                }

                case '2' -> {
                    // Run deposit operation
                }

                case '3' -> {
                    // Run withdrawal operation
                }

                case '4' -> {
                    // View last transaction
                }

                default -> {
                    System.out.println();
                }
            }

        } while (option != 'q');
    }

    void showOptions() {
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
