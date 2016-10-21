# __Software Requirements Specification__

### __for__

# __BudgetMaster__

#### __Version 1.0 approved__

### __Prepared by Grant Hardy, Ross Thompson, Jason Williams, Adrian Colon, Chris Ross, Morgan Root__

### __LSU__

### __October 21, 2016__

<br><br><br>

### __Table of Contents__

#### __Table of Contents__
#### __Revision History__

#### __1. Introduction__
  1. Purpose
  2. Document Conventions
  3. Intended Audience and Reading Suggestions
  4. Product Scope
  5. References

#### __2. Overall Description__
  1. Product Perspective 
  2. Product Functions
  3. User Classes and Characteristics
  4. Operating Environment
  5. Design and Implementation Constraints
  6. User Documentation
  7. Assumptions and Dependencies

#### __3. External Interface Requirements__
  1. User Interfaces
  2. Hardware Interfaces
  3. Software Interfaces
  4. Communications Interfaces

#### __4. System Features__
  1. Add Income
  2. Add Expense

#### __5. Other Nonfunctional Requirements__
  1. Performance Requirements
  2. Safety Requirements
  3. Security Requirements
  4. Software Quality Attributes
  5. Business Rules

#### __6. Other Requirements__
#### __Appendix A: Glossary__
#### __Appendix B: Analysis Models__
#### __Appendix C: To Be Determined List__

<br><br>

### __Revision History__
| Name          | Date              | Reason For Changes  | Version |
| ------------- |:-----------------:|:-------------------:| -------:|
| Initial Draft | October 17, 2016  |                     | 0.1     |
|               |                   |                     |         |

<br><br>

### __1.   Introduction__
#### __1.1   Purpose__
  The product is a budgeting Android application that allows users to easily keep track of budgets and 
    day-to-day spending. Users may enter their monthly income and divide it into smaller expense 
    categories (e.g. entertainment, gas, groceries, etc.). The application will provide an 
    intuitive user interface and goals/tips to encourage users to keep track of their spending.


#### __1.2   Document Conventions__
This document will be following all conventions required in the IEEE Std 830-1998. Boldface will represent the title of each section in this document. 

#### __1.3   Intended Audience and Reading Suggestions__
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

#### __1.4   Product Scope__
BudgetMaster is an Android application that will be compatible on all versions past Android 5.0. BudgetMaster will allow its users to log all incomes and expenses and project the monthly available income on its main screen. BudgetMaster aims to be a frequently used application that encourages the management of finances on a daily basis. 

