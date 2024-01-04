package com.developement.spring_crud_app.services;

import com.developement.spring_crud_app.model.Employee;
import com.developement.spring_crud_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public String addEmployee(Employee employee){
         employeeRepository.save(employee);
        return "Employee added Successfully";
    }

    public List<Employee> addAllEmployees(List<Employee> employees){

        return employeeRepository.saveAll(employees);
    }

    public Employee getEmployeeById(int id){
        return  employeeRepository.findById(id).orElse(null);
    }

    List<Employee> employeeLst = new ArrayList<>();
    List<Employee> empLsREs = new ArrayList<>();
    public List<Employee> getEmployeeByName(String name){
        employeeLst = employeeRepository.findAll();
        System.out.println("emp ls "+employeeLst);
        for(int i=0;i<employeeLst.size();i++){
            Employee empObj = employeeLst.get(i);
            if(empObj.getName().equals(name)){
                empLsREs.add(empObj);
            }
        }
        return empLsREs;
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

    public String deleteEmployeeByName(String name){
        List<Employee> deleteEmp = getEmployeeByName(name);
        System.out.println("deleteEmp "+deleteEmp);
        if(deleteEmp.size() == 0){
            return "Employee name doesn't exists";
        }else {
            if(deleteEmp.size()>1){
                deleteEmp.clear();
                return "Can't perform delete more than one name exists delete by using id";
            }else{
                employeeRepository.deleteById(deleteEmp.get(0).getId());
                deleteEmp.clear();
                return "Employee Deleted Successfully";
            }
        }
    }
    public List<Integer> getEmpIds(String name){
        List<Integer> empId = new ArrayList<>();
        List<Employee> empLs = employeeRepository.findAll();
        for(int i=0;i<empLs.size();i++){
            if(empLs.get(i).getName().equals(name)){
                empId.add(empLs.get(i).getId());
            }
        }
        return empId;
    }
    public String updateEmployee(Employee employee){
        List<Employee> employeeObject = getEmployeeByName(employee.getName());
        if(employeeObject.size() == 0){
            addEmployee(employee);
            return "Employee details not exists so it got added successfully";
        }else{
            deleteEmployee(employee.getId());
            addEmployee(employee);
            return "Employee details updated Successfully";
        }
    }


}
