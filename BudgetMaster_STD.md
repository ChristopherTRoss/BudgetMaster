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
- TC 6 :- successful edit of income
- TC 7 :- successful edit of expense
- TC 8 :- successful deletion of income
- TC 9 :- successful deletion of expense
- TC 10 :- successful cancellation of item deletion
- TC 11 :- successful creation of category
- TC 12 :- unsuccessful creation of category due to invalid fields
- TC 13 :- successful edit of category
- TC 14 :- successful deletion of category
- TC 15 :- successful cancellation of category deletion
- TC 16 :- successful opening of side-menu
- TC 17 :- successful opening of transaction log
- TC 20 :- successful creation of PIN number.
- TC 21 :- unsuccessful creation of PIN number
- TC 22 :- successful PIN number change.
- TC 23 :- unsuccessful PIN number change.
- TC 24 :- successful login.
- TC 25 :- unsuccessful operation due to wrong PIN number entered 10 times.
- TC 26 :- successful creation of 3 security questions.
- TC 27 :- unsuccessful creation of 3 security questions.
- TC 28 :- successful view of analysis
- TC 29 :- successful sorting of logs by amount
- TC 30 :- successful sorting of logs by category
- TC 31 :- successful sorting of logs by date
- TC 32 :- successful force logout
- TC 33 :- successful application timeout
- TC 34 :- successful opening of home
- etc...

<br> 
<br>

### Test Case 1

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 1           | Successful addition of income| BudgetMaster | Balance | Ross Thompson | 11/20/2016 | Test the income addition feature on the main page                 |

|    Pre-conditions     |
|---------------------|
|  1. User must be at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button|Prompts the user to select category, expense, or income |               |             |
|  2   | Select income | Give the user a form asking for the amount, whether or not it recurs, and for an optional description | |  |
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
| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 1           | Unsuccessful addition of income due to invalid number| BudgetMaster | Balance | Ross Thompson | 11/20/2016 | Test the error-checking of the income addition feature on the main page                 |

|    Pre-conditions     |
|---------------------|
|  1. User must be at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button| Prompts the user to select category, expense, or income |               |             |
|  2   | Select income | Give the user a form asking for the amount, whether or not it recurs, and for an optional description | |  |
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

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|  3 | Successful addition of expense | BudgetMaster | Balance  | Ross Thompson | 11/20/16 |  Test the expense addition feature on the main page |

|    Pre-conditions     |
|---------------------|
|  1. User must be at the main page   |
|  2. "Testing" category has already been made |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button|Prompts the user to select category, expense, or income |               |             |
|  2   | Select expense | Give the user a form asking for the amount, the category, whether or not it recurs, and an optional description |               |             |
|  3   | Fill the amount field with $30, select the category "Testing", select non-recurring, and enter "sample expense" as the description, then submit | Return to main page |               |             |
|  4   | Check post-conditions           |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The total budget amount has been decreased by $30  |
|  2. The "Testing" category amount has been decreased by $30    |
|  3. A transaction log entry is made that lists the current date, the category ("Testing"), the description ("sample expense"), the amount ($30), and that the expense is non-recurring. |
|  4. The entry has been added to the database |

<br>
### Test Case 4

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 4           | Unsuccessful addition of expense due to invalid number| BudgetMaster | Balance | Ross Thompson | 11/20/2016 | Test the error-checking of the expense addition feature on the main page                 |

|    Pre-conditions     |
|---------------------|
|  1. User must be at the main page   |
|  2. "Testing" category must exist  |

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

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 5 | Successful recurrence of an entry| BudgetMaster| Balance | Ross Thompson | 11/20/16  | Test that a recurring entry successfuly repeats |

|    Pre-conditions     |
|---------------------|
|  1. The user must be on the main page  |

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

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 6   | Successful edit of income | BudgetMaster | Transaction Log | Ross Thompson | 11/20/16 | Test that the fields of an income can be changed  |

