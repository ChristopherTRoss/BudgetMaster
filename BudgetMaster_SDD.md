# Software Design Document

### for

# BudgetMaster

#### Version 1.0 approved

### Prepared by Grant Hardy, Ross Thompson, Jason Williams, Adrian Colon, Chris Ross, and Morgan Root

### LSU

### November 2, 2016

<br><br><br>

### Table of Contents

#### Table of Contents
#### Revision History

#### 1. Introduction
  1. Purpose
  2. Scope
  3. Intended Audience
  4. Design Summary
  
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
