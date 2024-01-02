package com.developement.spring_crud_app.repository;

import com.developement.spring_crud_app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByName(String name);
}
