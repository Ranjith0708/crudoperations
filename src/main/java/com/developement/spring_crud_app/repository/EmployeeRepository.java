package com.developement.spring_crud_app.repository;

import com.developement.spring_crud_app.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM Employee WHERE name = :name", nativeQuery = true)
    Employee findByName(@Param("name")String name);

    Employee deleteByName(String name);
}
