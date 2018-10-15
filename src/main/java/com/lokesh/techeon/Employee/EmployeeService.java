package com.lokesh.techeon.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Employee getEmployee(Integer id) {
        //return Employees.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        Employee emp = employeeRepository.findById(id).get();
        return emp;
    }

    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);

        Employee retEmp= employeeRepository.findById(employee.getId()).get();
        return retEmp;
    }

    void updateEmployee(String id, Employee Employee) {
        employeeRepository.save(Employee);
    }

    void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeByName(String name, Integer id) {
        Employee emp = employeeRepository.findEmployeeByNameAAndAndId(name, id).get();
        return emp;
    }

    /*
    Function to Update the Employee by Name and Id
    XXX: Id is used to uniquely identify the Employee
     */
    public void updateEmployeeByNameAndId(String name, Integer id, Employee emp) {
        employeeRepository.saveEmployee(emp.getDesignation(),emp.getDepartment(),emp.getSalary(), name, id);
    }
}
