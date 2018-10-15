package com.lokesh.techeon.Employee;

/*
EmployeeController is a Rest Controller which will handle all the service apis.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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
    public Employee addEmployee(@RequestBody Employee Employee) {
        System.out.println("ADDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD\n");
        return employeeService.addEmployee(Employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/Employees/{id}")
    public void updateEmployee(@RequestBody Employee Employee, @PathVariable("id") String id) {
        employeeService.updateEmployee(id, Employee);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/Employees/name-{name}/id-{id}")
    public Employee getEmployeeByName(@PathVariable("name") String name, @PathVariable("id") Integer id) {
        return employeeService.getEmployeeByName(name, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/Employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }


    /* Request Body for Update the Employee with name and Id*/
    @RequestMapping(method = RequestMethod.PUT, value = "/Employees/name-{name}/id-{id}")
    public void updateEmployeeByNameAndId(@RequestBody Employee emp, @PathVariable String name, @PathVariable Integer id) {
        employeeService.updateEmployeeByNameAndId(name, id, emp);
    }
}
