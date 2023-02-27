package org.example;

public class Invoice {
    private final Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public double getTotal() {
        return order.getAmount();
    }

    @Override
    public String toString() {
        return "- customer: " + order.getCustomer().getName() + ", " +
                "  orderDate: " + order.getOrderDate() + ", " +
                "  amount: " + order.getAmount();
    }
}
