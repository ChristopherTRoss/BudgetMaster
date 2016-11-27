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
    private float totalAmount, currentAmount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public float getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(float currentAmount) {
        this.currentAmount = currentAmount;
    }
}
