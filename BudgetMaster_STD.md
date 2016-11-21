# Software Testing Document

### for

# BudgetMaster

#### Version 1.0 approved

### Prepared by Grant Hardy, Ross Thompson, Jason Williams, Adrian Colon, Chris Ross, and Morgan Root

### LSU

### November 21, 2016

<br>
<br> 
<br>

## Test Cases for BudgetMaster
- TC 1 :- successful addition of income
- TC 2 :- unsuccessful addition of income due to invalid number
- TC 3 :- successful addition of expense
- TC 4 :- unsuccessful addition of expense due to invalid number
- TC 5 :- successful recurrence of an entry
- TC 5 :- successful edit of income
- TC 6 :- successful edit of expense
- TC 7 :- successful deletion of income
- TC 8 :- unsuccessful deletion of income
- TC 9 :- successful deletion of expense
- TC 10 :- unsuccessful deletion of expense
- TC 11 :- successful creation of category
- TC 12 :- unsuccessful creation of category due to invalid name entered
- TC 13 :- unsuccessful creation of category due to 
- TC 14 :- successful edit of category
- TC 15 :- successful deletion of category
- TC 16 :- unsuccessful deletion of category
- TC 17 :- successful opening of side-menu
- TC 18 :- successful opening of transaction log
- TC 19 :- successful creation of PIN number.
- TC 20 :- unsuccessful creation of PIN number
- TC 21 :- successful PIN number change.
- TC 22 :- unsuccessful PIN number change.
- TC 23 :- successful entry of PIN number.
- TC 24 :- unsuccessful operation due to wrong PIN number entered 3 times.
- TC 25 :- successful creation of 3 security questions.
- TC 26 :- unsuccessful creation of 3 security questions.
- TC 27 :- successful view of analysis
- TC 28 :- successful sorting of logs by amount
- TC 29 :- successful sorting of logs by category
- TC 30 :- successful sorting of logs by date
- TC 31 :- successful force logout
- TC 32 :- successful application timeout
- TC 33 :- successful opening of home
- etc...

<br> 
<br>

### Test Case 1

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
| 1           | Successful addition of income| BudgetMaster | Balance | Ross Thompson | 11/20/2016 |    |      | Test the income addition feature on the main page                 |

|    Pre-conditions     |
|---------------------|
|  1. User must be logged in   |
|  2. User must be at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button|Prompts the user to select category, expense, or income |               |             |
|  2   | Select income | Give the user a form asking for the amount, whether or not it recurs, and for an optional description |               |             |
|  3   | Fill the amount field with $40, select non-recurring, and enter "sample income" as the description, then submit | Return to main page |               |             |
|  4   | Check post-conditions           |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The total budget amount has been increased by $40  |
|  2. The "Income" category amount has been increased by $40    |
|  3. A transaction log entry is made that lists the current date, the description ("sample income"), the amount ($40), and that the payment is non-recurring. |
|  4. The entry has been added to the database |

<br>

### Test Case 2

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
| 1           | Unsuccessful addition of income due to invalid number| BudgetMaster | Balance | Ross Thompson | 11/20/2016 |    |      | Test the error-checking of the income addition feature on the main page                 |

|    Pre-conditions     |
|---------------------|
|  1. User must be logged in   |
|  2. User must be at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button| Prompts the user to select category, expense, or income |               |             |
|  2   | Select income | Give the user a form asking for the amount, whether or not it recurs, and for an optional description |               |             |
|  3   | Leave the amount field blank, select non-recurring, and enter "sample income" as the description, then submit | Notify user of empty field and wait for a correct entry |               |             |
|  4   | Update the amount field with "abc" | Notify user of invalid amount and wait for a correct entry   |               |          |
|  5   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. A transaction entry has not been made |
|  2. The total balance has not been changed |
|  3. The "Income" category amount has not been changed |
|  4. A database entry has not been made |

<br> 
### Test Case 3

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|  3 | Successful addition of expense | BudgetMaster | Balance  | Ross Thompson | 11/20/16 |             |                |  Test the expense addition feature on the main page |

|    Pre-conditions     |
|---------------------|
|  1. User must be logged in   |
|  2. User must be at the main page   |
|  3. "Testing" category has already been made |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button|Prompts the user to select category, expense, or income |               |             |
|  2   | Select expense | Give the user a form asking for the amount, the category, whether or not it recurs, and an optional description |               |             |
|  3   | Fill the amount field with $30, select the category "Testing", select non-recurring, and enter "sample expense" as the description, then submit | Return to main page |               |             |
|  4   | Check post-conditions           |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The total budget amount has been increased by $30  |
|  2. The "Testing" category amount has been increased by $30    |
|  3. A transaction log entry is made that lists the current date, the category ("Testing"), the description ("sample expense"), the amount ($30), and that the expense is non-recurring. |
|  4. The entry has been added to the database |

<br>
### Test Case 4

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
| 1           | Unsuccessful addition of expense due to invalid number| BudgetMaster | Balance | Ross Thompson | 11/20/2016 |    |      | Test the error-checking of the expense addition feature on the main page                 |

|    Pre-conditions     |
|---------------------|
|  1. User must be logged in   |
|  2. User must be at the main page   |
|  3. "Testing" category must exist  |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button | Prompts the user to select category, expense, or income |               |             |
|  2   | Select expense | Give the user a form asking for the amount, category, whether or not it recurs, and for an optional description |               |             |
|  3   | Leave the amount field blank, select "Testing" as the category, select non-recurring, and enter "sample expense" as the description, then submit | Notify user of empty field and wait for a correct entry |               |             |
|  4   | Update the amount field with "abc" | Notify user of invalid amount and wait for a correct entry   |               |          |
|  5   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. A transaction entry has not been made |
|  2. The total balance has not been changed |
|  3. The "Testing" category amount has not been changed |
|  4. A database entry has not been made |

