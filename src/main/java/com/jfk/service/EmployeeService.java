package com.jfk.service;


import com.jfk.entity.Employee;
import com.jfk.repository.Repository;
import com.jfk.valueobjects.EmployeeCreateRequest;

/**
 * @author William Arustamyan
 */


public class EmployeeService implements CrudService<Employee, EmployeeCreateRequest> {

    private Repository<Employee, Integer> repository;


    public EmployeeService(Repository<Employee, Integer> employeeRepo) {
        this.repository = employeeRepo;
    }

    @Override
    public Employee create(EmployeeCreateRequest request) {
        Employee employee = new Employee(request.name, request.age);
        Integer savedInstanceId = this.repository.save(employee);
        System.out.println("Employee successfully saved with id : " + savedInstanceId);
        return employee;
    }
}
