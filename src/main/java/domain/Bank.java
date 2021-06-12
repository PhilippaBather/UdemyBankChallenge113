package domain;

import java.util.ArrayList;

public class Bank {

    // instance fields
    ArrayList<Branch> bankArrayList;

    // constructor
    public Bank() {
        bankArrayList = new ArrayList<>();
    }

    // methods

    /**
     * Adds a new branch.
     */
    public void addBranch(Branch branch) {
        bankArrayList.add(branch);
    }

    /**
     * Add a customer with an initial transaction to a given branch.
     */
    public void addCustomerToBranch(String branchName, Customer customer) {
        // get index of branch object in array
        int index = getBranchIndex(branchName);
        // add customer to branch object
        bankArrayList.get(index).addCustomerObject(customer);
    }

    /**
     * Add a transaction to customer's transactions array list.
     * @param branchName specified by user
     * @param customerName specified by user
     * @param deposit specified by user
     * @return boolean transaction successful
     */
    public void addTransaction(String branchName, String customerName, double deposit) {
        // get index value of branch object in bank array list
        int branchIndex = getBranchIndex(branchName);
        // if branch exist, update transaction history for specified customer
        if (branchIndex != -1) {
            bankArrayList.get(branchIndex).addTransaction(customerName, deposit);
        }
    }

    /**
     * Prints to the console a list of customers of a specified branch.
     * @param branchName name of specified branch
     */
    public void printBranchCustomers(String branchName) {
        int index = getBranchIndex(branchName);
        System.out.println("\n*****\tCustomers at Branch " + branchName + "\t*****");
        if (index != -1) {
            bankArrayList.get(index).printCustomers();
        }
    }

    /**
     * Prints all customers and their transactions of a specified branch.
     * @param branchName specified by user
     */
    public void printBranchCustomersAndTransactions(String branchName) {
        int index = getBranchIndex(branchName);
        System.out.println("\n*****\tCustomers and Transactions at Branch " + branchName + "\t*****");
        if (index != -1) {
            bankArrayList.get(index).printCustomersTransactions();
        }
    }

    /**
     * Prints all branches within bank array list.
     */
    public void printAllBranches() {
        System.out.println("\n*****\tBRANCHES\t*****");
        for (Branch branch : bankArrayList) {
            System.out.println("Branch : " + branch.getName());
        }
    }

    /**
     * Searches branch according to specified string within the
     * bank array list.
     * @param branchName branch to be searched
     * @return boolean branch exists
     */
    public boolean searchBranches(String branchName) {
        // check branch exists by querying index value of given name
        int index = getBranchIndex(branchName);
        return (index != -1);

    }

    /**
     * Search to see if a customer exists.
     * @param branchName to which customer belongs
     * @param customerName customer's name
     * @return boolean is customer
     */
    public boolean searchCustomers(String branchName, String customerName) {
        int branchIndex = getBranchIndex(branchName);
        if (branchIndex != -1) {
            return bankArrayList.get(branchIndex).searchCustomers(customerName);
        }
        return false;
    }

    /**
    * Returns the index value of a branch within the bank array
    * list if present; returns -1 if not found.
    * @param branchName of specified branch
    * @return int index value
    */
    private int getBranchIndex(String branchName) {
        int index = -1;
        for (Branch branch : bankArrayList) {
            if (branch.getName().equals(branchName)) {
                index = bankArrayList.indexOf(branch);
                return index;
            }
        }
        return index;
    }
}
