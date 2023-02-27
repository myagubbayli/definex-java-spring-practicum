package org.example;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        OrderApplication orderApplication = new OrderApplication();

        Customer customer1 = new Customer("Vedat", LocalDate.of(2022, 6, 1), "ABC Company");
        Customer customer2 = new Customer("Murat", LocalDate.of(2022, 6, 1), "DEF Company");
        Customer customer3 = new Customer("Charlie", LocalDate.of(2022, 3, 1), "GHI Company");
        Customer customer4 = new Customer("Muhammed", LocalDate.of(2022, 4, 1), "JKL Company");

        orderApplication.addCustomer(customer1);
        orderApplication.addCustomer(customer2);
        orderApplication.addCustomer(customer3);
        orderApplication.addCustomer(customer4);

        orderApplication.createOrder(customer1, LocalDate.of(2022, 1, 2), 1000);
        orderApplication.createOrder(customer2, LocalDate.of(2022, 6, 2), 500);

        orderApplication.createOrder(customer1, LocalDate.of(2022, 1, 3), 450);
        orderApplication.createOrder(customer2, LocalDate.of(2022, 6, 3), 450);
        orderApplication.createOrder(customer3, LocalDate.of(2022, 3, 3), 2500);
        orderApplication.createOrder(customer4, LocalDate.of(2022, 4, 3), 1200);

        System.out.println("List of customers:");
        orderApplication.listCustomers().forEach(System.out::println);

        System.out.println("\nList of customers contains with 'C':");
        orderApplication.listCustomersContaining("C").forEach(System.out::println);

        System.out.println("\nTotal invoice amount for customers who signed up in June: " +
                orderApplication.listCustomers().stream()
                        .filter(customer -> customer.getSignUpDate().getMonth() == Month.JUNE)
                        .mapToDouble(customer -> orderApplication.listInvoices().stream()
                                .filter(invoice -> invoice.getOrder().getCustomer().equals(customer))
                                .mapToDouble(Invoice::getTotal)
                                .sum())
                        .sum());

        System.out.println("\nList of all invoices:");
        orderApplication.listInvoices().forEach(System.out::println);

        System.out.println("\nList of invoices over 1500 TL:");
        orderApplication.listInvoicesAbove(1500).forEach(System.out::println);

        System.out.println("\nAverage invoice total over 1500 TL: " +
                orderApplication.getAverageInvoiceTotalAbove(1500));

        System.out.println("\nList of customers with invoice total below 500 TL:");
        orderApplication.listCustomersWithInvoiceTotalBelow(500).forEach(System.out::println);

        System.out.println("\nList of companies with average invoice total below 750 TL for June:");
        orderApplication.listCompaniesWithAverageInvoiceTotalBelow(750, 6).forEach(System.out::println);
    }

}