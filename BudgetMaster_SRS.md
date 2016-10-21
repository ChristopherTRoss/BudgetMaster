# Software Requirements Specification

### for

# BudgetMaster

#### Version 1.0 approved

### Prepared by Grant Hardy, Ross Thompson, Jason Williams, Adrian Colon, Chris Ross, and Morgan Root

### LSU

### October 21, 2016

<br><br><br>

### Table of Contents

#### Table of Contents
#### Revision History

#### 1. Introduction
  1. Purpose
  2. Document Conventions
  3. Intended Audience and Reading Suggestions
  4. Product Scope
  5. References

#### 2. Overall Description
  1. Product Perspective 
  2. Product Functions
  3. User Classes and Characteristics
  4. Operating Environment
  5. Design and Implementation Constraints
  6. User Documentation
  7. Assumptions and Dependencies

#### 3. External Interface Requirements
  1. User Interfaces
  2. Hardware Interfaces
  3. Software Interfaces
  4. Communications Interfaces

#### 4. System Features
  1. Add Income
  2. Add Expense
  3. Edit Income
  4. Edit Expense
  5. Delete Income
  6. Delete Expense
  7. Create Category
  8. Edit Category
  9. Delete Category
  10. Open Side-Menu
  11. Open Transaction Log
  12. Create PIN
  13. Reset PIN
  14. Verify PIN
  15. Create Security Questions
  16. Verify Security Question
  17. Edit Security Questions
  18. View Anaylsis
  19. Sort Logs by Amount
  20. Sort Logs by Category
  21. Sort Logs by Date
  22. Force Logout
  23. Application Timeout


#### 5. Other Nonfunctional Requirements
  1. Performance Requirements
  2. Safety Requirements
  3. Security Requirements
  4. Software Quality Attributes
  5. Business Rules

#### 6. Other Requirements
  1. Database Requirements

#### Appendix A: Glossary
#### Appendix B: Analysis Models
#### Appendix C: To Be Determined List

<br><br>

### Revision History
| Name         | Date             | Reason For Changes | Version |
| ------------ |:----------------:|:------------------:| -------:|
| BudgetMaster | October 21, 2016 | Initial Draft      | 0.1     |
|              |                  |                    |         |

<br><br>

### 1. Introduction
#### 1.1 Purpose
  The product is a budgeting Android application that allows users to easily keep track of budgets and 
    day-to-day spending. Users may enter their monthly income and divide it into smaller expense 
    categories (e.g. entertainment, gas, groceries, etc.). The application will provide an 
    intuitive user interface and a budget analysis to encourage users to keep track of their spending.


#### 1.2 Document Conventions
This document will be following all conventions required in the IEEE Std 830-1998. Boldface will represent the title of each section in this document. 

#### 1.3 Intended Audience and Reading Suggestions
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

#### 1.4 Product Scope
BudgetMaster is an Android application that will be compatible on all versions past Android 5.0. BudgetMaster will allow its users to log all incomes and expenses and project the monthly available income on its main screen. The mobile application will help the user budget their income properly in order to reach the goal of the user which is to not overspend their money. BudgetMaster aims to be a frequently used application that encourages the management of finances on a daily basis.

