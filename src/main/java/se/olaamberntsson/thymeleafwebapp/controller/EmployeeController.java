package se.olaamberntsson.thymeleafwebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import se.olaamberntsson.thymeleafwebapp.model.Employee;
import se.olaamberntsson.thymeleafwebapp.service.EmployeeService;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //display list of employees

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){

        //creates a model that binds to the forms data
        Employee employee = new Employee();

        //thymeleaf will access the empty employee object
        model.addAttribute("employee", employee);

        //thymeleaf template
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") long id, Model model){

        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value="id") long id, Model model){
        employeeService.deleteEmployeeById(id);
        return "redirect:/";

    }

}
