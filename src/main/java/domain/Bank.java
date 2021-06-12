package domain;

import java.util.ArrayList;

public class Bank {

    // instance fields
    private final ArrayList<Branch> branches;

    // constructor
    public Bank() {
        this.branches = new ArrayList<>();
    }

    // methods

    /**
     * Adds a new branch provided the new branch name is not already in branches array list.
     */
    public boolean addBranch(String newBranch) {
        int index = getBranchIndex(newBranch);
        if (index == -1) {
            Branch branch = new Branch(newBranch);
            this.branches.add(branch);
            return true;
        }
        return false;
    }

    /**
     * Add a customer with an initial transaction to a given branch.
     */
    public boolean addCustomerToBranch(String branchName, String newCustomer, double deposit) {
        // get index of branch object in array
        int index = getBranchIndex(branchName);
        // check customer exists
        boolean isCustomer = this.branches.get(index).searchCustomers(newCustomer);
        if (!isCustomer) {  // add customer to branch object
            this.branches.get(index).addCustomer(newCustomer, deposit);
            return true;
        }
        return false;
    }

    /**
     * Add a transaction to customer's transactions array list.
     * @param branchName specified by user
     * @param customerName specified by user
     * @param deposit specified by user
     */
    public boolean addTransaction(String branchName, String customerName, double deposit) {
        // get index value of branch object in bank array list
        int branchIndex = getBranchIndex(branchName);
        // if branch exist, update transaction history for specified customer
        if (branchIndex != -1) {
            boolean isCustomer = searchCustomers(branchName, customerName);
            if (isCustomer) {
                this.branches.get(branchIndex).addTransaction(customerName, deposit);
                return true;
            }
        }
        return false;
    }

    /**
     * Prints to console the customers of a given branch.  Returns a boolean to indicate
     * whether or not branch exists for user notification.
     * @param branch specified by user
     * @return boolean is branch
     */
    public boolean printBranchCustomers(String branch) {
        int index = getBranchIndex(branch);
        System.out.println("\n*****\tCustomers at Branch " + branch + "\t*****");
        if (index != -1) {
            this.branches.get(index).printCustomers();
            return true;
        }
        return false;
    }

    /**
     * Prints all customers and their transactions of a specified branch.
     * @param branch specified by user
     */
    public boolean printBranchCustomersAndTransactions(String branch) {
        int index = getBranchIndex(branch);
        System.out.println("\n*****\tCustomers and Transactions at Branch " + branch + "\t*****");
        if (index != -1) {
            this.branches.get(index).printCustomersTransactions();
            return true;
        }
        return false;
    }

    /**
     * Prints all branches within bank array list.
     */
    public void printAllBranches() {
        System.out.println("\n*****\tBRANCHES\t*****");
        for (Branch branch : this.branches) {
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
     * Searches to see if a customer exists.
     * @param branchName to which customer belongs
     * @param customerName customer's name
     * @return boolean is customer
     */
    private boolean searchCustomers(String branchName, String customerName) {
        int branchIndex = getBranchIndex(branchName);
        if (branchIndex != -1) {
            return this.branches.get(branchIndex).searchCustomers(customerName);
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
        for (Branch branch : this.branches) {
            if (branch.getName().equals(branchName)) {
                index = this.branches.indexOf(branch);
                return index;
            }
        }
        return index;
    }
}
