package se.olaamberntsson.thymeleafwebapp.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import se.olaamberntsson.thymeleafwebapp.model.Employee;
import se.olaamberntsson.thymeleafwebapp.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Before
    public void setup(){
        Employee employee1 = new Employee(1, "Frodo", "Baggins", "frodo@hotmail.com");
        Employee employee2 = new Employee(2, "Bilbo", "Baggins", "bilbo@gmail.com");

        List <Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(employee1);
        employeeList.add(employee2);

        when(employeeService.getAllEmployees()).thenReturn(employeeList);
    }

    @Test
    public void shouldReturnIndexView() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void shouldReturnNewEmployeeView() throws Exception{
        mockMvc.perform(get("/showNewEmployeeForm"))
                .andExpect(status().isOk())
                .andExpect(view().name("new_employee"));
    }

    @Test
    public void shouldReturnNewEmployeeViewWithPostRequest() throws Exception{
        mockMvc.perform(post("/saveEmployee"))
                .andExpect(status().isOk())
                .andExpect(view().name("new_employee"));
    }

    @Test
    public void shouldReturnNewEmployeeViewAndContainAnTwoEmployees() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("listEmployees"))
                .andExpect(model().size(1));
    }
}