|    Pre-conditions     |
|---------------------|
|  1. User must be on the transaction log page    |
|  2. An income entry exists with description "Test" and amount $10.  |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Press and hold on "Test" entry | Ask the user if they would like to "Edit" or "Delete"  |               |             |
|  2   | Select "Edit" | Present a form with editable fields for the amount and description  |               |             |
|  3   | Change the description field to "Successful Test"  |                                  |               |             |
|  4   | Change the amount field to $35 | | | |
|  5   | Click "Save" | The form will close and the user will be back at the transaction log | | |
|  6   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The total balance has increased by $15 |
|  2. The "Income" category has increased by $15 |
|  3. The description now says "Successful Test" |
|  4. The amount of the "Successful Test" entry displays $35 |
|  5. The database has been updated with the new values |

<br>
### Test Case 7

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 7   | Successful edit of expense | BudgetMaster | Transaction Log | Ross Thompson | 11/20/16 | Test that the fields of an expense can be changed  |

|    Pre-conditions     |
|---------------------|
|  1. User must be on the transaction log page    |
|  2. A category exists named "Pre-test" |
|  3. A category exists named "Post-test" |
|  4. An expense entry exists with description "Test", amount $10, and category "Pre-test"  |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Press and hold on "Test" entry | Ask the user if they would like to "Edit" or "Delete"  |               |             |
|  2   | Select "Edit" | Present a form with editable fields for the amount, category, and description  |               |             |
|  3   | Change the description field to "Successful Test"  |                                  |               |             |
+|  4   | Change the amount field to $35 | | | |
|  5   | Change the category to "Post-test" | 
|  5   | Click "Save" | The form will close and the user will be back at the transaction log | | |
|  6   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The total balance has decreased by $15 |
|  2. The "Test" category has decreased by $10 |
|  3. The entry now has category "Post-Test" |
|  4. The "Post-Test" category has increased by $35 |
|  5. The description now says "Successful Test" |
|  6. The amount of the "Successful Test" entry displays $35 |
|  7. The database has been updated with the new values |

<br>
### Test Case 8

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 8   | Successful deletion of income | BudgetMaster | Transaction Log | Ross Thompson | 11/20/16 | Test that an income can be deleted correctly |

|    Pre-conditions     |
|---------------------|
|  1. User must be on the transaction log page  |
|  2. An income entry exists with description "DeleteTest" and amount $10 |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Press and hold on "Test" entry | Ask the user if they would like to "Edit" or "Delete"  |               |             |
|  2   | Select "Delete" | Return to the transaction log  |               |             |
|  3   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The total balance has decreased by $10 |
|  2. The "Income" category has decreased by $10 |
|  3. The "DeleteTest" entry is no longer in the transaction log |
|  4. The entry has been removed from the database |

<br>
### Test Case 9

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 9   | Successful deletion of expense | BudgetMaster | Transaction Log | Ross Thompson | 11/20/16 | Test that an expense can be deleted correctly |

|    Pre-conditions     |
|---------------------|
|  1. User must be on the transaction log page  |
|  2. A "DeletionCategory" category exists |
|  2. An expense entry exists with description "DeleteTest" and amount $10 |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Press and hold on "DeleteTest" entry | Ask the user if they would like to "Edit" or "Delete"  |               |             |
|  2   | Select "Delete" | Return to the transaction log  |               |             |
|  3   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The total balance has increased by $10 |
|  2. The "DeletionCategory" category has decreased by $10 |
|  3. The "DeleteTest" entry is no longer in the transaction log |
|  4. The entry has been removed from the database |

<br>
### Test Case 10

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 10   | Successful cancellation of item deletion | BudgetMaster | Transaction Log | Ross Thompson | 11/20/16 | Test that the deletion confirmation works |

|    Pre-conditions     |
|---------------------|
|  1. User must be on the transaction log page  |
|  2. An entry exists with description "DeleteTest" and amount $10 |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Press and hold on "Test" entry | Ask the user if they would like to "Edit" or "Delete"  |               |             |
|  2   | Select "Delete" | Ask the user if they are sure, giving the options Yes or No  |               |             |
|  3   | Select No  | Return to the transaction log | | |
|  3   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The balance remains the same |
|  2. The "DeleteTest" entry is still in the transaction log |
|  3. The entry is still in the database |

<br>
### Test Case 11

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 11  | Successful creation of category | BudgetMaster | Balance | Ross Thompson | 11/20/16 | Tests that a category may be added to the system |

