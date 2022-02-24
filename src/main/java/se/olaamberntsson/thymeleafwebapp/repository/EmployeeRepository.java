package se.olaamberntsson.thymeleafwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.olaamberntsson.thymeleafwebapp.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
