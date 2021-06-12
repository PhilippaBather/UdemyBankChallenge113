package domain;

import java.util.ArrayList;

public class Branch {

    // instance fields
    String name;
    ArrayList<Customer> branchArrayList;

    // constructor

    public Branch(String name) {
        this.name = name;
        this.branchArrayList = new ArrayList<>();
    }

    // getters and setters

    public String getName() {
        return name;
    }


    // methods

    /**
     * Factory / convenience method: accessible within Menu without creating a branch object.
     * @return Branch object
     */
    public static Branch createBranchObject(String name) {
        return new Branch(name);
    }

    /**
     * Adds a new customer and initial transaction amount to the list of customers
     * within the branch.
     * @param customer new customer object
     */
    public void addCustomerObject(Customer customer) {
        this.branchArrayList.add(customer);
    }

    public void addTransaction(String customerName, double deposit) {
        // get index value pertaining to customer object
        int index = getIndexValue(customerName);
        // if customer exists
        if (index != -1){
            // update object pertaining to that customer object
            branchArrayList.get(index).transactionArrayList.add(deposit);
        }
    }

    /**
     * Checks branch for specific customer name specified by user.
     * @param name specified name
     * @return boolean is customer
     */
    public boolean searchCustomers(String name) {
        int index = getIndexValue(name);
        if (index != -1) {
            return true;
        }
        return false;
    }

    /**
     * Prints a list of customers to console for a given branch.
     */
    public void printCustomers() {
        for (Customer customer:
             branchArrayList) {
            System.out.println(customer.getName());
        }
    }

    /**
     * Prints a list customers and their respective transactions to the console
     * for a given branch.
     */
    public void printCustomersTransactions() {
        for (Customer customer:
             branchArrayList) {
            System.out.println(customer);
        }
    }

    /**
     * Returns index value of an object within the branch array list.
     * @param customerName to be queried
     * @return int index value
     */
    private int getIndexValue(String customerName) {
        for (Customer customer:
                branchArrayList) {
            if (customer.getName().equals(customerName)) {
                return branchArrayList.indexOf(customer);
            }
        }
        return -1;
    }
}