|    Pre-conditions     |
|----------------------|
|  1. User is at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button | Prompts the user to select category, expense, or income |     |    |
|  2   | Select category | Prompts the user for the name and the maximum monthly budget amount of the category |  |  |
|  3   | Enter "AddingCategory" as the name | | | |
|  4   | Enter $100 as the amount | | | |
|  5   | Press Submit | Returns the user to the main page | | | |
|  6   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The category named "AddingCategory" has been added to the main page  |
|  2. The category has $0 in it and a suggested budget ceiling of $100   |
|  3. The category has been added to the database |

<br>
### Test Case 12

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 12  | Unsuccessful creation of category due to invalid fields | BudgetMaster | Balance | Ross Thompson | 11/20/16 | Tests for category creation error checks |

|    Pre-conditions     |
|----------------------|
|  1. User is at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click floating action button | Prompts the user to select category, expense, or income |     |    |
|  2   | Select category | Prompts the user for the name and the maximum monthly budget amount of the category |  |  |
|  3   | Enter $50 as the amount | | | |
|  4   | Press Submit | The system will stay on the page and notify the user that he left a field blank (Name) | | |
|  4   | Make the amount blank and enter "CategoryTest" as the name | The system will stay on the page and notify the user that he left a field blank (Amount) | | |
|  5   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. A category was not added on the main page  |
|  2. The category was not added to the database  |

<br>
### Test Case 13

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 13 | Successful edit of category | BudgetMaster | Balance | Ross Thompson | 11/20/16 | Test that a category may be edited |

|    Pre-conditions     |
|----------------------|
|  1. A "CategoryEditing" category exists with max amount $80  |
|  2. The user is at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Press and hold on the "CategoryEditing" category | Ask the user if they would like to Edit or Delete | | |
|  2   | Select Edit | Present a form with editable text fields for Name and Amount |               |             |
|  2   | Change the name field to "Edited"  |                                  |               |             |
|  3   | Change the amount field to $100  |                                  |               |             |
|  4   | Press Submit | Return the user to the main page | | |
|  5   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The category name is now displayed as "Edited"   |
|  2. The "Edited" category now has a ceiling of $100   |
|  3. The category has been updated in the database |

<br>
### Test Case 14

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 14 | Successful deletion of category | BudgetMaster | Balance | Ross Thompson | 11/20/16 | Test that a category may be deleted |

|    Pre-conditions     |
|----------------------|
|  1. A category named "DeleteTest" exists with ceiling of $60  |
|  2. The user is at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Press and hold on the "DeleteTest" category | Ask the user if they would like to Edit or Delete | | |
|  2   | Select Delete | Ask the user if they are sure, giving the options Yes or No |               |             |
|  3   | Select Yes  | Return the user to the main page                                 |               |             |
|  4   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The category is no longer on the main page   |
|  2. The category has been removed from the database |

<br>
### Test Case 15

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
| 15 | Successful cancellation of category deletion | BudgetMaster | Balance | Ross Thompson | 11/20/16 | Test that the deletion confirmation works |

|    Pre-conditions     |
|----------------------|
|  1. A category named "DeleteTest" exists with ceiling of $60  |
|  2. The user is at the main page   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Press and hold on the "DeleteTest" category | Ask the user if they would like to Edit or Delete | | |
|  2   | Select Delete | Ask the user if they are sure |               |             |
|  3   | Select No  | Return the user to the main page                                 |               |             |
|  4   | Check post-conditions | | | |

|     Post-conditions    |
|----------------------|
|  1. The category is still on the main page   |
|  2. The category is still in the database |

<br>
### Test Case 16

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
### Test Case 20

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------------:|
|     20      |     Successful Creation of PIN           |   BudgetMaster     |   PIN     | Christopher Ross   |    11/17/16   | Test the creation of the user's initial PIN creation     |  

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
### Test Case 21

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------------:|
|     21      |     Unsuccessful Creation of PIN           |   BudgetMaster     |   PIN     | Christopher Ross  |    11/17/16   | Test the error checks for creating a PIN when the confirmation does not match    |          

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
### Test Case 22

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------------:|
|    22    |   Successful PIN Change   |    BudgetMaster    |   PIN    | Christopher Ross |   11/16/16  | Test the change PIN feature | 

