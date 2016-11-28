package com.budgetmaster.budgetmaster;

/****************************************************************************************/
/*
/* FILE NAME: Expense
/*
/* DESCRIPTION: the class of expense.  It is a subclass of Transaction, with an Expense constructor
 */
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/6/2014   Jason Williams   72CF: LS           Created the class, implemented the basic functions
/* 11/7/2016  Grant Hardy      72CF: LE           Made it inherit from the Transaction class, and moved
/*                                                 the functions to the Transaction class. Added isExpense
 */
/*
/*
/*
/****************************************************************************************/


public class Expense extends Transaction{

    private String type;
    public Expense(String title, String category, String date, double price, String type)
    {
        super.amount = price;
        super.title = title;
        super.category = category;
        super.date = date;
        super.type = type;
    }


}
