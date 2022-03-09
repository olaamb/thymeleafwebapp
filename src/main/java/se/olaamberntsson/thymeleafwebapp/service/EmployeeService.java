package se.olaamberntsson.thymeleafwebapp.service;

import se.olaamberntsson.thymeleafwebapp.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);
//    Employee saveEmployee(Employee employee);

    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);
//    Employee deleteEmployeeById(long id);

}
