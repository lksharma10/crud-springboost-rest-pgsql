package com.lokesh.techeon.Employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EmployeeService employeeService;

    @Test
    public void employeeInsertionTest() throws Exception {
        {
            Employee employee = new Employee(17, "TestEmployee", "TestDesignation", "TestDeaprtment", 12000);

            when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(employee);

            String addJson= "{\"id\":17, \"name\":\"TestEmployee\", \"designation\":\"TestDesignation\", \"department\":\"TestDepartment\", \"Salary\":12000}";

            MvcResult result = mockMvc.perform(post("/Employees")
                    .header("Content-Type", MediaType.APPLICATION_JSON)
                    .content(addJson))
                    .andExpect(status().isOk())
                    .andReturn();

            MockHttpServletResponse response = result.getResponse();

            System.out.print("This is POST REQUEST CHECK\n");
            System.out.println(response.getContentAsString()+"\n");
        }
    }

    @Test
    public void getEmployeeTest() throws  Exception{
        //when(employeeService.getAllEmployees()).thenReturn("All Employees");
        MvcResult result = mockMvc.perform(get("/Employees")).andExpect(status().isOk()).andReturn();

        MockHttpServletResponse response = result.getResponse();

        System.out.print("This is Get REQUEST CHECK\n");
        System.out.print(response.getContentAsString() +"\n");
    }
}