**Library Management System**:

**Project Overview**:

The Library Management System is a Java-based web application developed using Servlets, JDBC, and Object-Oriented Programming (OOP) concepts.
This system helps manage library operations such as adding books, viewing books, managing authors, and handling database connectivity efficiently.

The project follows a layered architecture using Bean, DAO, Service, Servlet, and Utility layers, ensuring clean separation of concerns and easy maintenance.

**Objectives**:

The system is designed to:

Add new books with author details

View available books in the library

Maintain author and book information

**Technologies Used**:

Programming Language: Java

Web Technologies: HTML, Servlets

Database: Oracle Database

Connectivity: JDBC

IDE: Eclipse IDE

Server: Apache Tomcat

**Project Structure**:

LibraryManagement
│
├── src/main/java
│   └── com.wipro.book
│       ├── bean
│       │   ├── AuthorBean.java
│       │   └── BookBean.java
│       │
│       ├── dao
│       │   ├── AuthorDAO.java
│       │   └── BookDAO.java
│       │
│       ├── service
│       │   └── Administrator.java
│       │
│       ├── servlets
│       │   ├── MainServlet.java
│       │   └── ViewServlet.java
│       │
│       └── util
│           └── DBUtil.java
│
├── src/main/webapp
│   ├── META-INF
│   ├── WEB-INF
│   ├── AddBook.html
│   ├── ViewBook.html
│   ├── Menu.html
│   ├── Invalid.html
│   └── Failure.html
│
└── build

**Features**:

Add new books with author information

View all books stored in the database

Input validation for book details


**Database Details**:

**Tables Used**:

BOOK_TABLE – Stores book details

AUTHOR_TABLE – Stores author details
<img width="773" height="559" alt="image" src="https://github.com/user-attachments/assets/7402b5c7-7628-4991-9eff-a068a9df7798" />


**Output**:

<img width="787" height="343" alt="image" src="https://github.com/user-attachments/assets/03399222-1595-4aec-866c-412eaceecb9b" />
<img width="772" height="483" alt="Screenshot 2026-02-11 123227" src="https://github.com/user-attachments/assets/4e01caf8-5672-4ef8-be38-712b781d5824" />
<img width="772" height="337" alt="Screenshot 2026-02-11 123241" src="https://github.com/user-attachments/assets/bad009d1-ca5c-4d7a-ae8e-31337d217b33" />
<img width="779" height="366" alt="Screenshot 2026-02-11 123248" src="https://github.com/user-attachments/assets/d5c5c18e-f4cd-4332-a2b6-db3334485e56" />




