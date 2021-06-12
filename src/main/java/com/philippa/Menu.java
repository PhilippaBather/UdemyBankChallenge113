package com.philippa;

import domain.*;

import java.util.Scanner;

import static com.philippa.ValidationUtils.validateDouble;

/**
 * Class handles menu execution and user options.
 */
public class Menu {

    // member fields
    private static final Scanner scanner = new Scanner(System.in);
    private static final Bank bank = new Bank();

    // member methods

    /**
     * Executes menu interface; public as needs to be accessed by main class.
     */
    public static void executeMenu() {
        boolean exit = false;
        startUp();

        do {
            printMenu();
            System.out.println("\nEnter an option:");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "1":
                    addNewBranch();
                    break;
                case "2":
                    addNewCustomer();
                    break;
                case "3":
                    updateCustomerTransactions();
                    break;
                case "4":
                    printBranchCustomers();
                    break;
                case "5":
                    printBranchCustomersAndTransactions();
                    break;
                case "6":
                    printBranches();
                    break;
                case "x":
                    exit = true;
                    break;
                default:
                    System.out.println("Option not recognised.");
            }

        } while (!exit);

    }

    /**
     * Simulates start up of bank menu.
     */
    private static void startUp() {
        System.out.println("Menu starting up...");
    }

    /**
     * Prints menu options to console.
     */
    private static void printMenu() {
        System.out.println("\n*****\t\t\tBANK MENU\t\t\t*****");
        System.out.println("\n1. Add new branch.");
        System.out.println("2. Add new customer.");
        System.out.println("3. Update customer's transactions.");
        System.out.println("4. Print list of customers for a given branch.");
        System.out.println("5. Print list of customers and transactions for a given branch.");
        System.out.println("6. Print branches.");
        System.out.println("x. Exit");
    }

    /**
     * Adds new branch to bank.
     */
    private static void addNewBranch() {
        System.out.println("Enter branch name:");
        String newBranch = scanner.nextLine().toUpperCase();
        boolean isBranch = bank.addBranch(newBranch);
        if (isBranch) {
            System.out.println("Branch " + newBranch + " successfully added.");
        } else {
            System.out.println("Branch already exists: unable to create new branch of name " + newBranch + ".");
        }
    }

    /**
     * Adds new customer to specific bank branch if branch exists,
     * Else, notifies user that branch does not exist.
     */
    private static void addNewCustomer() {
        // obtain branch name
        System.out.println("Enter branch name:");
        String branch = scanner.nextLine().toUpperCase();
        // check branch exists: if exists attempt to add customer
        boolean isBranch = bank.searchBranches(branch);
        if (isBranch) {
            System.out.println("Enter customer name:");
            String name = scanner.nextLine().toUpperCase();
            System.out.println("Enter initial deposit:");
            double deposit = validateDouble();
            // add customer and notify user if update successful
            boolean isCustomer = bank.addCustomerToBranch(branch, name, deposit);
            if (isCustomer) {
                System.out.println("Customer added.");
            } else {
                System.out.println("Customer already exists; customer not added.");
            }
        } else {  // notify user if branch does not exist
            System.out.println("Branch not found.");
        }
    }

    /**
     * Updates an existing customer's transaction history provided branch and customer
     * exist.
     */
    private static void updateCustomerTransactions() {
        // obtain customer's branch name
        System.out.println("Enter customer's branch:");
        String branch = scanner.nextLine().toUpperCase();
        // check branch exists
        boolean isBranch = bank.searchBranches(branch);
        if (isBranch) {
            // obtain customer name
            System.out.println("Enter customer name:");
            String name = scanner.nextLine().toUpperCase();
            // check customer on file
            boolean isCustomer = bank.searchCustomers(branch, name);
            if (isCustomer) {
                // obtain deposit to be registered as next transaction
                System.out.println("Enter deposit sum:");
                double deposit = validateDouble();
                bank.addTransaction(branch, name, deposit);
                System.out.println("Transactions updated.");
            } else {
                System.out.println("Customer " + name + " does not exist; unable to process request.");
            }
        } else {
            System.out.println("Branch not found.");
        }
    }

    /**
     * Prints to console a list of customers belonging to a given branch.
     */
    private static void printBranchCustomers() {
        System.out.println("Enter branch name:");
        String branch = scanner.nextLine().toUpperCase();
        boolean isBranch = bank.printBranchCustomers(branch);
        if (!isBranch) {  // notify user if branch does not exist
            System.out.println("Branch " + branch + " not found.");
        }
    }

    /**
     * Prints to console a list of customers and their transaction history belonging
     * to a given branch.
     */
    private static void printBranchCustomersAndTransactions() {
        System.out.println("Enter branch name:");
        String branch = scanner.nextLine().toUpperCase();
        boolean isBranch = bank.printBranchCustomersAndTransactions(branch);
        if (!isBranch) {  // notify user if branch does not exist
            System.out.println("Branch " + branch + " not found.");
        }
    }

    /**
     * Prints all branches within bank array list to console.
     */
    private static void printBranches() {
        bank.printAllBranches();
    }


}
