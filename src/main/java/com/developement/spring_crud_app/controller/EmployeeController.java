package com.developement.spring_crud_app.controller;

import com.developement.spring_crud_app.model.Employee;
import com.developement.spring_crud_app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees){
        return employeeService.addAllEmployees(employees);
    }

    @GetMapping("/getEmployeeById/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getEmployeeByName/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }
    @GetMapping("getIds/{name}")
    public List<Integer> getIds(@PathVariable String name){
        return employeeService.getEmpIds(name);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public boolean deleteEmployeeById(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

    @DeleteMapping("/deleteEmpByName/{name}")
    public String deleteEmpByName(@PathVariable String name){
        return employeeService.deleteEmployeeByName(name);
    }
    @PutMapping("/updateEmployee")
    public String updateEmp(@RequestBody Employee employee){
        return  employeeService.updateEmployee(employee);
    }

}
