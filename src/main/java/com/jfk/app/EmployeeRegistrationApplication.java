package com.jfk.app;


import com.jfk.entity.Employee;
import com.jfk.repository.EmployeeRepository;
import com.jfk.service.EmployeeService;
import com.jfk.valueobjects.EmployeeCreateRequest;

/**
 * @author William Arustamyan
 */


public class EmployeeRegistrationApplication {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService(new EmployeeRepository());
        EmployeeCreateRequest request = new EmployeeCreateRequest();
        request.name = "Employee";
        request.age = 300;
        Employee employee = employeeService.create(request);
        System.out.println(employee);

    }
}
