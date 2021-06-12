package domain;

import java.util.ArrayList;

public class Customer {

    // instance fields
    private final String name;
    ArrayList<Double> transactionArrayList;

    // constructor
    public Customer(String name, double deposit) {
        this.name = name;
        this.transactionArrayList = new ArrayList<>();
        this.transactionArrayList.add(deposit);
    }

    // getters and setters

    public String getName() {
        return name;
    }

    /**
     * Factory / convenience method: accessible within Menu without creating customer object.
     * Invokes Customer constructor.
     * @param name of customer
     * @param deposit initial transaction / opening deposit
     * @return Customer object
     */
    public static Customer createCustomer(String name, double deposit) {
        return new Customer(name, deposit);
    }

    @Override
    public String toString() {
        return "Customer Name: " + name + "\nCustomer Transactions:\t" + transactionArrayList + "\n";
    }
}
