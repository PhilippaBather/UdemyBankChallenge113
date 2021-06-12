package domain;

import java.util.ArrayList;

public class Customer {

    // instance fields
    private final String name;
    private final ArrayList<Double> transactionArrayList;

    // constructor
    public Customer(String name, double deposit) {
        this.name = name;
        this.transactionArrayList = new ArrayList<>();
        addTransaction(deposit);
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void addTransaction(double deposit) {
        this.transactionArrayList.add(deposit);
    }

    @Override
    public String toString() {
        return "Customer Name: " + name + "\nCustomer Transactions:\t" + transactionArrayList + "\n";
    }
}
