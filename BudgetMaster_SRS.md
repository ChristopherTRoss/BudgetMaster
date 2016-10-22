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
  24. Open Home


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
BudgetMaster is an Android application that will be compatible on all versions past Android 5.0. BudgetMaster will allow its users to log all incomes and expenses by category and project the monthly available income on its main screen. The mobile application will help the user budget their income properly in order to reach the goal of the user which is to not overspend their money. BudgetMaster aims to be a frequently used application that encourages the management of finances on a daily basis.

#### 1.5 References
* [Material Design by Google](https://material.google.com/)
* [SQLite for Android](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)
* [Android API](https://developer.android.com/reference/packages.html)


<br>

### 2. Overall Description
#### 2.1 Product Perspective

This system will be a mobile application that allows users to make and track their budget; it will also include a database that allows the storage of data of the budget.
<br>
The database and the mobile application will need to interact in order for the user of the app to see and track what money has been spent in prior entries. Whenever the user makes an entry into the mobile application, the database will then update its information about the user's current budget. If the user wants to see past entries in the mobile application, the database will have to provide the application with that information so that the application can then show the user the information requested about the budget. So, the mobile application will be able to both access and modify the data in the database. The database will be embedded in the mobile application in order for the user to access the database easily.
<br>
![Layered Diagram](http://i.imgur.com/duWGsCV.png)

#### 2.2 Product Functions

- The mobile application will allow the users to create a PIN number at the login screen.
- The mobile application must let the users add, edit, and remove entries of money spent or earned, along with selecting a category for each expense.
- The mobile application will allow the users to add either recurring or non-recurring income to their budget and handle recurring incomes automatically.
- The mobile application must let the user add different categories to their budget (e.g. food, gas, etc.)
- The mobile application will allow users to allocate how much money they want to spend in a given category each month, and provide constantly updated information about how much money they have left to spend in each given category.
- The mobile application will allow the user to view and sort their transactions based on different fields
- The mobile application will give the user a budget analysis that will help the user manage their money more efficiently by keeping track of what categories they overspend or underspend in.


#### 2.3 User Classes and Characteristics

The only user class in this system is the standard mobile application user. The user will need to input all of his expenses and incomes, and the application will store those in the database. All of the requirements will be pertinent to the mobile application user. 
<br>
A prerequisite for the users is that they must first own a smartphone with an Android operating system. User classes will primarily target those with enough income and expenses that it would benefit them to keep track of this information. For example, a college student would benefit from this app because most college-aged students have enough income that they need to keep track of it, but a low enough income that they have to manage their expenses carefully. Additionally, people in this age group are usually relatively new to managing their own expenses. Alternatively, an adult with a higher income may want to keep track of their budget information as well due to having more transactions to keep track of.  

#### 2.4 Operating Environment

The application will only be able to run on mobile phones. More specifically, this application will only run on Android mobile devices that are on version 5.0 (Lollipop) or higher. This application is stand-alone, so no software should interact with it other than the database. 

#### 2.5 Design and Implementation Constraints

In wanting to make the database (SQLite) accessible at all times, the database is embedded in the system, so that no internet connection is needed in order to access it.  However, this creates a constraint that all data is stored on the mobile application, so if the user were to delete the app or lose their mobile device, all information in the database would be lost.  Future implementations may add a back-up feature to prevent the loss of data.

There are some constraints on the usability of this application due to security concerns. The app would be most appealing if it only took a few seconds for a user to open the app and make an entry, but for security reasons we must include a login system in the event that a user’s phone is stolen and has sensitive information stored on the app. The best compromise we can make is a PIN system rather than a username/password system, which will take less time to log in. Additionally, the system must log out the user automatically if they leave it idle for an extended period of time; this functionality may annoy some users, but is a necessary feature for ensuring security.

In order to reach the deadline on time, the developers of BudgetMaster will also have to limit platform compatibility. It would require too much time to transform the code into an iOS compatible format and as a result the product will only be available for Android devices.

#### 2.6 User Documentation

BudgetMaster strives to have an intuitive user-interface that should present itself in a way that any function will be visible to the user. By following the Material Design guidelines provided by Google, BudgetMaster will have a user-experience that any Android user should be familiar with.

#### 2.7 Assumptions and Dependencies

This system makes the assumption that there is enough storage and space on the mobile device of the user to store all of the information inputted into the database. If the mobile phone runs out of storage or memory, then the database may not be able to save and keep track of information entered. 
<br>
This system also depends on the honesty of the user. There is no administrator to check or verify the user's incomes and expenses, so a user could input incorrect amounts into the system or leave out certain transactions. In these cases, the application would not succeed in its goal of helping the user keep track of his or her budget.
<br>
The system assumes that the user will remember at least one of three security questions after creating their account. If the user forgets their PIN, they can recover it through answering one of their three custom security questions. These security questions can be viewed and updated at any time to ensure that they remain fresh in the users memory, but if they forget the answer to all three questions, the system cannot help the user and he or she will have to reinstall the application and create a new account.


<br>


### 3. External Interface Requirements
#### 3.1 User Interfaces

The screen the user is directed to upon opening the app will ask the user to enter their PIN to login, along with a button for resetting the PIN. If it is the first use of the app, the screen will instead ask for a PIN to be created and then take the user to the security questions page.
<br>
There will be a sidebar menu accessible by swiping from the left on all pages once logged in that lists “Home”, “Transaction Log”, “Analysis”, “Security Questions”, and “Logout,” either taking the user to the respective page or in the case of logout, logging out and returning the user to the login page. 
<br>
The home screen that is displayed upon logging in will display the total spendable income the user has for the remainder of the month. This page will contain a list of categories showing how much has been spent so far in each category and what the category’s maximum limit is set to. There will be a floating action button in the bottom right corner for adding categories, incomes, and expenses. If the user holds down on a category, a floating menu will open asking the user to specify whether they would like to edit or remove it.
<br>
The transaction log screen will show all expenses and incomes, with a sort button to allow the user to sort by date, category, or amount. On this page, the user may press and hold on any log, which will cause a floating menu to appear asking the user to specify whether they would like to edit or remove it.
<br>
The analysis screen will list all categories and show a ranked list of how close the user came to reaching their maximum limit in each category.
<br> 
The security questions screen will list six labeled text boxes for entering three security questions and their respective answers with a submit button at the bottom.


#### 3.2 Hardware Interfaces

All android devices with version 5.0 or higher should be supported by the app. The data that the user inputs will be stored locally on the phone in a SQLite database.

#### 3.3 Software Interfaces

BudgetMaster will use the Material Design library (XML/Java) that is provided through Android Studio for Android devices with version 5.0 and higher. The database will be implemented using SQLite. Refer to Section 1.5 for links.

#### 3.4 Communications Interfaces

The application will have no external server communication. All methods of storage will be handled locally, and as a result the only communication will be between the application, the SQLite database, and the Android hardware. When the application is started, it will pull data from the SQLite database stored locally on the system hardware, and upon making a change within the application it will send the new information to be stored in the database.

<br>

### 4. System Features 
#### 4.1 Add Income
  1. Description - User adds an amount that increases total spendable income - High Priority
  2. Stimulus/Response Sequences - User will click on a floating action button on the bottom-right of the home screen whenever the user wishes to add an income.  The action button will then prompt the user to select if they are adding a category, expense or income.  The user will select income. The application will then prompt the user to enter the amount of the income, whether this is a recurring or non-recurring income, and an optional description. Non-recurring will be the default selected option. If the user selected a recurring income, the system will also prompt the user to enter how often it recurs (i.e. weekly, biweekly, monthly, etc.). After the user has entered in all this information, they will hit the submit button to confirm changes. If the user leaves any field blank besides the description, then it will tell the user that there are required fields missing and wait for a valid entry. Once a valid entry is made by the user, the system will update the amount in the "Income" category, add the amount into the user's total budget, and create a transaction log with the date, description, and price of the income as well as whether or not it recurs. The database will then be updated with the new information. If it is a recurring income, the system will automatically create a new entry when the time period is over.
  3. Functional Requirements - 4.24 (Open Home), 4.7 (Create Category)

#### 4.2 Add Expense
  1. Description - User adds an amount that will decrease the total expendable income - High Priority
  2. Stimulus/Response Sequences - User will select the floating action button in the bottom-right corner of the home screen. The action button will then prompt the user to select if they are adding a category, expense or income. Upon selecting expense, the user will be prompted to enter a title, a category, an amount, and an optional description for the expense. The user will need to specify whether or not the expense is recurring. The application will default to non-recurring, however if the payment is recurring, the user will need to specify how often the expense recurs. After the user has entered in all this information, they will hit a submit button to confirm changes. If the user leaves any field blank besides the description, then it will tell the user that there are required fields missing and wait for a valid entry. Once a valid entry is made, the system will update the amount spent in the specified category and subtract the amount from the user's total budget amount, creating a transaction log with the date, category, description, and price of the income, as well as whether or not it recurs. The system will then update the database with the new information. If the expense is recurring, the system will automatically create a new entry when the time period is over.
  3. Functional Requirements - 4.24 (Open Home), 4.7 (Create Category)
  
#### 4.3 Edit Income
  1. Description - User can change the amount of an income that has occurred - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the income they would like to edit on the transaction log page and then press and hold on it. Doing so will display a popup prompting the user to select "Edit” or "Remove." Upon clicking "Edit" the popup menu will change to contain the same fields as the menu in which a user creates a new income. The menu will fill each field with the current information of the selected income. The user may edit these text fields, and upon clicking "Save," the application will update the information in the database. The new information will be reflected in all future transactions.
  3. Functional Requirements - 4.1 (Add Income), 4.11 (Open Transaction Log)

#### 4.4 Edit Expense
  1. Description - User can change the amount of an expense that has occurred - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the expense they would like to edit on the transaction log page and then press and hold on it. Doing so will display a popup prompting the user to select "Edit” or "Remove." Upon clicking "Edit" the popup menu will change to contain the same fields as the menu in which a user creates a new expense. The menu will fill each field with the current information of the selected expense. The user may edit these text fields, and upon clicking "Save," the application will update the information in the database. The new information will be reflected in all future transactions.
  3. Functional Requirements - 4.2 (Add Expense), 4.11 (Open Transaction Log)

#### 4.5  Delete Income
  1. Description - User can delete an income that has occurred - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the income they would like to delete on the transaction log page and then press and hold on it. Doing so will display a popup prompting the user to select "Edit” or "Remove." Upon clicking "Remove" the application will remove the entry from the transaction log, update the total balance, update the income category, and remove the log from the database. If the income was recurring, then the system will stop automatically making new logs for that income.
  3. Functional Requirements - 4.1 (Add Income), 4.11 (Open Transaction Log)

#### 4.6 Delete Expense
  1. Description - User can delete an income that has occurred - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the expense they would like to delete on the transaction log page and then press and hold on it. Doing so will display a popup prompting the user to select "Edit” or "Remove." Upon clicking "Remove" the application will remove the entry from the transaction log, update the total balance, update the respective category, and remove the log from the database. If the expense was recurring, then the system will stop automatically making new logs for that expense.
  3. Functional Requirements - 4.1 (Add Expense), 4.11 (Open Transaction Log)

#### 4.7 Create Category
  1. Description - The user must be able to add additional expense categories - High Priority
  2. Stimulus/Response Sequences - To add a category, the user will have to be logged in and at the home screen. The application will create the expense categories "Gas", "Rent", "Food", "Electricity", and "Miscellaneous" by default if this is the first time the user has visited this page. There is only one category for incomes, which will be included by default and named “Income.” Then the user will press the floating action button in the bottom-right corner of the screen and the system will ask if they would like to “Create Category”, “Add Income”, or “Add Expense.” Upon selecting “Create Category”, the system will prompt them to enter in the name of the new category and the maximum amount of money the user is willing to allocate for this category in a month. Once the user is done typing in a name and amount, they will press a submit button. If the entry has any blank information, then the system will not update the database and will prompt the user to enter valid information. Once valid information is entered, the system will add the category to the database and then update the home screen's display with the new category.  
  3. Functional Requirements - 4.24 (Open Home)

#### 4.8 Edit Category
  1. Description - The user will need to change the name or amount allocated to a category - Medium Priority
  2. Stimulus/Response Sequences - In order to change a category, the user must be logged in and at the home screen. Holding down on any of the categories, including the default ones, will display a pop up asking the user the to “Edit” or “Remove”.  Upon choosing edit, the user will be able to edit text fields for the name and the amount allocated to this category.  Once the user is finished making changes, they will hit a submit button. If the entry has any blank information, then the system will not update the database and will prompt the user to enter valid information. Once valid information is entered, the system will update the database and alter the category as specified by the user on the home screen's display.
  3. Functional Requirements - 4.24 (Open Home), 4.7 (Create Category)

#### 4.9 Delete Category
  1. Description - The user will need to be able to delete categories from their budget in certain instances - Medium Priority
  2. Stimulus/Response Sequences - In order to remove a category, the user must be logged in and at the home screen. Holding down on any of the categories will display a pop up asking the user to “Edit” or “Remove”. Upon choosing remove, the system will ask the user if they are sure they want to delete this category. If the user selects no, they will be returned to the previous screen. If the user selects yes, the category will be removed from the home screen and the database. All transactions must have a category, so if there are any transactions remaining in the removed category, they will be transferred to the “Miscellaneous” category. If the user has deleted the “Miscellaneous” category, it will be recreated. The "Income" category cannot be deleted, and if the user attempts to remove it, the system will display an error message explaining that it cannot be removed and leave the category as is.
  3. Functional Requirements - 4.24 (Open Home), 4.4 (Edit Expense), 4.8 (Create Category)

#### 4.10 Open Side-Menu
  1. Description - The user must be able to access the side-menu - High Priority
  2. Stimulus/Response Sequences - The user can swipe from the left side of the screen on any page while logged in. The system will present a menu listing “Home”, “Transaction Log”, “Analysis”, “Security Questions”, and “Logout.”
  3. Functional Requirements - 4.14 (Verify PIN)

#### 4.11 Open Transaction Log
  1. Description - The user needs to be able view all their transactions - High Priority
  2. Stimulus/Response Sequences - The user will open the transaction log by swiping from the left side of the screen and then selecting the transaction log option on the menu that the system displays. From here, a screen will pull up with all the entries the user has made. The system will sort these transactions by newest date upon first displaying the page.
  3. Functional Requirements - 4.14 (Verify PIN), 4.10 (Open Side-Menu) 

#### 4.12 Create PIN
  1. Description - User creates a PIN number to be used for future logins - High Priority
  2. Stimulus/Response Sequences - Upon opening the app for the first time, the user will be prompted to create a 4 digit PIN number. The user will enter in the desired PIN number, and then the system will ask them to re-enter the number to confirm. If it does not match, the system will ask the user to try again. If it does match, the system will store the PIN and prompt the user to create three security questions.
  3. Functional Requirements - 4.15 (Create Security Questions)

#### 4.13 Reset PIN
  1. Description - User can change their PIN by answering a security question - Medium Priority
  2. Stimulus/Response Sequences - When prompted to verify the PIN on application start, the user will have the option to click "Change my PIN." Upon selecting this, the application will prompt the user to enter in the answer to one of three previously created security questions. Once the user correctly answers a question, the application will present the user with the screen to create a new PIN. This screen looks the same as when creating the initial PIN, but afterwards the user will be brought to the home page instead of being asked to create new security questions.
  3. Functional Requirements - 4.12(Create PIN), 4.15 (Create Security Questions), 4.16 (Verify Security Question)

#### 4.14 Verify PIN
  1. Description - The application will need to determine if the PIN is correct or not - High Priority
  2. Stimulus/Response Sequences - Once a PIN is created, the application will prompt the user to verify it upon any login, or after any session timeout (30 minutes). The user will need to enter four digits (0-9) and the application will compare this input to the locally stored PIN. If the user fails to enter the PIN correctly 10 consecutive times, then the user will be locked out and must reset his PIN.
  3. Functional Requirements - 4.12 (Create PIN), 4.13 (Reset PIN)

#### 4.15 Create Security Questions
  1. Description - The user will be prompted to create three security question for restoring a lost PIN - Medium Priority
  2. Stimulus/Response Sequences - When a PIN is created, the system will take the user to a new page and list six text fields, labeled in order from top to bottom as “Security Question 1”, “Answer 1”, “Security Question 2”, “Answer 2”, “Security Question 3”, and “Answer 3.” The user will enter their own questions and answers in the appropriate fields and then click the submit button at the bottom of the page. The questions and their respective answers will be stored in the database and the user will be logged in and taken to the home screen.
  3. Functional Requirements - 4.12 (Create PIN)

#### 4.16 Verify Security Question
  1. Description: The application will need to determine if the security question was answered correctly - Medium Priority
  2. Stimulus/Response Sequences -  When the user selects the reset PIN option, the system will prompt the user with one of the three security questions that they created. The user must then answer the question correctly; the answers are not case-sensitive. After 3 failed attempts, the system will prompt the user with a different question. Once a correct answer is entered, they will be taken to the PIN creation screen, but will not be required to create new security questions as done in the initial PIN creation process.
  3. Functional Requirements - 4.12 (Create PIN), 4.13 (Reset PIN), 4.15 (Create Security Questions)

#### 4.17 Edit Security Questions
  1. Description. The application must allow users to change their security questions - Low Priority
  2. Stimulus/Response Sequences -  In order to do this, the user must be logged in and at the home screen. Then, the user will open up the side-swipe menu by swiping from the left and will select the option “Security Questions”. The system will display the security questions and answers.  Each question and answer will be in a text editable field, so the user can then update the fields with any changes they want to make.  Once the user is done changing their questions and answers, they can hit a confirm button at the bottom of the screen and it will update the questions and answers in the database. If the user tries to save an empty field in their security questions or answers, then the application will not update the database and will inform the user that they cannot leave any fields blank.
  3. Functional Requirements - 4.12 (Create PIN), 4.15 (Create Security Questions), 4.10 (Open Side-Menu)

#### 4.18 View Analysis
  1. Description - The application will provide users information about their spending habits to help them be more efficient - Low Priority
  2. Stimulus/Response Sequences - In order to access the page with the budget analysis, the user must be logged in and at the home screen. From there, the user must pull up the side-menu by swiping from the left and then select the “Analysis” option.  The system will rank and display the categories based on the percentage that the user has spent relative to the maximum allotted category amount. The categories that they spent the most in will be at the top, with the categories they spent the least in being at the bottom. 
  3. Functional Requirements - 4.2 (Add Expense), 4.7 (Create Category), 4.10 (Open Side-Menu)

#### 4.19 Sort Logs by Amount
  1. Description - Users must be able to sort their incomes and expenses by the amount - Low Priority
  2. Stimulus/Response Sequences - When the user wants to sort their incomes and expenses by the amount, they will open the transaction log.  Once there, the user will click on the sort button and select the “By amount” option.  The user will then be prompted to choose if they want to see only incomes, only expenses, or both, as well as whether they want it to sort in ascending or descending order.  It then will display all the specified logs in the specified order, with each showing its title, date, description, category, and amount.
  3. Functional Requirements - 4.1 (Add Income), 4.2 (Add Expense), 4.10 (Open Side-Menu), 4.11 (Open Transaction Log)

#### 4.20 Sort Logs by Category
  1. Description - Users must be able to see all their expenses within a certain category - Medium Priority
  2. Stimulus/Response Sequences - When the user wants to view his logs for a certain category, he or she can do this in two different ways. The first way is by tapping on the category from the home screen. This action will bring the user to the transaction log and then automatically display the logs of the specified category. It will show a detailed view of each log with title, date, description, and amount, sorted with the most recent entries at the top. The second way to perform this action will be located inside the transaction log. When the user is in the transaction log, the user may click a sort button and then select the "By category" option. The system will ask which category they want to see, and upon selecting one this will perform the same system action that occurs after pressing a category from the home screen.
  3. Functional Requirements - 4.1 (Add Income), 4.2 (Add Expense), 4.7 (Create Category), 4.10 (Open Side-Menu), 4.11 (Open Transaction Log)

#### 4.21 Sort Logs by Date
  1. Description - Users must be able to view their expenses and incomes by their date entered - Medium Priority
  2. Stimulus/Response Sequences - When the user wants to sort their incomes and expenses by the date entered, they will open the transaction log. The user will click on the sort button and select the “By date” option.  The user will then be prompted to choose if they want to see only incomes, only expenses, or both, and also to select if they want it to be ordered starting with the most recent entries or with the oldest entries. It then will display all the specified logs in a detailed format showing title, date, description, category, and amount.
  3. Functional Requirements - 4.1 (Add Income), 4.2 (Add Expense), 4.10 (Open Side-Menu), 4.11 (Open Transaction Log)

#### 4.22 Force Logout
  1. Description - Users must be able to logout manually - Medium Priority
  2. Stimulus/Response Sequences - The user will open the side-menu from any page while logged in by swiping from the left, and the system will present the user with a menu. If the user selects the “Logout” option, they will be logged out and returned to the login screen.
  3. Functional Requirements - 4.14 (Verify Pin), 4.10 (Open Side-Menu)

#### 4.23 Application Timeout
  1. Description - The application will force the user to re-verify their PIN after 30 minutes of inactivity - Low Priority
  2. Stimulus/Response Sequences - If the user has not done anything in the application for 30 minutes, when the user attempts to resume activity the system will log them out and direct them to the login screen to verify their PIN. 
  3. Functional Requirements - 4.14 (Verify Pin), 4.22 (Force Logout)
  
#### 4.24 Open Home
  1. Description - The application will take the user to the home page - High Priority
  2. Stimulus/Response Sequences - The user opens the side-menu and presses the "Home" button. The system will then take the user to the home page. Additionally, the home page is opened after logging in.
  3. Functional Requirements - 4.14 (Verify Pin), 4.10 (Open Side-Menu)

<br>

### 5. Other Nonfunctional Requirements
#### 5.1 Performance Requirements
__1. Data Entry Performance__
<br>
 1. Rationale: The data put in by the user must be put in the system fast enough for the user to make multiple entries without waiting.
<br>
 2. Description: When the user performs an action such as entering, editing, or sorting data, the application should be able to complete the action within 2 seconds of confirming the input.
<br>
 3. Ref: FR4.1 (Add Income), FR4.2 (Add Expense)
<br>

#### 5.2 Safety Requirements
__1. Financial Responsibility__
<br>
 1. Rationale: Someone could potentially make a poor financial decision if the app provides them with incorrect information
<br>
 2. Description: The system must provide correctly computed numbers and ensure that no logs are missing from the display so that a misinformed financial decision will not happen at the fault of BudgetMaster. The system cannot account for user input errors, but will ensure that no error occurs at the fault of the system.
<br>
 3. Ref: FR4.1 (Add Income), FR4.2 (Add Expense), FR4.3 (Edit Income), FR4.4 (Edit Expense), FR4.5 (Delete Income), FR4.6 (Delete Expense), FR4.11 (Open Transaction Log), FR4.18 (View Analysis)
<br>

#### 5.3 Security Requirements
__1. Account Login Security__
<br>
 1. Rationale: The user will need to protect their personal spending information from being accessible to others.
<br>
 2. Description: On opening the application, a login will be required to ensure that the user's personal spending information is secure. More than ten incorrect guesses will not be allowed consecutively. There will be security questions in place in order to reset the PIN if it is lost; these questions are custom-made by the user, as this has been shown to be more secure than presenting standard questions. To ensure account security, the application will force logout the user upon application termination, and will also force logout the user upon having the application on idle for thirty minutes. The user will additionally have the option to manually logout. 
<br>
 3. Ref: FR4.12 (Create PIN), FR4.13 (Reset PIN), FR4.14 (Verify PIN), FR4.15 (Create Security Questions), FR4.16 (Verify Security Question), FR4.17 (Edit Security Questions), FR4.22 (Force Logout), FR4.23 (Application Timeout)
<br>

#### 5.4 Software Quality Attributes
#### 1. Maintainability and Extendibility
   1. Rationale: The system will be made in incremental phase development so it needs to be maintainable and extendable to allow the seamless addition of new features
<br>
   2. Description: The application should be made in a way that allows future functions to be added without disrupting the previous existing functions. Object-Oriented Design and integration testing will be used to ensure this.
<br>

#### 2. Reliability

   1. Rationale: The system will perform exactly to the specifications listed in the development process.
<br>
   2. Description: The data entries should be added in exactly as the user specifies them without any mathematical errors or incorrect data such as the wrong description, title, or category. This will be tested by adding a large volume of data entries into the system; if one-hundred entries are added, every entry should show the correct data as specified by the user.
<br>

#### 3. Usability

   1. Rationale: This application should be designed to be easy to use in order to encourage users to keep track on the spendings regularly. 
<br>
   2. Description: In order to make the application more user-friendly and easy to navigate, the home screen will be accessible by clicking the back button on the current screen by at most 2 times after the user logs in. 
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
  1. Although we are using a PIN system, the team is still considering the option of using usernames and passwords instead to make the application more secure and lower the risk of the user’s financial information being compromised. The advantages of a password system is that there are more combinations and therefore it is more secure. The advantages of the current PIN system is that it is quicker to login, making the application more accessible. Currently we think accessibility is more important considering that the application will require regular usage to be helpful to the user, does not contain any actual payment information, and only stores data locally.
  2. We may implement a backup feature in the future so that data can be maintained across multiple devices or upon losing a device. Currently we do not have the resources for this as we do not have access to an online server and our application is handled entirely offline.