#### 1.5 References
* [Material Design by Google](https://material.google.com/)
* [SQLite for Android](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)
* [Android API](https://developer.android.com/reference/packages.html)


<br>

### 2. Overall Description
#### 2.1 Product Perspective

This system will be a mobile application that allows users to make and track their budget; it will also include a database that allows the storage of data of the budget.
<br>
The database and the mobile application will need to interact in order for the user of the app to see and track what money has been spent in prior entries. Whenever the user makes an entry into the mobile application, the database will then update its information about the user's current budget. If the user wants to see past entries in the mobile application, the database will have to provide the application with that information so that the application can then show the user the information about the budget requested. So, the mobile application will be able to both access and modify data of the database. The database will be embedded in the mobile application in order for the user to access the database easily.
<br>
![Layered Diagram](http://i.imgur.com/duWGsCV.png)

#### 2.2 Product Functions

- The mobile application will allow the users to create a PIN number at the login screen.
- The mobile application must let the users add, edit, and remove entries of money spent or earned, along with selecting a category for each expense.
- The mobile application will allow the users to add different types of incomes to their budget, either recurring or non-recurring.
- The mobile application must let the users add different categories to their budget (e.g. food, gas, etc.)
- The mobile application will allow users to allocate how much money they want to spend in a given month into their categories, and provide information throughout the month about how much money they have left to spend in each given category.
- The mobile application will give the user a budget analysis that will help save money and stay under their budget.


#### 2.3 User Classes and Characteristics

The only user class in this system is the standard mobile application user. The user will need to input all of his expenses and incomes, and the application will store those in the database. All of the requirements will be pertinent to the mobile application user. 
<br>
A prerequisite for the users is first that they own a smartphone with an Android operating system. User classes will primarily target those with enough income and expenses that it would benefit to keep track of this information. For example, a college student would benefit from this app because most college-aged students have jobs and frequent expenses, and college students are also relatively new to managing their own expenses. Further, an adult with several bills and other expenses may want to keep track of this information as well.  

#### 2.4 Operating Environment

The application will only be able to run on mobile phones. More specifically, this application will only run on Android mobile devices that are on version 5.0 (Lollipop) or higher. This application is stand-alone, so no other software should interact with it. 

#### 2.5 Design and Implementation Constraints

In wanting to make the database (SQLite) accessible at all times, the database is embedded in the system, so that no internet connection is needed in order to access it.  However, this creates a constraint that all data is stored on the mobile application, so if the user were to delete the app or lose their mobile device, all information in the database would be lost.  Future implementations may add a back-up feature to prevent the loss of data.

There are some constraints on the usability of this application due to security concerns. The app would be most appealing if it only took a few seconds for a user to open the app and make an entry, but for security reasons we must include a login system in the event that a user’s phone is stolen and has sensitive information stored on the app. The best compromise we can make is a PIN system rather than a username/password system. Additionally, the system must logout the user automatically if they leave it idle for an extended period of time; this functionality may annoy some users, but is a necessary feature for ensuring security.

In order to reach the deadline on time, the developers of BudgetMaster will also have to limit platform compatibility. It would require too much time to transform the code into an iOS compatible format and as a result the product will only be available for Androids.

#### 2.6 User Documentation

BudgetMaster strives to have an intuitive user-interface that should present itself in a way that any function will be visible to the user. By following the Material Design guidelines provided by Google, BudgetMaster should have a user-experience that any Android user should be familiar with.

#### 2.7 Assumptions and Dependencies

This system makes the assumption that there is enough storage and space on the mobile device of the user to store all the information inputted into the database. If the mobile phone runs out of storage or memory, then the database may not be able to save and keep track information entered. 
<br>
This system also depends on the honesty of the user. There is no administrator to check and verify your incomes and expenses, so one could input various amounts into the system. In that case, the application would not succeed in its goal to help the user keep his or her budget. Further, a user may input an incorrect value that could cause incorrect estimations to a spendable income for the user.
<br>
The system assumes that the user will remember their PIN after creating their account. If the user forgets their PIN, they will not be able to access their account. 


<br>


### 3. External Interface Requirements
#### 3.1 User Interfaces

The screen the user is directed to upon opening the app will ask the user to enter their PIN to login, along with a button for resetting the PIN. If it is the first use of the app, the screen will instead ask for a PIN to be created and then take the user to the security questions page.
<br>
There will be a sidebar menu accessible by swiping from the left on all pages once logged in that lists “Home”, “Transaction Log”, “Analysis”, “Security Questions”, and “Logout,” either taking the user to the respective page or in the case of logout, logging out and returning the user to the login page. 
<br>
The home screen that is displayed upon logging in will display the total spendable income the user has for the remainder of the month. This page will contain a list of categories showing how much has been spent so far in each category and what the category’s maximum limit is set to. There will be a floating action button in the bottom right corner for adding categories, incomes, and expenses. If the user holds down on a category, a floating menu will open asking the user to specify whether they would like to edit or remove it.
<br>
The transaction log screen will show all expenses and incomes, with a sort button to allow the user to sort by date, category, or amount. On this page, the user may press and hold on its corresponding log, which will invoke a floating menu asking the user to specify whether they would like to edit or remove it.
<br>
The analysis screen will list all categories and show how close the user came to reaching their maximum limit in each category.
<br> 
The security questions screen will list six empty boxes for entering three security questions and three answers with a submit button at the bottom.


#### 3.2 Hardware Interfaces

All android devices with version 5.0 or higher should be supported by the app. The data that the user inputs will be stored locally on the phone in an SQLite database.

#### 3.3 Software Interfaces

BudgetMaster will use the Material Design library (XML/Java) that is provided through Android Studio for Android devices with version 5.0 and higher. The database will be implemented using SQLite. Refer to Section 1.5 for links.

#### 3.4 Communications Interfaces

The application will have no outside communication with servers. All methods of storage will be done locally, and as a result the only communication will be between the application, the SQLite database, and the Android hardware. When the application is started, data will be pulled from the SQLite database stored locally on the system hardware.

<br>

### 4. System Features 
#### 4.1 Add Income
  1. Description - User adds an amount that increases total spendable income - High Priority
  2. Stimulus/Response Sequences - User will click on a floating action button on the bottom right of the home screen whenever the user wishes to add an income.  The action button will then prompt the user to select if they are adding a category, expense or income.  The user will select income. The application will then prompt the user to enter the amount of the income. The user can also enter an optional description of the income listed.  The user will also select whether this is a recurring or non-recurring income.  Non-recurring will be the default selected option. If the user selects recurring income, the system will also prompt the user to enter how often it recurs (i.e. weekly, monthly, etc.)  After the user has entered in all this information, they will hit a submit button at the bottom of the screen to confirm changes. If the user selected a non-recurring income, then it updates the amount for the income category and adds the amount into the user's total budget amount, updating the database and creating a transaction log with the date, description, and price of the income, as well a whether or not it recurs. If the user leaves any field blank besides the description, then it will not update the database, and tell the user that there are required fields missing.  Once a valid entry is made by the user, the database will be updated.
  3. Functional Requirements - 4.14 (Verify PIN), 4.7 (Create Category)

#### 4.2 Add Expense
  1. Description - User adds an amount that will decrease the total expendable income - High Priority
  2. Stimulus/Response Sequences - User will select the floating action button in the bottom-right corner of the home screen. The action button will then prompt the user to select if they are adding a category, expense or income. Upon selecting expense, the user will be prompted to enter a title, category, an amount, and an optional description for the expense. The user will need to specify whether or not the payment is recurring. The application will default to non-recurring, however if the payment is recurring, the user will need to specify if the expense is weekly, biweekly, or monthly. After the user has entered in all this information, they will hit a submit button at the bottom of the screen to confirm changes. If the user selected a non-recurring income, then it updates the amount spent in the specified category and subtracts the amount from the user's total budget amount, creating a transaction log with the date, category, description, and price of the income, as well as whether or not it recurs. If the user leaves any field blank besides the description, then it will not update the database, and tell the user that there are required fields missing. Once a valid entry is made, the database will be updated.
  3. Functional Requirements -  4.14 (Verify PIN), 4.7 (Create Category)
  
#### 4.3 Edit Income
  1. Description - User can change the amount of an income that has occurred. - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the income they would like to edit on the transaction log page and then press and hold on it. Doing so will display a popup prompting the user to select "Edit” or "Remove." Upon clicking "Edit" the popup menu will change to contain the same fields as the menu in which a user creates a new income. The menu will fill each field with the current information of the selected income. The text fields will be editable, and upon clicking "save," the application will update the information in the database. The new information will be reflected in all future transactions.
  3. Functional Requirements - 4.14 (Verify PIN), 4.7 (Create Category), 4.1 (Add Income), 4.11 (Open Transaction Log)

#### 4.4 Edit Expense
  1. Description - User can change the amount of an expense that has occurred. - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the expense they would like to edit on the transaction log page and then press and hold on it. Doing so will display a popup prompting the user to select "Edit” or "Remove." Upon clicking "Edit" the popup menu will change to contain the same fields as the menu in which a user creates a new expense. The menu will fill each field with the current information of the selected expense. The text fields will be editable, and upon clicking "save," the application will update the information in the database. The new information will be reflected in all future transactions.
  3. Functional Requirements - 4.14 (Verify PIN), 4.7 (Create Category), 4.2 (Add Expense), 4.11 (Open Transaction Log)


#### 4.5  Delete Income
  1. Description - User can delete an income that has occurred. - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the income they would like to delete on the transaction log page and then press and hold on it. Doing so will display a popup prompting the user to select "Edit” or "Remove." Upon clicking "Remove" the application will remove the entry from the transaction log, remove the log from the database, and fix any changes that the deleted entry made on the database by updating the balance.  If the income was recurring, then the income will stop automatically making a new log for that income.
  3. Functional Requirements - 4.14 (Verify PIN), 4.1 (Add Income), 4.11 (Open Transaction Log)


#### 4.6 Delete Expense
  1. Description - User can delete an income that has occurred. - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the income they would like to delete on the transaction log page and then press and hold on it. Doing so will display a popup prompting the user to select "Edit” or "Remove." Upon clicking "Remove" the application will remove the entry from the transaction log, remove the log from the database, and fix any changes that the deleted entry made on the database by updating the balance.  If the expense was recurring, then the income will stop automatically making a new log for that expense.
  3. Functional Requirements - 4.14 (Verify PIN), 4.1 (Add Expense), 4.11 (Open Transaction Log)

#### 4.7 Create Category
  1. Description - The user must be able to add additional expense categories. High Priority
  2. Stimulus/Response Sequences - The user will want to add a category.  To do this, the user will have to be logged in and at the home screen. The application will have gas, rent, food, electricity, and miscellaneous categories created by default if this is the first time the user has visited this page. There is only one category for incomes, which will be included by default and named “Income.” Then the user will press the floating action button in the bottom right corner of the screen, asking if they would like to “Create Category”, “Add Income”, or “Add Expense.” Upon selecting “Create Category”, the system will prompt them to enter in the name of the new category and the maximum amount of money the user is willing to allocate for this category in a month. Once the user is done typing in a name and amount, they will press a submit button. If the entry has any blank information, then the system will not update the database and will prompt the user to enter valid information. Once valid information is entered, the system will add the category to the database and then update the home screen with the new category.  
  3. Functional Requirements - 4.14 (Verify PIN)


#### 4.8 Edit Category
  1. Description - The user will need to change the name or amount allocated to a category. Medium Priority
  2. Stimulus/Response Sequences - In order to change a category, the user must be logged in and at the home screen. Holding down on any of the categories, including the default ones, will display a pop up asking the user the to “Edit” or “Remove”.  Upon choosing edit, the user will be able to edit text fields for the name and the amount allocated to this category for the month.  Once the user is finished with the changes, they will hit a “Submit Changes” button. If the entry has any blank information, then the system will not update the database and will prompt the user to enter valid information. Once valid information is entered, the system will update the database and alter the category as specified by the user on the home screen.
  3. Functional Requirements - 4.14 (Verify PIN), 4.7 (Create Category)

#### 4.9 Delete Category
  1. Description - The user will need to be able to delete categories from their budget in certain instances.  Medium Priority
  2. Stimulus/Response Sequences - In order to remove a category, the user must be logged in and at the home screen. Holding down on any of the categories will display a pop up asking the user to “Edit” or “Remove”. Upon choosing remove, the system will ask the user if they are sure they want to delete this category. If the user selects no, they will be returned to the previous screen. If the user selects yes, the category will be removed from the home screen and the database. All transactions must have a category, so if there are any transactions remaining in the removed category, they will be transferred to the “Miscellaneous” category. If the user has deleted the “Miscellaneous” category, it will be recreated.
  3. Functional Requirements - 4.14 (Verify Pin), 4.1(Add Income), 4.2 (Add Expense), 4.8 (Create Category)

#### 4.10 Open Side-Menu
  1. Description - The user must be able to access the side-menu - High Priority
  2. Stimulus/Response Sequences - The user can swipe from the left side of the screen on any page while logged in. The system will present a menu listing “Home”, “Transaction Log”, “Analysis”, “Security Questions”, and “Logout.”
  3. Functional Requirements - 4.14 (Verify PIN)

#### 4.11 Open Transaction Log
  1. Description - The user needs to be able view all their transactions. High Priority
  2. Stimulus/Response Sequences - The user will want to open this log to view and potentially edit their entries in a log.   The user will open this by pulling up the side-swipe menu from the home screen by swiping from the left and then selecting the transaction log option.  From here, a screen will pull up with all the entries the user has made.  It will be sorted by newest date by default.  Once this screen is pulled up, the user will have the option to sort by amount, date, or category.  The user can also select any entry to edit or delete the entry.
  3. Functional Requirements - 4.14 (Verify PIN)

#### 4.12 Create PIN
  1. Description - User creates a PIN number to be used for future logins - High Priority
  2. Stimulus/Response Sequences - Upon opening the app for the first time, the user will be prompted to create a 4 digit PIN number. The user will enter in the desired PIN number, and then the system will ask them to re-enter the number to confirm. The system will then prompt the user to create three security questions. Once they have created the PIN and their security questions, they will be automatically logged in and taken to the home screen.
  3. Functional Requirements - 4.15 (Create Security Questions)

#### 4.13 Reset PIN
  1. Description - User can change their PIN by answering a security question - Medium Priority
  2. Stimulus/Response Sequences - When prompted to verify the PIN on application start, the user will have the option to click "Change my PIN." Upon selecting this, the application will prompt the user to enter in the answer to one of three previously created security questions. Once the user correctly answers a question, the application will present the user with the screen to create a new PIN; however, the user will not have to recreate their security questions as done in the initial PIN creation process.
  3. Functional Requirements - 4.12(Create PIN), 4.16 (Verify Security Questions)

#### 4.14 Verify PIN
  1. Description - The application will need to determine if the PIN is correct or not - High Priority
  2. Stimulus/Response Sequences - Once a PIN is created, the application will prompt the user to verify it upon any login, or after any session timeout (30 minutes). The user will need to enter four digits (0-9) and the application will compare this input to the privately stored PIN. If the user fails the PIN guess 10 consecutive times, then the user will be locked out and must reset his PIN through answering a security question.
  3. Functional Requirements - 4.12 (Create PIN)


#### 4.15 Create Security Questions
  1. Description - The user will be prompted to create three security question for restoring a lost PIN
  2. Stimulus/Response Sequences - When a PIN is created, the system will take the user to a new page and list six text fields, labeled in order from top to bottom as “Question 1”, “Answer 1”, “Question 2”, “Answer 2”, “Question 3”, and “Answer 3.” The user will enter their own questions and answers in the appropriate fields and then click the submit button at the bottom of the page. The questions and answers will be stored in the database and the user will be logged in and taken to the home screen.
  3. Functional Requirements - 4.12 (Create PIN)

#### 4.16 Verify Security Question
  1. Description: The application will need to determine if the security question was answered correctly. Medium Priority
  2. Stimulus/Response Sequences -  When the user selects the reset PIN option, the system will prompt the user with one of the 3 security questions that they created.  The user must then answer the question correctly..  The answers will not be case sensitive.  After 3 failed attempts, the system will prompt the user with a different question.  Once a correct answer is entered, they will be taken to the PIN creation screen, but will not be required to create new security questions as done in the initial PIN creation process.
  3. Functional Requirements - 4.12 (Create PIN), 4.15 (Create Security Questions)

#### 4.17 Edit Security Questions
  1. Description. The application must allow users to change their security questions.  Low Priority
  2. Stimulus/Response Sequences -  In order to do this, the user must be logged in and at the home screen.  Then, the user will open up the side-swipe menu by swiping from the left and select the option “Security Questions”. There it will display their security questions and answers.  Each question and answer will be in a text editable field, so the user can then update any changes they want.  Once the user is done changing their questions and answers, they can hit a confirm button at the bottom of the screen and it will update the questions and answers in the database.  If the user tries to save an empty field in their security questions and answers, then the application will not update the database and will inform the user that they cannot leave any fields blank.
  3. Functional Requirements - 4.12 (Create PIN), 4.15 (Create Security Questions), 4.10 (Open Side-Menu)

#### 4.18 View Analysis
  1. Description - The application will provide users information about their spending habits to help them be more efficient.  Low Priority
  2. Stimulus/Response Sequences - In order to access the page with the budget analysis, the user must be logged in and at the home screen. From there, the user must pull up the side-menu by swiping from the left then select the “Analysis” option.  At this page, the categories will be ranked based on the percentage that the user has spent relative to the maximum allotted category amount. The categories that they spent the most in will be at the top, with the categories they spent the least in being at the bottom. 
  3. Functional Requirements - 4.14 (Verify PIN), 4.10 (Open Side-Menu)

#### 4.19 Sort Logs by Amount
  1. Description - Users must be able to sort their incomes and expenses by the amount.  Medium Priority
  2. Stimulus/Response Sequences - When the user wants to sort their incomes and expenses by the amounts, they will open the transaction log.  Once there, the user will click on the sort button and select the “By amount” option.  The user will then be prompted to choose if they just want to see incomes, expenses, or both, and also select if they want it to sort in with the largest amounts at the top or the smallest amounts.  It then will display all these logs in a detailed format with title, date, description, category, and amount.
  3. Functional Requirements - 4.14 (Verify PIN), 4.10 (Open Side-Menu), 4.18 (View Analysis)

#### 4.20 Sort Logs by Category
  1. Description - Users must be able to see all their expenses within a certain category. Medium Priority
  2. When the user wants to view his logs for a certain category, he can do this in two different ways.  The first way is by tapping on the category from the home screen.  This action will bring the user to the transaction log and then automatically sort it by the category that was pressed.  The logs will be pulled from the database where the category matches the one originally clicked.  It will show a detailed view of each log with title, date, description, and amount of expense sorted by the most recent listed first. The second way to perform this action will be located inside the transaction log.  When the user is in the transaction log, the user may click a sort button and then select the "by category" option.  This will perform the same system action that occurs after pressing a category from the home screen. 
  3. Functional Requirements - 4.14 (Verify PIN), 4.10 (Open Side-Menu), 4.18 (View Analysis)

#### 4.21 Sort Logs by Date
  1. Description - Users must be able to view their expenses and incomes by their date entered. Medium Priority
  2. Stimulus/Response Sequences - When the user wants to sort their incomes and expenses by the date entered, they will open the transaction log. The user will click on the sort button and select the “By date” option.  The user will then be prompted to choose if they just want to see incomes, expenses, or both, and also select if they want it to be ordered starting with the most recent entries or by the oldest entries. It then will display all these logs in a detailed format with title, date, description, category, and amount.
  3. Functional Requirements - 4.14 (Verify PIN), 4.10 (Open Side-Menu), 4.18 (View Analysis)

#### 4.22 Force Logout
  1. Description - Users must be able to logout manually - High Priority
  2. Stimulus/Response Sequences - The user will open the side-menu from any page while logged in by swiping from the left, and the system will present the user with a menu. If the user selects the “Logout” option, they will be logged out and returned to the login screen.
  3. Functional Requirements - 4.14 (Verify Pin), 4.10 (Open Side-Menu)

#### 4.23 Application Timeout
  1. Description - The application will force the user to re-verify their PIN after 30 minutes of inactivity - Low Priority
  2. Stimulus/Response Sequences - If the user has not done anything in the application for 30 minutes, when the user attempts to resume activity the system will direct them to the login screen to verify their PIN. 
  3. Functional Requirements - 4.14 (Verify Pin)

<br>

### 5. Other Nonfunctional Requirements
#### 5.1 Performance Requirements
#### 1. Data Entry Performance
<br>
     1. Rationale: The data put in by the user must be put in the system fast enough for the user to still use the system.
<br>
     2. Description: When the user enters in an income or expense, the application should update within 2 seconds of confirming the input.
<br>
     3. Ref: FR4.1 (Add Income), FR4.2 (Add Expense)
<br>

#### 5.2 Safety Requirements
#### . Financial Responsibility
<br>
     1. Rationale: Someone could potentially make a poor financial decision based on the app if it provides them with incorrect information
<br>
     2. Description: The system must provide correctly computed numbers and ensure that no logs are missing from the display so that a misinformed financial decision will not happen at the fault of BudgetMaster. The system cannot account for user input errors, but will ensure that no error occurs at the fault of the system.
<br>
     3. Ref: FR4.1 (Add Income), FR4.2 (Add Expense), FR4.3 (Edit Income), FR4.4 (Edit Expense), FR4.5 (Delete Income), FR4.6 (Delete Expense), FR4.11 (Open Transaction Log), FR4.18 (View Analysis)
<br>

#### 5.3 Security Requirements
#### 1. Account Login Security
<br>
     1. Rationale: The user will need to protect their personal spending information from being accessible to others.
<br>
     2. Description: On opening the application, the user will undergo the login process to ensure that his personal spending information will be secure. There will be security questions in place in order to reset the PIN if it is lost. To ensure account security, the application will force logout the user upon application termination, and will also force logout the user upon having the application on idle for thirty minutes. The user will additionally have the option to manually logout. 
<br>
     3. Ref: FR4.12 (Create PIN), FR4.13 (Reset PIN), FR4.14 (Verify PIN), FR4.15 (Create Security Questions), FR4.16 (Verify Security Question), FR4.17 (Edit Security Questions), FR4.22 (Force Logout), FR4.23 (Application Timeout)
<br>

#### 5.4 Software Quality Attributes
#### 1. Maintainability and Extendibility  
<br>
     1. Rationale: The system will be made in a phase development so it needs to be maintainable so new features can be added easily.
<br>
     2. Description: The application should be made in a way that allows future functions to be added without disrupting the previous existing functions. 
<br>
#### 2. Reliability
<br>
     1. Rationale: The system will perform exactly to the specifications listed in the development process.
<br>
     2. Description: The data entries should be added in exactly as the user specifies them without any mathematical errors or incorrect data such as the wrong description, title, or category. If one-hundred entries are added, every entry should show the correct data as specified by the user.
<br>
#### 3. Usability
     1. Rationale: This application should be designed to be easy to use in order to encourage users to keep track on the spendings regularly. 
<br>
     2. Description: In order to make the application more user-friendly, the home screen will be accessible by clicking the back button on the current screen by at most 2 times after the user logs in. 
<br>
    
#### 5.5 Business Rules

There are no classifications between different types of users, so all users have equal access to different features of the app.

<br>

### 6. Other Requirements
__1. Database Requirements__
   <br>
1. Rationale: The system requires a database to store data when the user closes the app
   <br>
2. Description: The database used will be SQLite, a local, offline storage database contained within the phone

### Appendix A: Glossary
- Mobile Application - a type of application software designed to run on a mobile device
- Income - money received, especially on a regular basis, for work or through investments
- Expense - the cost required for something; the money spent on something
- PIN (Personal Identification Number) - a numeric password used to authenticate a user to a system
- Security Question - questions to authenticate customers to provide an additional layer of security
- Home screen - the page the user is directed to after logging in which contains the balance and the categories.

### Appendix B: Analysis Models

### Appendix C: To Be Determined List
  1. Although we are using a PIN number system, the team is still considering the option of using usernames and passwords instead to make the application more secure and lower the risk of the user’s financial information being compromised. The advantages of a password system is that there are more combinations and therefore it is more secure. The advantages of the current PIN system is that it is quicker to login, making the application more accessible. Currently we think accessibility is more important considering that the application will require regular usage to be helpful to the user, does not contain any actual payment information, and only stores data locally.
  2. We may implement a backup feature in the future so that data can be maintained across multiple devices or upon losing a device. Currently we do not have the resources for this as we do not have access to a server and our application is handled entirely offline.
