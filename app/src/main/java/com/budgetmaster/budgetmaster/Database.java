package com.budgetmaster.budgetmaster;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Date;

/****************************************************************************************/
/*
/* FILE NAME: Database
/*
/* DESCRIPTION: The homepage of the app that allows users to add incomes and
/#   expenses.  It also is will create and hold the sqllite database
 */
/*
/* REFERENCE:
/*
/* DATE         BY             CHANGE REF         DESCRIPTION
/* ========   =============     ===========         =============
/* 11/17/2016  Grant Hardy          DB1                 DB started cluttering, so I will make its own class
/* 11/18/2016  Grant Hardy          DB2                 Started to add functions createDB, constructor
/*                                                 Also added in all basic add and get functions
/* 11/25/2016  Grant Hardy          DB3                 Fixed the db crashing issue by updating the table names
/* 11/26/2016  Grant Hardy          DB4                 Created income as its own default category and made it to way the default categories
/*                                                  implement their owns budgets.
/*
/*
/****************************************************************************************/

public class Database {
    
    private SQLiteDatabase budgetDB;

    /**
     * Contrustor class for the Budget db
     * @param db is an SQLiteDatabase that is what local budgetDB initializes to
     */
    public Database(SQLiteDatabase db)
    {
        budgetDB = db;
    }
    /**
     * Calling this function opens or creates the database with the tables Budget, Category
     * Trans, SQ
     * It also checks to see if the tables have been populated,
     * if not that it populates them with the default tables
     */
    public void createTables()
    {
            try {

                // Create Tables  Budget, Category, Transaction, Security Question with the allotted fields.
                budgetDB.execSQL("CREATE TABLE IF NOT EXISTS Budget " + "(budgetID integer primary key, name varchar(30), netMoney double);");
                budgetDB.execSQL("CREATE TABLE IF NOT EXISTS Category " + "(catID integer primary key, name varchar(30), type varchar(10), maxAmount double, curAmountSpent double, budgetID integer, foreign key(budgetID) references Budget(budgetID));");
                budgetDB.execSQL("CREATE TABLE IF NOT EXISTS Trans " + "(tranID integer primary key, price double, name varchar, type varchar(10), date Date, description varchar(50), recurring boolean, budgetID integer, catID integer, foreign key(budgetID) references Budget(budgetID), foreign key(catID) references Category(catID));");
                budgetDB.execSQL("CREATE TABLE IF NOT EXISTS SQ " + "(SQID integer primary key, question varchar(75), answer varchar(75));");

                Cursor cursor = budgetDB.rawQuery("select count(*) from Budget;", null);
                cursor.moveToFirst();
                int icount = cursor.getInt(0);
                //If no budgets, populate the beginning master budget
                if (icount == 0) {
                    this.addBudget("masterbudget"); //Master Budget id should always be 1.
                }

                //Get number of categories
                String count = "select count(*) from Category;";
                cursor = budgetDB.rawQuery(count, null);
                cursor.moveToFirst();
                icount = cursor.getInt(0);

                //If the table contains no categories(ie it just got created,
                //Then populate the default tables
                if (icount == 0) {
                    addCategory("gas", "expense", 100.00);
                    addCategory("rent", "expense", 600.00);
                    addCategory("utilities", "expense", 200.00);
                    addCategory("food", "expense", 300.00);
                    addCategory("miscellaneous", "expense", 100.00);
                    addCategory("paycheck", "income", 300.00);
                    /**
                    budgetDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('gas', '"
                            + "expense" + "', " + 100.00 + ", " + 0 + ", " + 1 + ");");
                    budgetDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('rent', '"
                            + "expense" + "', " + 600.00 + ", " + 0 + ", " + 1 + ");");
                    budgetDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('utilities', '"
                            + "expense" + "', " + 200.00 + ", " + 0 + ", " + 1 + ");");
                    budgetDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('food', '"
                            + "expense" + "', " + 300.00 + ", " + 0 + ", " + 1 + ");");
                    budgetDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('miscellaneous', '"
                            + "expense" + "', " + 100.00 + ", " + 0 + ", " + 1 + ");");
                    budgetDB.execSQL("INSERT INTO Category (name, type, maxAmount, curAmountSpent, budgetID) VALUES ('Paycheck', '"
                            + "income" + "', " + 100.00 + ", " + 0 + ", " + 1 + ");");
                     **/


                }


                cursor.close();
            }
            catch(Exception e)
            {
                Log.e("BudgetDatabase ERROR", "Error Creating Tabbles");
            }


    }

    /**
     * Add a budget to the table
     * @param budName name of new Budget
     */
    private void addBudget(String budName)
    {
        budName = budName.toLowerCase();
        budName = "\""+budName+"\"";
        budgetDB.execSQL("insert into Budget (name, netMoney) Values ("+budName+", "+ 0.0 +");");
    }

