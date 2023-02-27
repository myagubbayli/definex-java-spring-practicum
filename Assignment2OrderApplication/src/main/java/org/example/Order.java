package org.example;

import java.time.LocalDate;

public class Order {
    private final Customer customer;
    private final LocalDate orderDate;
    private final double amount;

    public Order(Customer customer, LocalDate orderDate, double amount) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "- customer: " + customer.getName() + "\n" +
                "  orderDate: " + orderDate + "\n" +
                "  amount: " + amount;
    }
}
