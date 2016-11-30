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
/* 11/27/2016 Ross Thompson                       Replaced isIncome and isExpense with getType() after DB restructure
/*
/*
/****************************************************************************************/


public abstract class Transaction {
    protected double amount;
    protected String title, description, category, date, type;



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

    public String getDate(){return date;}

    public String getType() { return type; }

}
