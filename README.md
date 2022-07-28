# Project 1 - Employee Reimbursment System (ERS)

## Executive Summary
The Employee Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement. The reimbursement types should have the following options: LODGING, FOOD, TRAVEL


# Tech Stack
 - Java 8
 - Apache Maven
 - PostgreSQL
 - AWS RDS
 - Spring Boot
 - Spring Data JPA
 - HTML
 - CSS
 - Thymeleaf

# Functional Requirements
 - Domain objects persisted in relational database
 - Database should be in 3NF
 - CRUD functionality for all domain objects
 - All CRUD functionality accessible via RESTful API
 - Functional web UI to consume RESTful API
 - Workflows to complete all user stories
 - Validate all user input
 - Unit test coverage for service-layer classes

# User Stories
### Requirements:
#### Guest:
 - As a guest, I can register for a new account
 - As a guest, I can log into my account

#### User:
 - As a user, I can submit a request for reimbursement
 - As a user, I can cancel a pending request for reimbursement
 - As a user, I can view my pending and completed past requests for reimbursement
 - As a user, I can edit my pending requests for reimbursement

#### Admin/Finance Manager:
 - As an admin, I can approve expense reimbursements
 - As an admin, I can deny expense reimbursements
