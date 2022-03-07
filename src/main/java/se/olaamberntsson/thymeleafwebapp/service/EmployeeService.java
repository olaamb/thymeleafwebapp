package se.olaamberntsson.thymeleafwebapp.service;

import se.olaamberntsson.thymeleafwebapp.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

}
