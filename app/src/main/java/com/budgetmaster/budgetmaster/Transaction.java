package com.budgetmaster.budgetmaster;

/****************************************************************************************/
/*
/* FILE NAME: Transaction
/*
/* DESCRIPTION: The transaction class.  It is a superclass of income and expense that holds its basic functions.
/*                Should not be able to construct a Transaction class, only Income or Expense
 */

/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/7/2016  Grant Hardy      72CF: LE           Created the class, so Income and Expense could inherit from it
/*                                                Created the isIncome and isExpense methods
 */
/*
/*
/*
/****************************************************************************************/


public abstract class Transaction {
    protected double amount;
    protected String title, description;

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

    public boolean isIncome(){ return false;}

    public boolean isExpense(){ return false;}




}