#### __1.5   References__
* [Material Design by Google](https://material.google.com/)
* [SQL for Android](https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)
* [Android API](https://developer.android.com/reference/packages.html)


<br>

### __2.   Overall Description__ 
#### __2.1   Product Perspective__

This system will be a mobile application that allows users to make and track their budget; it will also include a database that allows the storage of data of the budget.
<br>
The database and the mobile application will need to interact in order for the user of the app to see and track what money has been spent in prior entries. Whenever the user makes an entry into the mobile application, the database will then update its information about the user's current budget. If the user wants to see past entries in the mobile application, the database will have to provide the application with that information so that the application can then show the user the information about the budget requested. So, the mobile application will be able to both access and modify data of the database. The database will be embedded in the mobile application in order for the user to access the database easily.


#### __2.2   Product Functions__

- The mobile application will allow the users to create a pin number at the login screen.
- The mobile application must let the users add and edit entries of money spent, along with selecting a category of what the purchase falls under.
- The mobile application will allow the users to add different types of incomes to their budget.
- The mobile application must let the users add different categories to their budget (e.g. food, gas, etc.)
- The mobile application will allow users to allocate how much money they want to spend in a given month into their categories, and provide information throughout the month about how much money they have left to spend in each given category.
- The mobile application will give the user tips and goals to complete that will help save money and stay under their budget.


#### __2.3   User Classes and Characteristics__

The only user class in this system is the standard mobile application user. The user will need to input all of his expenses and incomes, and the application will store those in the database. All of the requirements will be pertinent to the mobile application user. 
<br>
A prerequisite for the users is first that they own a smartphone with an Android operating system. User classes will primarily target those with enough income and expenses that it would benefit to keep track of this information. For example, a college student would benefit from this app because most college-aged students have jobs and frequent expenses, and college students are also relatively new to managing their own expenses. Further, an adult with several bills and other expenses may want to keep track of this information as well.  

#### __2.4   Operating Environment__

The application will only be able to run on mobile phones. More specifically, this application will only run on Android mobile devices that are on version 5.0 (Lollipop) or higher. This application is stand alone, so no other software should interact with it. 

#### __2.5   Design and Implementation Constraints__

In wanting to make the database accessible at all times, the database is embedded in the system, so that no internet connection is needed in order to access it.  However, this creates a constraint that all data is stored on the mobile application, so if the user were to delete the app or lose their mobile device, all information on the database would be lost.  Future implementations may add a back-up feature to prevent the loss of data.

#### __2.6   User Documentation__

BudgetMaster strives to have an intuitive user-interface that should present itself in a way that any function will be visible to the user. By following the Material Design guidelines provided by Google, BudgetMaster should have a user-experience that any Android user should be familiar with.

#### __2.7   Assumptions and Dependencies__

This system makes the assumption that there is enough storage and space on the mobile device of the user to store all the information inputted into the database. If the mobile phone runs out of storage or memory, then the database may not be able to save and keep track information entered. 
<br>
This system also depends on the honesty of the user. There is no administrator to check and verify your incomes and expenses, so one could input various amounts into the system. In that case, the application would not succeed in its goal to help the user keep his or her budget. Further, a user may input an incorrect value that could cause incorrect estimations to a spendable income for the user.


<br>


### __3.   External Interface Requirements__ 
#### __3.1   User Interfaces__

The screen the user is directed to upon opening the app will display the total spendable income the user has for the remainder of the month. The initial page will allow you to view a list of categories showing how much has been spent in each and what your maximum goal is. When a category is selected, the system will take the user to the transaction log for that category. 
<br>
There will be an additional screen called the transaction log that will allow users to view all expenses and incomes, and allow the user to sort by date, category, or net amount. 
<br>
To edit or remove an income/expense, the user may press and hold on its corresponding log, which will invoke a floating menu asking the user to specify whether they would like to edit or remove it.

#### __3.2   Hardware Interfaces__

All android devices with version 5.0 or higher should be supported by the app. The data that the user inputs will be stored locally on the phone in an SQL database.

#### __3.3   Software Interfaces__

BudgetMaster will use the Material Design library (XML/Java) that is provided through Android Studio for Android devices with version 5.0 and higher. The database will be implemented using SQL.

#### __3.4   Communications Interfaces__

<br>


### __4.   System Features__ 
#### __4.1   Add Income__
  1. Description - User adds an amount that increases total spendable income - High Priority
  2. Stimulus/Response Sequences - User will click on an action button on the bottom of the home screen whenever the user wishes to add an income.  The action button will then prompt the user to select if they are adding an expense or an income.  The user will select income. The application will then prompt the user to enter the amount of the income. The user can also enter an optional description of the income listed.  The user will also select whether this is a recurring or non-recurring income.  Non-recurring will be the default selected option. If the user selects recurring income, the system will also prompt the user to enter how often it recurs (i.e. weekly, monthly, etc.)  After the user has entered in all this information, they will hit a submit button at the bottom of the screen to confirm changes.  Then the system will update the database based on what the user inputted.  If the user selected a non-recurring income, then it updates the category amount and adds the amount into the user's total budget amount and adds a log into the database with the date, category, description, and price of the income. If the user leaves any field blank besides the description, then it will not update the database, and tell the user that there are required fields missing.
  3. Functional Requirements

#### __4.2   Add Expense__
  1. Description - User adds an amount that will decrease the total expendable income - High Priority
  2. Stimulus/Response Sequences - User will select the floating action button in the bottom-right corner of the home screen. The user will be prompted to specify expense or income. Upon selecting expense, the user will be promopted to enter a title, category, an amount, and an optional description for the expense. The user will need to specify whether or not the payment is recurring. The application will default to recurring, however if the payment is recurring, the user will need to specify if the expense is weekly, biweekly, or monthly. After the user has entered in all this information, they will hit a submit button at the bottom of the screen to confirm changes. Then the system will update the database based on what the user inputted. If the user selected a non-reoccuring income, then it adds the amount into the user's total budget amount and adds a log into the database with the date, category, description, and price of the income. Then the application makes the log appears on the home screen. If the user leaves any field blank besides the description, then it will not update the database, and tell the user that there are required fields missing.
  3. References - 
  
#### __4.3   Edit Income__
  1. Description - User can change the amount of an income that has occured. - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the income in which they would like to edit (transaction log page or home screen) and then press and hold on it. Doing so will display a popup prompting the user to select "Edit or "Remove." Upon clicking "Edit" the popup menu will change to look similar to the menu in which a user creates an income. The menu will fill to contain the current information of the income. The text feels will be editable, and upon clicking "save," the application will update the information in the database. The new information will be reflected in all future transactions. 
  4. References - The user will find an instance of the income in which they would like to edit (transaction log page or home screen) and then press and hold on it. Doing so will display a popup prompting the user to select "Edit or "Remove." Upon clicking "Edit" the popup menu will change to look similar to the menu in which a user creates an income. The menu will fill to contain the current information of the income. The text fields will be editable, and upon clicking "save," the application will update the information in the database. The new information will be reflected in all future transactions. 
  
#### __4.4   Edit Expense__
  1. Description - User can change the amount of an expense that has occured. - High Priority
  2. Stimulus/Response Sequences - The user will find an instance of the expense in which they would like to edit (transaction log page or home screen) and then press and hold on it. Doing so will display a popup prompting the user to select "Edit or "Remove." Upon clicking "Edit" the popup menu will change to look similar to the menu in which a user creates an income. The menu will fill to contain the current information of the expense. The text fields will be editable, and upon clicking "save," the application will update the information in the database. The new information will be reflected in all future transactions. 

#### __4.5   Create Pin__


#### __4.6   Edit Pin__


#### __4.7   Verify Pin__

#### __4.8   Application Timeout__

#### __4.9   Create Security Question__

#### __4.10   Verify Security Question__

#### __4.11   Edit Security Question__

#### __4.12   View Tips__

#### __4.13   View All Logs__

#### __4.14   Sort Logs by Amount__

#### __4.15   Sort Logs by Category__

#### __4.16   Sort Logs Date__





<br>

### __5.   Other Nonfunctional Requirements__ 
#### __5.1   Performance Requirements__
  1. Data Entry Performance
<br>
     Rationale: The data put in by the user must be put in the system fast enough for the user to still use the system.
<br>
     Description: When the user enters in his an income our expense, their budget should update within 2 seconds of confirming the input.
<br>
     Ref: Not sure what goes here.
<br>

#### __5.2   Safety Requirements__

Someone could potentially make a poor financial decision based on inaccurate information if they do not enter all of their expenses as expected by the program.

#### __5.3   Security Requirements__
  1. Account Login Security
<br>
     Rationale: The user will need to protect their personal spending information from being accessible to others.
<br>
     Description: On opening the application, the user will undergo the login process to ensure that his personal spending information will be secure.  To ensure account security, the application will force logout the user upon application termination, and will also force logout the user upon having the application on idle for more than one hour.  The user will also have the option to force logout.
<br>
     Ref: Login FR
<br>

#### __5.4   Software Quality Attributes__
  1. Maintainability and Extendability  <br>
     Rationale: The system will be made in a phase development so it needs to be maintainable so new features can be added easily.
<br>
     Description: The application should be made in a way that allows future functions to be added without disrupting the previous existing functions. 
<br>
  2. Reliability 
<br>
     Rationale: The system will perform exactly to the specifications listed in the development process.
<br>
     Description: The data entries should be added in correctly. By adding one-hundred data entries, the success rate should be ninety-nine percent accurate.
<br>
  3. Usability
<br>
     Rationale: This application should be designed to be easy to use in order to encourage users to keep track on the spendings regularly. 
<br>
     Description: In order to make the application more user-friendly, the home screen will be accessible by clicking the back button on the current screen by at most 2 times after the user logs in. 
<br>
    
#### __5.5   Business Rules__ 

There are no classifications between different types of users, so all users have equal access to different features of the app.

<br>

### __6.   Other Requirements__

### __Appendix A: Glossary__
- Mobile Application - a type of application software designed to run on a mobile device
- Income - money received, especially on a regular basis, for work or through investments
- Expense - the cost required for something; the money spent on something
- PIN (Personal Identification Number) - a numeric password used to authenticate a user to a system
- Security Question - questions to authenticate customers to provide an additional layer of security

### __Appendix B: Analysis Models__

### __Appendix C: To Be Determined List__
  1. Although we are using a PIN number system, the team is still considering the option of using passwords instead to make the application more secure and lower the risk of the user’s financial information to be compromised. 
