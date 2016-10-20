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

#### __3.2   Hardware Interfaces__

#### __3.3   Software Interfaces__

#### __3.4   Communications Interfaces__

<br>


### __4.   System Features__ 
#### __4.1   Add Income__
  1. User adds an amount that increases total spendable income - High Priority
  2. Stimulus/Response Sequences
  3. Functional Requirements

#### __4.3   Add Expense__

#### __4.4   Edit Income__

#### __4.5   Edit Expense__


#### __4.6   Create Pin__


#### __4.7   Edit Pin__


#### __4.8   Verify Pin__

#### __4.9   Application Timeout__

#### __4.10   Create Security Question__

#### __4.11   Verify Security Question__

#### __4.12   Edit Security Question__

#### __4.13   View Tips__

#### __4.14   View All Logs__

#### __4.15   Sort Logs by Amount__

#### __4.16   Sort Logs by Category__

#### __4.17   Sort Logs Date__





<br>

### __5.   Other Nonfunctional Requirements__ 
#### __5.1   Performance Requirements__
  1. Data Entry Performance
<br>
     Rationale: The data put in by the user must be put in the system fast enough for the user to still use the system.
<br>
     Description: When the user enters in his an income our expense, their budget should update within 2 seconds of confirming the input.
<br>
     Ref:
#### __5.2   Safety Requirements__
Someone could potentially make a poor financial decision based on inaccurate information if they do not enter all of their expenses as expected by the program.
<br>

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
  1. Maintainability and Extendability  
<br>
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

<br>

### __6.   Other Requirements__

### __Appendix A: Glossary__

### __Appendix B: Analysis Models__

### __Appendix C: To Be Determined List__


