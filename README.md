# Project 1
Project Description
 - Tuition Reimbursement Management System is a full-stack web application that allows employees to submit requests for reimbursements for courses, events, and certifications. These requests can then be approved or rejected by the employee's direct supervisor, department head, and a benefits coordinator while the employee is able to track the status of their requests.

## Technologies Used
- Java 8
- Apache Tomcat 9
- Maven
- HTML/CSS
- JavaScript
- Visual Studio Code
- DBeaver/PostgreSQL
- Log4j
- Postman
- AWS RDS

## Features
- Employees can submit a reimbursement request.
- Employees can view and edit their requests.
- Reimbursements requests must be sent up the chain to Direct Supervisor, Department Head, and Benco in that order and be either accepted and moved up, modified, or denied.
- At each level the Direct Supervisor, Department Head, and Benco can request information from the levels below them.
- When all parties have accepted a request the amount of reimbursement (based on original cost and the type of course/event) is awarded to the requestor.

## Getting Started
Git:  git clone https://github.com/210823-java-msa-wvu/alex-easley-p1.git

### Database Setup
- create table employee (
first_name varchar not null,
last_name varchar not null,
email varchar unique,
username varchar unique not null,
password varchar not null,
address varchar,
id serial primary key,
employee_type varchar not null,
department varchar,
reports_to integer,
avail_assist integer default(1000)
)
- insert into employee (username, password, first_name, last_name, employee_type, department, reports_to) values
('Al', 'pass', 'Alan', 'Lars', 'benco', 'hr', 1), 
('Bob', 'pass', 'Bobby', 'Earls', 'employee', 'buildinga', 3), 
('Chris', 'pass', 'Chris', 'Childs', 'supervisor', 'buildinga', 4), 
('Danny', 'pass', 'Daniel', 'Griffon', 'departmenthead', 'buildinga', 4), 
('Issac', 'pass', 'Issac', 'Pole', 'employee', 'buildingb', 6), 
('Carl', 'pass', 'Carlton', 'Pillon', 'supervisor', 'buildingb', 7),
('Pam', 'pass', 'Pamela', 'Westbrook', 'departmenthead', 'buildingb', 7);
- create table Requests (
request_id serial not null unique primary key,
event_type varchar not null,
employee_id integer  references employee(id)on delete set null,
grade varchar default('Not Yet Complete'),
justif varchar,
cost integer,
description varchar,
req_date DATE,
start_date DATE,
location varchar,
status varchar default('Not Yet Complete'),
pass_grade varchar default('Not Yet Complete'),
pass boolean default(null));
- create table approval (
approval_id integer references employee(id) on delete set null,
id serial not null unique primary key,
dsapproval boolean default false,
dsinforequest boolean default false,
dsdenialreason varchar default('n/a'),
dhapproval boolean default false,
dhinforequest boolean default false,
dhinforequestds boolean default false,
dhdenialreason varchar default('n/a'),
bcapproval boolean default false,
bcinforequestds boolean default false,
bcinforequestdh boolean default false,
bcinforequeste boolean default false,
employeeinfo varchar default('n/a'),
dsinfo varchar default('n/a'),
dhinfo varchar default('n/a')
)
### Next Steps
- Start Tomcat server in Java
- Navigate to localhost:8080/Project_1/index.html
