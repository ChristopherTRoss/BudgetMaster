# Active Document

## Index
  * Vision
  * Configuration Management Plan
  * Process Model
  * Deliverables
  * Potential Risks
  * Team Members
  * Project Schedule
  * Meeting Summaries

## Vision
  Our product is designed to provide a budgeting mobile application for all people from college students to adults keep track of their day to day expenses in order to help make a budget. 
  Our product will have an user-friendly interface in order to encourage users to use the app often to enter in all expenses and incomes.
  This will allow users to get an accurate representation of what their spending was in a given time period as well as providing insight of which categories they are overspending in.
  The user will be able to view all the expenses and incomes in a transaction log and be able to sort the log in various ways in order to get further insights into their budget.
  The application will also help the user make their monthly budget by constantly displaying how much current money they have to spend in each category.
  As an extra feature to further help users make smarter purchase decisions, the application will provide tips and goals to the user that will encourage the user to spend their money in a more efficient manner.
  Through all these goals and features, we want our users to be able and encouraged to record every income/expense in order to keep a better track of the user's money.
## Configuration Management Plan
  Our team plans to use Github as the main source of Configuration Management. We will use Github to store all our documents and application files.  We will also use Google Docs for documents in certain instances where we want to actively see what another use is working on.
##Process Model
  Our team plans on using the phase development model in order to structure our app in a way that allows many features to be added.  We plan on first developing an app with a basic features of adding incomes and expenses and creating a transaction log.
  In our next development, we aim to add the login feature and ability to sort the transaction in basic ways.  
  After that in our final development, we plan to flesh out everything with the application design, and add the tips/goals system to the app.
  After this development, our app aims to still be structured to easily handle and further features that we wish to add.
## Deliverables

## Potential Risks
  Since our application involves money and purchase history of users, there will be various risks.
  1. There is a risk that a user loses their mobile device, and therefore someone else can access their purchase history.
  2. There is also a liability issue that users may use the information provided in the application and use our application as a reason for going under their budget.
  3. There is a time risk in our process as most of team members are still new to mobile development and may come across some unexpected issues to delay iterations of our development.
  4. There is a human error risk in our application since the information is not verified by anyone past the user.  So if the user inputs incorrect data entries or forgets to add expenses in, the budget summaries will become incorrect.

## Team Members
  Our team Members are:
  * Grant Hardy - back-end and works with the database
  * Ross Thompson - back-end functionality and implement login system
  * Jason Williams -front-end design and keeps the group aligned with the vision of the product
  * Chris Ross - Front end design, kept track of all documents and their needed updates
  * Morgan Root - Back end design, Meeting Leader and Note taking
  * Adrian Colon - Front end design
  
  Our team followed the egoless approach where every team member was held accountable. Different people had different roles based on strengths, but their was no responsibility heirarchy.
  

## Project Schedule

## Meeting Summaries

### Meeting 1 Summary: 10/9/16 - 5:30-6:15
Members: Adrian Colon, Chris Ross, Morgan Root, Grant Hardy, Ross Thompson, Jason Williams
What do we want to see at the home screen? Login? Balance page?
Incremental Phase Development for our development process
Egoless team - different people have different roles based on strengths but no responsibility heirarchy

How do we want the income/categories to be handled? Input total income and make categories based on % or input dollar amount for each category? Categorize incomes/expenses separately.
Keep track of default monthly income, allow them to add in extra incomes (e.g. birthday money etc) each time period
Allow user to change time period of budget - ex. weekly, biweekly, monthly
Floating button to add choice of either income or expense, then select the category/type
Also the user can add their own categories

List total income user started time period with and how much is left. Show spendable income (factoring out monthly bills) or actual remaining income?
List categories - show amount spent in each so far (Show max?)
button to take them to transaction log
settings page
database? login feature?
By the end of the meeting we assigned roles to all of the members and made some descisions on how to app will be designed, and how the app will look and function.

<br>

### Meeting 2 Summary: 10/18/16 - 7:00 - 9:00 PM
Members: Adrian Colon, Chris Ross, Morgan Root, Grant Hardy, Ross Thompson, Jason Williams
We started working on the SRS document as a group in the study room at The Exchange.

We decided to go with a PIN login rather than a username and password system for a simpler approach to the login of the app. If the user forgets their pin we will add three security questions in order to have a way to reset the PIN but keep the users information secure.
We discussed if we would use a database for software interface. We drew out the possible screens of the app on a whiteboard to get an overview of how many screens and feature the app will have.

We discussed all of the features and how we will implement them in the alloted time given to complete the app.
By the end of the meeting we have completed the inital draft of the SRS document, and a made decison on the design and user interface of the app after creating an inital hand drawn draft of the user interface. We decided that we will use SQLite for the database for the app.

<br>

### Meeting 3 Summary: 10/31/16 - 6:20 - 7:00 PM
Members: Adrian Colon, Chris Ross, Morgan Root, Grant Hardy, Ross Thompson, Jason Williams
We started working on the SDD and drew out all of the diagrams needed for the SDD.
We talked about different ways to do subsystems architecture and how the app does not have a physical view since everything is handled locally on the android device.

We created a better draft of the user interface by using an online site to draw out the multiple screens and actions that the app can do. 
We further discussed how the PIN system will work and how the user will input their three security questions. We decided on the categories that the user can pick for their budget and how the recurring expense function will work.

We editted and finished the database view as well as the development view.

We discussed the rational for all of the architectural choices until the group agreed on what to write under that section in the SDD.
We looked over the finished entity relationship diagram and made a few revisions before adding it to the SDD.
By the end of the meeting we had completed the initial draft of the SDD.

