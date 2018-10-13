# crud-springboot-rest-pgsql
This project explains how basic CRUD operaitons are perfomed using SpringBoot Project.

CRUD operations functionality is verified using Postman.
Project is developed under intellij Idea Ultimate version,
  which can be downloaded from "https://www.jetbrains.com/idea/download/#section=windows"

This Porject is developed using jdk10.0.2.

For Database, I have used Postgres SQL,with userName = 'postgres' and password='root'
Employee table have only id, name, designation, department, and salary attributes.

Application have following dependencies,
  : Spring Boot,
  : Spring Boot Rest Services
  : JPA,
  : postgresSql,
  : Web Services
  
Steps to follow to set up the project:
  : Download Intellij Idea IDE,
  : Download Postgres SQL, set passowrd of the superuser to ='root'
  : Download Project from github.
  : Open the project in Intellij Idea.
  : You may be required to update the location of JDK.
  : Maven will fetch all the dependencies, and the project will be running.

Using postman Client as Application client.

Follwing are the APIs used for testing Crud Operations.

1. To get the data of all employees.
    Request Type -> GET, API -> $host/Employees
2. To get the data of particular Employee.
    Request Type -> GET, API -> $host/Employees/{id}
3. To create an Employee.
  Request Type -> POST, API -> $host/Employees, data -> {"json formatted Employee data"}
  
4. To update an Employee. 
  Request Type -> PUT, API-> $host/Employees/{id}, data -> {"json of updated values"}
  
5. To delete an employee.
  Request Type -> DELETE, API-> $host/Employees/{id}
  
6. To update an employe by name and Id
  Request Type -> PUT, API -> $host/Employees/name-{name}/id-{id}, data -> {"json of updated values"}

NOTE:
  WE CAN ALSO EXECUTE THE EXECUTBLE JAR AVAILABLE WITH THE PROJECT DIRECTORY. WE MAY NEED JAVA 8 FOR IT.