|    Pre-conditions     |
|---------------------|
|  1. The user has already used BudgetMaster and has created a PIN|
|  2. The user has three security questions saved |
|  3. The first question is "Answer this" and the answer is "Answer" |
|  4. The PIN is 1234   |
|  5. The user is at the login screen            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   |  Click the change my PIN button |  The app displays a message asking the user to answer the first question, "Answer this" |               |             |
|  2   |  Enter the answer "Answer" | The app prompts the user to enter their new PIN  |               |             |
|  3   |   Enter '1111' | The system asks the user to re-enter their new PIN           |               |             |
|  4   |   Re-enter '1111' |       The system will bring the user to the home screen   |               |             |
|  5   |   Check post-condition 1   |                                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The new PIN '1111' is saved in the database   |

<br>
### Test Case 23

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------:|:--------------:|:-----------------:|
|     23      | Unsuccessful PIN Change | BudgetMaster  |    PIN     | Christopher Ross   | 11/17/16   | Test the change PIN feature | 

|    Pre-conditions     |
|----------------------|
|  1. The user has already used BudgetMaster and has created a PIN |
|  2. The user has three security questions saved |
|  3. The first question is "Answer this" and the answer is "Answer" |
|  4. The second question is "Answer again" and the answer is "2nd Answer" |
|  5. The PIN is 1234   |
|  6. The app displays the login screen            |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | Click the change my PIN button | The app displays a message asking the user to answer the question "Answer this" |               |             |
|  2   | Enter "Not the answer" 3 times | After 3 failed attempts, the system will prompt the user the question "Answer again"                                  |               |             |
|  3   |  Enter "Still not the answer" 3 times | After the 3rd attempt, the system will take the user back to the PIN screen |               |             |
|  4   |   Check post-condition 1   |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The original PIN does not change  |


<br>
### Test Case 24

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|:-----------------:|
|   24        |   Successful login     | BudgetMaster   |   PIN    | Christopher Ross |   11/17/16     | The user successfully logs in by entering the correct PIN            |

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
### Test Case 25

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|    25       | Unsuccessful Login | BudgetMaster |  PIN   | Christopher Ross   | 11/21/16 |The user enters the wrong PIN three times |       

|    Pre-conditions     |
|----------------------|
|  1. The user has aleardy used BudgetMaster and has created a PIN  |
|  2. The PIN is 1234   |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | The user opens the app | The PIN screen opens |               |             |
|  2   | The user enters 1111, 1112, 1113. 1114, 1115, 1116, 1117, 1118, 1119, 1120   | The system will display 'Invalid PIN' |               |             |
|  3   | Check post-condition 1  |                                  |               |             |


|     Post-conditions    |
|----------------------|
|  1. The user is locked out and must reset their PIN   |



<br>
### Test Case 26

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|    26       | Succesfull security question creation |  BudgetMaster | Security Questions | Christopher Ross | 11/21/16 | The user successfully creates 3 security questions |

|    Pre-conditions     |
|----------------------|
|  1. The user has just created a PIN for the first time |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | The user types their own 3 security questions and answers them     | The database stores the security questions and answers |               |             |
|  2   | Check post-condition 1 |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The user will be logged in and taken to the home screen   |


<br>
### Test Case 27

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|    27       | Unsuccesfull security question creation |  BudgetMaster | Security Questions | Christopher Ross | 11/21/16 | The user unsuccessfully creates 3 security questions |

|    Pre-conditions     |
|----------------------|
|  1. The user has just created a PIN for the first time |

| Step |   Action   |     Expected System Response     |   Pass/Fail   |   Comment   |
|:---- |:----------:|:--------------------------------:|:-------------:| -----------:|
|  1   | The user fails to fill out all 3 questions and 3 answers    | The database does not store the security questions and answers |               |             |
|  2   | Check post-condition 1 |                                  |               |             |

|     Post-conditions    |
|----------------------|
|  1. The user will still be at the security question creation screen |


<br>
### Test Case 28

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
### Test Case 29

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
### Test Case 30

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
### Test Case 31

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
### Test Case 32

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
### Test Case 33

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
### Test Case 34

| Test Case # | Test Case Name | System | Subsystem | Designed by | Design Date | Short Description |
|:----------- |:--------------:|:------:|:---------:|:-----------:|:-----------:|-------------------|
|             |                |        |           |             |             |                   |

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
### etc...
