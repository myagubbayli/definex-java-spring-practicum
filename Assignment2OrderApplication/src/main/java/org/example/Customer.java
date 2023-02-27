package org.example;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final LocalDate signUpDate;
    private final String company;

    public Customer(String name, LocalDate signUpDate, String company) {
        this.name = name;
        this.signUpDate = signUpDate;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public LocalDate getSignUpDate() {
        return signUpDate;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", signUpDate=" + signUpDate +
                ", company='" + company + '\'' +
                '}';
    }
}
