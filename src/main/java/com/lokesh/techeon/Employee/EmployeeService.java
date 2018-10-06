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

    public Employee getEmployee(int id) {
        //return Employees.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        Employee emp = employeeRepository.findById(id).get();
        return emp;
    }

    public void addEmployee(Employee Employee) {
        employeeRepository.save(Employee);
    }

    void updateEmployee(String id, Employee Employee) {
        employeeRepository.save(Employee);
    }

    void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
