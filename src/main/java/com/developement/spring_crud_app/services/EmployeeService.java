package com.developement.spring_crud_app.services;

import com.developement.spring_crud_app.model.Employee;
import com.developement.spring_crud_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> addAllEmployees(List<Employee> employees){
        return employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeById(int id){
        return  employeeRepository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name){
        return  employeeRepository.findByName(name);
    }

    public boolean deleteEmployee(int id){
        Employee deleteEmp = getEmployeeById(id);
        if(deleteEmp == null){
            return false;
        }else {
            employeeRepository.deleteById(id);
            return true;
        }
    }

    public Employee updateEmployee(Employee employee){
        Employee employeeObject = getEmployeeById(employee.getId());
        if(employeeObject == null){
            addEmployee(employee);
        }else{
            deleteEmployee(employee.getId());
            addEmployee(employee);
        }
        return employee;
    }


}
