package services;

import models.BankAccount;
import util.Printer;

import java.util.Scanner;

/**
 * For pin authentication before performing a transaction
 */
public class PinAuthService {
    private static final int MAX_TRIES = 3;

    public static boolean authenticate(BankAccount bankAccount, Scanner scanner) {
        int numberOfTries = 1;

        while (numberOfTries <= MAX_TRIES) {


            try {
                System.out.print("Input your pin: ");

                String pinInput = scanner.nextLine();

                System.out.println();

                if (pinInput.length() > 4)
                    throw new Exception("Pin can't be more than 4 digits");
                else if (pinInput.length() < 4)
                    throw new Exception("Please enter your complete pin");

                // Confirm if it's a valid number
                int conv = Integer.parseInt(pinInput);

                if (bankAccount.verifyPin(pinInput))
                    return true;
                else if (MAX_TRIES - numberOfTries > 0) {
                    Printer.printDashLine();
                    System.out.println("Incorrect pin! You have " + (MAX_TRIES - numberOfTries) +
                            " attempt(s) left");
                    Printer.printDashLine();
                }

                System.out.println();

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
            catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println();
            }

            numberOfTries++;
        }
        Printer.printDashLine();
        System.out.println("You've maxed out the number of attempts.\nPlease try again later");
        Printer.printDashLine();
        return false;

    }
}
