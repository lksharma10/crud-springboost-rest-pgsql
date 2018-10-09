# crud-springboot-rest-pgsql
This project explains how basic CRUD operaitons are perfomed using SpringBoot Project.

CRUD operations functionality is verified using Postman.
Project is developed under intellij Idea Ultimate version,
  which can be downloaded from "https://www.jetbrains.com/idea/download/#section=windows"

For Database, I have used Postgres SQL,
Employee table have only id, name, designation, department, and salary attributes.

Application have following dependencies,
  : Spring Boot,
  : Spring Boot Rest Services
  : JPA,
  : postgresSql,
  : Web Services

Using postman Client as Application client.

Follwing arethe APIs used for the CrudOperations.

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
