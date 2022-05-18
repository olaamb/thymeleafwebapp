package se.olaamberntsson.thymeleafwebapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.olaamberntsson.thymeleafwebapp.controller.EmployeeController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ThymeleafwebappApplicationTests {

    @Autowired
    private EmployeeController employeeController;

    @Test
    void contextLoads() throws Exception {
        assertThat(employeeController).isNotNull();
    }

}
