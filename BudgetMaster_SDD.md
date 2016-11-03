# Software Design Document

### for

# BudgetMaster

#### Version 1.0 approved

### Prepared by Grant Hardy, Ross Thompson, Jason Williams, Adrian Colon, Chris Ross, and Morgan Root

### LSU

### November 2, 2016

<br><br>

#### Revision History
| Name         | Date             | Reason For Changes | Version |
| ------------ |:----------------:|:------------------:| -------:|
| BudgetMaster | October 30, 2016 | Initial Draft      | 1.0  |
|              | October 31, 2016 | Added Text to DB   | 1.0   |
<br><br>

### Table of Contents
#### 1. Introduction
  1. Purpose
  2. Scope
  3. Intended Audience
  4. Design Summary
  5. References
  
#### 2. Main System Architecture
#### 3. Sub-systems Architecture
  1. Overview of Sub-Systems
  2. Budget
  3. Accounts
  
#### 4. Rational For Each Architectural Choice
#### 5. Development View
#### 6. Physical View
#### 7. Database View
#### 8. Work-assignment View
  1. User Interface Design & Front-End Development
  2. Application Development & Back-End Development
  3. Database Management
  4. Documentation & Note Taking
  
#### 9. Element Catalog
  1. Development View Catelog
  
#### 10. User Interfaces

<br><br><br>
### 1. Introduction
#### 1.1 Purpose
  The product is a budgeting Android application that allows users to easily keep track of budgets and 
    day-to-day spending. Users may enter their monthly income and divide it into smaller expense 
    categories (e.g. entertainment, gas, groceries, etc.). The application will provide an 
    intuitive user interface and a budget analysis to encourage users to keep track of their spending.
    
#### 1.2 Scope
BudgetMaster is an Android application that will be compatible on all versions past Android 5.0. BudgetMaster will allow its users to log all incomes and expenses by category and project the monthly available income on its main screen. The mobile application will help the user budget their income properly in order to reach the goal of the user which is to not overspend their money. BudgetMaster aims to be a frequently used application that encourages the management of finances on a daily basis.

#### 1.3 Intended Audience
Readers that may benefit from this document include (but are not limited to):
- Developers
  - To better understand the goals, use cases, and specifications of this project
- Project Managers
  - To familiarize themselves with the requirements and scope of this project
- Marketing Staff
  - To examine features that may make this software system more profitable
- Users/Testers
  - To gain knowledge on all aspects of this software system that may be useful to a daily user
- Document Writers
  - To fully understand any feature that would otherwise be unclear based on code
  
#### 1.4 Design Summary
Our product is designed to provide a budgeting mobile application for all people from college students to adults to keep track of their day to day expenses in order to help make a budget. Our application will be developed using the principles of Object Oriented Design in order to seperate and organize all of the objects used in the system. Our product will have an user-friendly interface in order to encourage users to use the app often to enter in all expenses and incomes. This will allow users to get an accurate representation of what their spending was in a given time period as well as providing insight of which categories they are overspending in. The user will be able to view all the expenses and incomes in a transaction log and be able to sort the log in various ways in order to get further insights into their budget. The application will also help the user make their monthly budget by constantly displaying how much current money they have to spend in each category. Through all these goals and features, we want our users to be able and encouraged to record every income/expense in order to keep a better track of the user's money.

