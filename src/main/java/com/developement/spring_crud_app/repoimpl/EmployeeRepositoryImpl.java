package com.developement.spring_crud_app.repoimpl;

import com.developement.spring_crud_app.model.Employee;
import com.developement.spring_crud_app.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class EmployeeRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    public Employee findByName(String name){
        Query query = entityManager.createQuery("SELECT * FROM Employee WHERE name = :name");
        Employee result = (Employee)query.getParameterValue(name);
        System.out.println("result " +result);
        return result;
    };

   public   Employee deleteByName(String name){
        Employee employee = new Employee();
        return employee;
    }

}