    /**
     * Add a category to the table
     * @param name name of the new Category ie Gas
     * @param type income or expense
     * @param maxAmount maximum amount the user plans on spending on this category
     */
    public void addCategory(String name, String type, double maxAmount)
    {
        name = name.toLowerCase();
        type = type.toLowerCase();

        //When we create a category, we will also create categorical budget that will be a foreign key in category
        this.addBudget(name+"Budget");
        int budID = this.getBudgetID(name+"Budget");
        budgetDB.execSQL("insert into Category (name, type, maxAmount, curAmountSpent, budgetID) Values ("+ name +", " + type + ", "+ maxAmount + ", " + 0.0 + ", " + budID+");");
    }

    /**
     * Add Transaction to the table.
     * In order to get the correct references for the tranaction, we obtain the catID from the
     * category name given to us, the we obtain the budgetID from the catID just found.
     * @param name title of the transaction
     * @param price how much money was spent/obtained
     * @param type income or expense?
     * @param date the date of the transactioon
     * @param description A more detailed description
     * @param recurring Will this transaction recur reguarly?
     * @param catName name of the category that the transaction belongs to
     */
    public void addTransaction(String name,  double price, String type, Date date, String description,  boolean recurring, String catName)
    {
        type = type.toLowerCase();
        description = description.toLowerCase();
        name = name.toLowerCase();
        int catID = getCategoryID(catName);
        Cursor cursor = budgetDB.rawQuery("select budID from Category where catID = " + catID+ ");", null);
        cursor.moveToFirst();
        int budID = cursor.getInt(0);

        //Check to make sure type is correct
        //Then add the transaction to the trans table
        //Add correspondingly update the Master budget, and the categorical budget it belongs too.
        if((type.equals("expense") || type.equals("income")))
        {
            budgetDB.execSQL("insert into Trans (price, name, type, date, description, recurring, budgetID, catID) Values (" + name + ", " + price + ", " + type + ", " + date + ", " + description + ", " + recurring + ", " + budID + ", " + catID + ");");
            updateBudget(1, type, price);
            updateBudget(budID, type, price);

        }
        cursor.close();
    }

    /**
     * Add a security question to the table
     * @param question the security question
     * @param answer the security answer
     */
    public void addSecurityQuestion(String question, String answer)
    {
        answer = answer.toLowerCase();
        budgetDB.execSQL("insert into SQ (question, answer) Values (" +question+", "+ answer +");");
    }

    /**
     * Return the catID of the name used as a parameter
     * @param name of category
     * @return catID
     */
    public int getCategoryID(String name)
    {
        name = name.toLowerCase();
        Cursor cursor = budgetDB.rawQuery("select catID from Category where name = " + name+");", null);
        cursor.moveToFirst();
        int catID = cursor.getInt(0);
        cursor.close();
        return catID;
    }

    /**
     * Return the budgetID of the name used as a parameter
     * @param name of budget
     * @return budgetid
     */
    public int getBudgetID(String name)
    {
        name = name.toLowerCase();
        Cursor cursor = budgetDB.rawQuery("select budgetID from Budget where name =" + name+");", null);
        cursor.moveToFirst();
        int budID = cursor.getInt(0);
        cursor.close();
        return budID;
    }

    /**
     * This function gets all the Expenses from Transactions and returns them in a Expenses array.
     *
     * @return an array of all Expenses kept
     */
    public Expense[] getAllExpenses() {
        Cursor cursor = budgetDB.rawQuery("select * from Trans where type = 'expense';", null);
        int priceColumn = cursor.getColumnIndex("price");
        int nameColumn = cursor.getColumnIndex("name");
        int descColumn = cursor.getColumnIndex("description");

        cursor.moveToFirst();

        Expense[] expense = new Expense[100];  //limiting it to a 100 transaction for now
        int i = 0;

        // Verify that we have results
        if (cursor != null && (cursor.getCount() > 0)) {

            do {
                // Get the results and store them in a Array
                double price = cursor.getDouble(priceColumn);
                String name = cursor.getString(nameColumn);
                String desc = cursor.getString(descColumn);

                expense[i] = new Expense(price, name, desc);
                i++;

                // Keep getting results as long as they exist
            } while (cursor.moveToNext());
        }
        cursor.close();
        return expense;
    }

    /**
     * This function obtains all Transactions that are incomes and returns them in a income array
     * @return an Income array of all Incomes kept
     */
    public Income[] getAllIncomes() {
        Cursor cursor = budgetDB.rawQuery("select * from Trans where type = 'income';", null);
        int priceColumn = cursor.getColumnIndex("price");
        int nameColumn = cursor.getColumnIndex("name");
        int descColumn = cursor.getColumnIndex("description");

        cursor.moveToFirst();

        Income[] incomes = new Income[100];  //limiting it to a 100 transaction for now
        int i = 0;

        // Verify that we have results
        if (cursor != null && (cursor.getCount() > 0)) {

            do {
                // Get the results and store them in an array
                double price = cursor.getDouble(priceColumn);
                String name = cursor.getString(nameColumn);
                String desc = cursor.getString(descColumn);

                incomes[i] = new Income(price, name, desc);
                i++;

                // Keep getting results as long as they exist
            } while (cursor.moveToNext());
        }
        cursor.close();
        return incomes;
    }

