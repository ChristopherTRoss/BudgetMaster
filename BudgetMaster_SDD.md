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
| BudgetMaster | October 30, 2016 | Initial Draft      | 1.0.0   |
|              | October 31, 2016 | Added Text to DB   | 1.0.1   |
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
#### 4. Rational For Each Architectural Choice
#### 5. Development View
#### 6. Physical View
#### 7. Database View
#### 8. Work-assignment View
#### 9. Element Catalog
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

<br>

### 4. Rational For Each Architectural Choice

<br>

### 5. Development View
![Development View](https://github.com/scinerio/BudgetMaster/blob/master/Development%20View.png?raw=true)

<br>

### 6. Physical View
  Currently there are no outside systems/hardware being used. Because everything is being done locally on an Android device, a physical view is not necessary for this software system. 
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
  The Application Development and Back-End Development have been tasked to:
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
#### Development View

| __Symbol__  |  __Description__  |
| ----------- | -----------------:|
|   Folder    |     Directory     |

<br>

### 10. User Interfaces

![Login UI]()

![Main Screen UI]()
