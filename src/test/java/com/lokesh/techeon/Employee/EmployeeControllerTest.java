package com.lokesh.techeon.Employee;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class, secure = false)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EmployeeService employeeService;

    Employee employee = new Employee(123,"TestEmployee","TestDesignation","TestDeaprtment",1200);
    @Test
    public void employeeInsertionTest() throws Exception {

        Mockito.when(employeeService.getEmployee(Mockito.anyInt())).thenReturn(employee);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/Employee/123").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());

        String expected = "{id:123, name:TestEmployee, designation:TestDesignation, department:TestDepartment, Salary:12000}";

        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),true);
    }

}