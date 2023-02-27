package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class OrderApplication {
    private final List<Customer> customers;
    private final List<Order> orders;
    private final Set<Invoice> invoices;

    public OrderApplication() {
        customers = new ArrayList<>();
        orders = new ArrayList<>();
        invoices = new HashSet<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void createOrder(Customer customer, LocalDate orderDate, double amount) {
        Order order = new Order(customer, orderDate, amount);
        orders.add(order);
        Invoice invoice = new Invoice(order);
        invoices.add(invoice);
    }

    public List<Customer> listCustomers() {
        return customers;
    }

    public List<Customer> listCustomersContaining(String letter) {
        return customers.stream()
                .filter(customer -> customer.getName().contains(letter))
                .toList();
    }

    public List<Invoice> listInvoices() {
        return new ArrayList<>(invoices);
    }

    public List<Invoice> listInvoicesAbove(double amount) {
        return invoices.stream()
                .filter(invoice -> invoice.getTotal() > amount)
                .toList();
    }

    public double getAverageInvoiceTotalAbove(double amount) {
        return invoices.stream()
                .filter(invoice -> invoice.getTotal() > amount)
                .mapToDouble(Invoice::getTotal)
                .average()
                .orElse(0);
    }

    public List<Customer> listCustomersWithInvoiceTotalBelow(double amount) {
        return invoices.stream()
                .filter(invoice -> invoice.getTotal() < amount)
                .map(invoice -> invoice.getOrder().getCustomer())
                .distinct()
                .toList();
    }

    public Set<String> listCompaniesWithAverageInvoiceTotalBelow(double amount, int month) {
        Map<String, List<Invoice>> companyInvoices = new HashMap<>();
        for (Invoice invoice : invoices) {
            LocalDate orderDate = invoice.getOrder().getOrderDate();
            if (orderDate.getMonthValue() == month) {
                String company = invoice.getOrder().getCustomer().getCompany();
                companyInvoices.computeIfAbsent(company, k -> new ArrayList<>()).add(invoice);
            }
        }
        Set<String> companies = new HashSet<>();
        for (Map.Entry<String, List<Invoice>> entry : companyInvoices.entrySet()) {
            double average = entry.getValue().stream()
                    .mapToDouble(Invoice::getTotal)
                    .average()
                    .orElse(0);
            if (average < amount) {
                companies.add(entry.getKey());
            }
        }
        return companies;
    }
}
