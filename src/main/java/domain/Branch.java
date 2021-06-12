package domain;

import java.util.ArrayList;

public class Branch {

    // instance fields
    private final String name;
    private final ArrayList<Customer> customers;

    // constructor

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    // getters and setters

    public String getName() {
        return name;
    }

    // methods

    /**
     * Creates a new customer object and adds this to the customer list of a given branch.A
     * @param newCustomer specified by user
     * @param deposit specified by user
     */
    public void addCustomer(String newCustomer, double deposit) {
        this.customers.add(new Customer(newCustomer, deposit));
    }

    public void addTransaction(String customerName, double deposit) {
        // get index value pertaining to customer object
        int index = getIndexValue(customerName);
        // if customer exists
        if (index != -1) {
            // update customer object calling method within Customer class
            this.customers.get(index).addTransaction(deposit);
        }
    }

    /**
     * Checks branch for specific customer name specified by user.
     * @param name specified name
     * @return boolean is customer
     */
    public boolean searchCustomers(String name) {
        int index = getIndexValue(name);
        return index != -1;
    }

    /**
     * Prints a list of customers to console for a given branch.
     */
    public void printCustomers() {
        for (Customer customer:
                this.customers) {
            System.out.println(customer.getName());
        }
    }

    /**
     * Prints a list customers and their respective transactions to the console
     * for a given branch.
     */
    public void printCustomersTransactions() {
        for (Customer customer:
                this.customers) {
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
                this.customers) {
            if (customer.getName().equals(customerName)) {
                return this.customers.indexOf(customer);
            }
        }
        return -1;
    }
}