    /**
     * This method is used to update budgets.  I made this private bc the budget should not just be
     * updated when nothing else happens. The budget should only be updated whenever another action
     * occur(ie adding or removing a transaction), so this function should only be called in those
     * particular functions.
     * This method works by obtaining the netMoney of the budget before the change,
     * modifying the variable depending on the type of transaction,
     * then updating the database with the new netMoney.
     * @param budgetID the id of the budget you are updating
     * @param type income or expense?
     * @param price the price of the update
     */
    private void updateBudget(int budgetID, String type, double price)
    {
        type = type.toLowerCase();
        Cursor cursor = budgetDB.rawQuery("select netMoney from Budget where budgetID = "+budgetID+");", null);
        cursor.moveToFirst();
        double netMon = cursor.getDouble(0);

        if(type.equals("expense"))
        {
            netMon -= price;
            budgetDB.execSQL("update Budget set netMoney = "+netMon+" where budgetID = "+budgetID+");");
        }
        else if(type.equals("income"))
        {
            netMon += price;
            budgetDB.execSQL("update Budget set netMoney = "+netMon+" where budgetID = "+budgetID+");");
        }
        else
        {
            //It must be income or expense, if not, don't update
        }
        cursor.close();
    }

    /**
     * This method gets the three security question answers and returns them in a string array
     * @return a String array of size 3 that contains the SQ answers
     */
    public String[] getAnswers()
    {
        String[] answers = new String[3]; //Size three bc there is only three questions
        Cursor cursor = budgetDB.rawQuery("select answer from SQ;", null);
        cursor.moveToFirst();
        for(int i = 0; i<3; i++)
        {
            answers[i] = cursor.getString(i);
            cursor.moveToNext();
        }
        cursor.close();
        return answers;
    }

    /**
     * This method gets the three security questions and returns them in a string array
     * @return a String array of size 3 that contains the SQ questions
     */
    public String[] getQuestions()
    {
        String[] questions = new String[3]; //Size three bc there is only three questions
        Cursor cursor = budgetDB.rawQuery("select question from SQ;", null);
        cursor.moveToFirst();
        for(int i = 0; i<3; i++)
        {
            questions[i] = cursor.getString(i);
            cursor.moveToNext();
        }
        cursor.close();
        return questions;
    }

    /**
     * This method will be used when changing a Security Question
     * If you ever update the question, you should update the answer as well
     * @param quesID the id of the question being changed, it will be 1, 2 or 3
     * @param question the security question you are changing it too
     * @param answer the new answer to the new question
     */
    public void updateQuestionAndAnswer(int quesID, String question, String answer)
    {
        if(quesID == 1 || quesID == 2 || quesID == 3)
        budgetDB.execSQL("update SQ set question = " + question + ", answer = "+answer+" where SQID = " + quesID+ ";");
    }

    /**
     * Removes the category from the database.  Will also remove the corresponding categorical budget
     * @param name the name of the category to be deleted
     */
    public void removeCategory(String name)
    {
        name = name.toLowerCase();
        Cursor cursor = budgetDB.rawQuery("select budgetID from Category where name = " + name + ";", null);
        cursor.moveToFirst();
        int budgetID = cursor.getInt(0);

        //We delete the category requested, but we also delete the categorical budget that it refrences;
        budgetDB.execSQL("delete from Category where name = "+name+";");
        budgetDB.execSQL("delete from Budget where budgetID = "+budgetID+";");
        cursor.close();
    }

    /**
     * Removes the transaction specified by the title.
     * It deletes the transaction from the transaction table, and also updates
     * the corresponding budgets as if the transaction never occured
     * @param title the title of the transaction to remove
     */
    public void removeTransaction(String title)
    {
        title = title.toLowerCase();
        Cursor cursor = budgetDB.rawQuery("select budgetID, price, type from Trans where name = "+title+";", null);
        cursor.moveToFirst();
        int priceColumn = cursor.getColumnIndex("price");
        int typeColumn = cursor.getColumnIndex("type");
        int idColumn = cursor.getColumnIndex("budgetID");

        budgetDB.execSQL("delete from Trans where name = "+title+";");
        double price = cursor.getDouble(priceColumn);
        String type = cursor.getString(typeColumn);
        int budID = cursor.getInt(idColumn);

        //Expenses and incomes are opposites of each other
        //If we remove an expense, it is the same as adding an income
        // and vice verso.
        //So, once we delete the Transaction we have to update the budget accordingly
        //We must update the master budget and the categorical one
        if(type.equals("expense"))
            type = "income";
        else
            type = "expense";
        updateBudget(1, type, price);
        updateBudget(budID, type, price);
        cursor.close();
    }




    /**
     * method to return the database
     * @return the database
     */
    public SQLiteDatabase getDB()
    {
        return budgetDB;
    }


    
    
}





