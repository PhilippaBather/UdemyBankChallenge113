package com.philippa;

import java.util.Scanner;

/**
 * Class contains functions to validate user input.
 */
public class ValidationUtils {

    // member fields
    private static final Scanner scanner = new Scanner(System.in);

    public static double validateDouble() {
        boolean isDouble = false;
        double num = 0.0;

        do {
            String input = scanner.nextLine();
            try {
                num = Double.parseDouble(input);
                isDouble = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid number");
            }

        } while (!isDouble);
        return num;
    }
}