<br>
### Test Case 5

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
| 5 | Successful recurrence of an entry| BudgetMaster| Balance | Ross Thompson | 11/20/16  |             |                | Test that a recurring entry successfuly repeats |

|    Pre-conditions     |
|---------------------|
|  1. User is logged in   |
|  2. User is on main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button|Prompts the user to select category, expense, or income |               |             |
|  2   | Select income | Give the user a form asking for the amount, whether or not it recurs, and for an optional description |               |             |
|  3   | Fill the amount field with $50, select recurring, and enter "recurring sample" as the description | Asks the user how often it recurs |               |             |
|  4   | Select 1 day | Return to main page                                 |               |             |
|  5   | Check post-conditions 1-4 | | | |
|  6   | Wait 1 day   | | | |
|  7   | Check post-condition 5 | | | |

|     Post-conditions    |
|----------------------|
|  1. The total budget amount has been increased by $50  |
|  2. The "Income" category amount has been increased by $50    |
|  3. A transaction log entry is made that lists the current date, the description ("recurring sample"), the amount ($50), and that the payment is recurring. |
|  4. The entry has been added to the database |
|  5. Post-conditions 1-4 are duplicated |

<br>
### Test Case 6

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|---------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 7

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|---------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 8

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|---------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 9

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|---------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 10

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 11

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 12

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 13

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 14

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 15

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 16

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 17

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 18

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Executed by | Execution Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:| -----------------:|
|             |                |        |           |             |             |             |                |                   |

|    Pre-conditions     |
|----------------------|
|  1. Pre-condition 1   |
|  2. Pre-condition 2   |
|  3. etc...            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |            |                                  |               |             |
|  2   |            |                                  |               |             |
|  3   |            |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. Post-condition 1   |
|  2. Post-condition 2   |
|  3. etc...             |

<br>
### Test Case 19

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------------:|
|     19      |     Successful Creation of PIN           |   BudgetMaster     |   PIN     |             |    11/17/16   | The user creation of their 4 digit PIN upon opeing the app for the first time     |  

|    Pre-conditions     |
|----------------------|
|  1. The user has never used the app before  |


| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | The user opens the app        | The user will be prompted to create a 4 digit PIN number |               |             |
|  2   | The user enters 1234          | The system will ask them to re-enter the number to confirm  |             |             |
|  3   | The user enters 1234          | The system will prompt the user to create three security questions |      |             |
|  4   | Check post-condition 1         |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The system saves the user's PIN as '1234'    |


<br>
### Test Case 20

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------------:|
|     20      |     Unsuccessful Creation of PIN           |   BudgetMaster     |   PIN     |             |    11/17/16   | The user creation of their 4 digit PIN upon opening the app for the first time     |          

|    Pre-conditions     |
|----------------------|
|  1. The user has never used the app before   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | The user opens the app | The user will be prompted to create a 4 digit PIN number |               |             |
|  2   | The user enters 1234   | The system will ask them to re-enter the number to confirm  |            |             |
|  3   | The user enters 1111   | The system will ask the user to try again                  |             |             |
|  4   | Check post-condition 1         |                                  |               |             |


|     Post-conditions    |
|----------------------|
|  1. The system does not have a PIN for the user, and the app does not open to the home screen   |


<br>
### Test Case 21

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------------:|
|    21    |   Successful PIN Change   |    BudgetMaster    |       PIN    |             |   11/16/16  | Test the change PIN feature | 

|    Pre-conditions     |
|---------------------|
|  1. The user has aleardy used BudgetMaster and has created a PIN|
|  2. The user has three security questions saved |
|  3. The PIN is 1234   |
|  4. The app displays the login screen            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |  Click the change my PIN button |  The app displays a message asking the user to answer one of the three security questions |               |             |
|  2   |  Correctly answer one of the three security questions | The app prompts the user to enter their new PIN  |               |             |
|  3   |   Enter '1111' | The system asks the user to re-enter their new PIN           |               |             |
|  4   |   Re-enter '1111' |       The system will bring the user to the home screen   |               |             |
|  5   |   Check post-condition 1   |                                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The new PIN '1111' is saved in the database   |

<br>
### Test Case 22

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:|:-----------------:|
|     22      | Unsuccessful PIN Change     | BudgetMaster  |    PIN     |             | 11/17/16   | Test the change PIN feature | 

|    Pre-conditions     |
|----------------------|
|  1. The user has already used BudgetMaster and has created a PIN |
|  2. The user has three security questions saved |
|  3. The PIN is 1234   |
|  4. The app displays the login screen            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click the change my PIN button | The app displays a message asking the user to answer one of the three security questions |               |             |
|  2   | Uncorrectly answer one of the three security questions | After 3 failed attempts, the system will prompt the user with a different question.                                  |               |             |
|  3   |  Uncorrectly answer one of the three security questions |  The system will take the user back to the PIN screen |               |             |
|  4   |   Check post-condition 1   |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The original PIN does not change  |


<br>
### Test Case 23

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------------:|
|   23        |   Successful Login     |  PIN    |   BudgetMaster    |             |   11/17/16     | The user successfully logs in by entering the correct PIN            |

|    Pre-conditions     |
|----------------------|
|  1. The user has aleardy used BudgetMaster and has created a PIN |
|  2. The PIN is 1234   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | The user opens the app | The PIN screen opens |               |             |
|  2   | The user enters 1234   | The home screen opens |               |             |

|     Post-conditions    |
|----------------------|
|  1. The system opens up to the home screen  |


<br>

### etc...