#### 1.5 References
* [Material Design by Google](https://material.google.com/)
* [SQLite for Android](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)
* [Android API](https://developer.android.com/reference/packages.html)

<br>

### 2. Main System Architecture
  - Our application will be mainly operating within four main components.  Those components are the user, budgets, categories, and transactions.  The user entity will mainly consist of the user's login information and how to user will login.  The user will also have the ability to input data such as categories and transactions.  The next three entities are part of the budgeting process.  These entities will keep track of user-inputted data and allow the user to view what they are spending their money on.

![Logical View Diagram](https://github.com/scinerio/BudgetMaster/blob/master/ER%20Diagram.png?raw=true)

<br>

### 3. Sub-systems Architecture
#### 3.1 Overview of Sub-Systems
  All of our sub-systems aim to be layed out in an object oriented fashion, so that each component can call on one another and interact with each object only when needed to.  There are two main sub-systems of the application, the budget and the account.  
  The budget system will primarily consists are recording, managing, and displaying data from the user about any transactions they have made.
  The account system would be used to manage the login process, and to withold all the user's login information.
  
#### 3.2 Budget
  All budgets will be made and the classes that manage the budget would be made in this sub-system.  The budgets components will consist of a master budget that tracks the total net spendable income.  There will also be budgets for each category of expense/income created so that each category will also keep track of the spendable income for the specific category.  These budgets will be update whenever the user adds a transaction.  Once a transaction is added, the master budget will be updated as well as the category that the transaction is slotted in.  The Budget will also be responsible for retrieving information about the transaction and budgets and displaying it to the user.  The budget componet will store all of its data for transactions, categories, and budgets in a database in order to easily pull and organize the different searches and entries the application will use.
  
#### 3.3 Accounts
  The user's account and account information will be created in the account system.  The account system holds the user's pin number, security questions, and is able to determine if it is the user's first time logging in.  The account stores login information in order to sync up the user's budgets and transaction history.  The account system will also keep track of how long the user has been logged in and force logout the user when the user request so or when the user has been inactive for 30 minutes.  This account information will also be stored and pulled from the database within the user and security question tables.
<br>

### 4. Rational For Each Architectural Choice
#### 4.1 Rational for the Budget
  We structured the budget component this way because it easily seperates all transactions and makes it easy to update the budgets and sort the transactions by various categories.  Also, seperating all the categories for the main budget is essential in the case that the user deletes categories from the main budget, so data is not lost.  Overall separting the budget in two different categories and smaller budgets will help with data integrity which vital to the application's success.
  
#### 4.2 Rational for the Account
  We constructed the account class because security is an important part of the application.  It is important that the account and login system is seperated from the rest of the application in order to prevent invalid access to the login information and personal spending information.  The application will implement a pin number to promote security of the user's information, while also having a quick way to login so that users are encouraged to use the application more often.

<br>

### 5. Development View
![Development View](https://github.com/scinerio/BudgetMaster/blob/master/DevView.png)

<br>

### 6. Physical View
This application does not have a physical view.  Everything is handled locally on the Android device so there is no communication between other devices and therefore no need for a physical view.

<br>

### 7. Database View
  The application will use an embedded sqlite database in order to keep track of data of all transactions and account details.  The database will be stored locally on the application so that the user can always access the data, even without internet connection.  The main focus of this database to ensure all transactions get placed under a category, and that all categories are placed in a budget, so that are the various sorts and filters the application would use will be made easier.  
  
![Database View Diagram](https://github.com/scinerio/BudgetMaster/blob/master/DB%20View.png)

Since our database model does not include variable types in the actual model, they will be listed below.

#### User
  - User_id = int
  - Pin     = int
  - Status  = boolean that stores whether or not the user has created a login
  
#### Security Question
 - SQ_ID = int
 - Question = VARCHAR(250)
 - Answer = VARCHAR(250)
 
#### Budget
 - Budget_id  =  INT
 - Net_Money  =  FLOAT
 - User_id    =  INT
 
#### Category
 - Cat_id =    INT
 - Name   =    VARCHAR(100)
 - Type   =    boolean that determines whether it is an income or expense
 - Maximum Amount =  FLOAT
 - Current Amount Spent = FLOAT
 - Budget_id     =  INT
 
#### Transaction
 - Tran_id    = INT
 - Type       = Boolean that determines whether it is an income or expense
 - Date       = DATE
 - Description = VARCHAR(250)
 - Recurring?  = boolean that determines if it a recurring transaction
 - Budget_id   = INT
 - Cat_id      = INT

<br>

### 8. Work-assignment View
#### 8.1 User Interface Design & Front-End Development
  The User Interface and Front-End Development have been tasked to:
 - Jason Williams
 - Chris Ross
 - Adrian Colon
 
#### 8.2 Application Development & Back-End Development
  The Application Functionality and Back-End Development have been tasked to:
 - Jason Williams
 - Grant Hardy
 - Ross Thompson
 - Morgan Root
 
#### 8.3 Database Management
  Database Management has been tasked to:
 - Grant Hardy
 
#### 8.4 Documentation & Note Taking
Documentation and Note Taking has been tasked to:
 - Chris Ross
 - Morgan Root

<br>

### 9. Element Catalog
#### 9.1 Development View Catelog

| __Symbol__  |  __Description__  |
| ----------- | -----------------:|
|   Folder    |     Directory     |

<br>

### 10. User Interfaces
<br>
![Login Screen UI](https://github.com/scinerio/BudgetMaster/blob/master/login.png) 
<br>
Login screen of the application where the user is prompted to either create a PIN for their new account.
<br>

![Main Screen UI](https://github.com/scinerio/BudgetMaster/blob/master/main.png)
<br>
Main screen of the application displaying the amount left for this month at the top and a list of the categories below it.
<br>

![Transaction Log Screen UI](https://github.com/scinerio/BudgetMaster/blob/master/transactionlog.png) 
<br>
Transaction log screen displaying a list of transactions with an option to sort by amount, category, or date.
<br>

![Security Questions Screen UI](https://github.com/scinerio/BudgetMaster/blob/master/securityquestions.png) 
<br>
Security questions screen that displays the three security questions that the users selected with their respective answers below them.
<br>

![Analysis Screen UI](https://github.com/scinerio/BudgetMaster/blob/master/analysis.png) 
<br>
Analysis screen displaying a list of categories ordered by the percentage of completion.
<br>
