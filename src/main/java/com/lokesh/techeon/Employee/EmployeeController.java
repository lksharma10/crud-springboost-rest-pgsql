package com.lokesh.techeon.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/Employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/Employees/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/Employees")
    public void addEmployee(@RequestBody Employee Employee) {
        employeeService.addEmployee(Employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Employees/{id}")
    public void updateEmployee(@RequestBody Employee Employee, @PathVariable String id) {
        employeeService.updateEmployee(id, Employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}
