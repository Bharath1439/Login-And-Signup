# Login-And-Signup
# Spring Boot Login and Signup API

This is a sample project that demonstrates the implementation of login and signup REST API using Spring Boot, Spring Security. The project uses an Mysql database for data storing.

## Prerequisites
- Java Development Kit (JDK) 8 or higher installed
- MySQL installed (for database setup)
- IntelliJ IDEA (or any preferred IDE) installed

## Installation and Setup

1. Get SpringBoot starter project with dependencies of Springweb,lombok,jpa hibernate,spring security,mysql.
2. Open the project in IntelliJ IDEA:
3. Set up MySQL database:

- Install MySQL (if not already installed)
- Create a new database named `AnyName` (or any preferred name)
- Update the database connection details in `application.properties` file located in `src/main/resources`:
4. Build and run the project:

- Open the project in IntelliJ IDEA
- Build the project using Maven (either from the IDE or using the command line)
- Run the project using the main method in the `Application.java` class

5. API Endpoints:

- The following API endpoints are available:

  - **POST**  /user/Registration - Create a new user account
  - **POST**  /user/login - Authenticate a user 
  - **GET**   /user/getAlluser-Get All users from database

6. Testing the APIs:

- I used tools like Postman to test the APIs.

7. Additional Configuration:

- The default configuration includes basic security measures, such as password hashing.
- You can modify the security configurations as per your project requirements in the `Config.java` class.

