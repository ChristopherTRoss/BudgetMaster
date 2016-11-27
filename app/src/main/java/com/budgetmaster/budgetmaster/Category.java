package com.budgetmaster.budgetmaster;
/****************************************************************************************/
/*
/* FILE NAME: Category
/*
/* DESCRIPTION: A Category class that is used to keep track of individual category data
/*              An array of Categories are display in the HomeFragment and Overview
/*
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/26/2016 Jason Williams   72CF: LS           Created the class with getters and setters
/*
/*
/*
/****************************************************************************************/
public class Category {
    private String title;
    private double totalAmount, currentAmount;

    public Category(String title, double totalAmount)
    {
        this.title = title;
        this.totalAmount = totalAmount;
        currentAmount = 0;
    }

    public Category(String title, double totalAmount, double curAmount)
    {
        this.title = title;
        this.totalAmount = totalAmount;
        currentAmount = curAmount;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(float currentAmount) {
        this.currentAmount = currentAmount;
    }
}
