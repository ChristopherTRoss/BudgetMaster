package com.budgetmaster.budgetmaster;

/**
 * Created by scine on 11/6/2016.
 */

public class Income {
    private double amount;
    private String title, description;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Income(double amount, String title, String description) {

        this.amount = amount;
        this.title = title;
        this.description = description;
    }
}
