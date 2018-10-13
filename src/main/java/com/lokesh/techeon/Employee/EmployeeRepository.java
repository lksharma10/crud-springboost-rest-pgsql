package com.lokesh.techeon.Employee;

/*
EmployeeRepository is a CRUDRepository which will store Employee records with Integer Id.
 */

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Query("SELECT emp FROM Employee emp WHERE emp.id = :id AND emp.name = :name")
    Optional<Employee> findEmployeeByNameAAndAndId(@Param("name") String name, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("update Employee SET designation = :designation, department = :department, salary = :salary where name=:name AND id=:id")
    void saveEmployee(@Param("designation") String designation, @Param("department") String department ,@Param("salary") double salary , @Param("name") String name, @Param("id") Integer id);
}
