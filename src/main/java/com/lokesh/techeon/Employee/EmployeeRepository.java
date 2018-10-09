package com.lokesh.techeon.Employee;

/*
EmployeeRepository is a CRUDRepository which will store Employee records with Integer Id.
 */
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
