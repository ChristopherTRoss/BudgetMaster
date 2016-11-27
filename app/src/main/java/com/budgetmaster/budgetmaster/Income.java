package com.budgetmaster.budgetmaster;

/****************************************************************************************/
/*
/* FILE NAME: Income
/*
/* DESCRIPTION: the class of income.  It is a subclass of Transaction, with an Income constructor
 */
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/6/2014   Jason Williams   72CF: LS           Created the class, implemented the basic functions
/* 11/7/2016  Grant Hardy      72CF: LE           Made it inherit from the Transaction class, and moved
/*                                                 the functions to the Transaction class. Added isIncome
 */
/*
/*
/*
/****************************************************************************************/

public class Income extends Transaction{
    private double amount;
    private String title, category;



    public Income(String title, String category, String date, double price)
    {
        amount = price;
        this.title = title;
        this.category = category;
        this.date = date;
    }
    @Override
    public  boolean isIncome()
    {
        return true;
    }
}
