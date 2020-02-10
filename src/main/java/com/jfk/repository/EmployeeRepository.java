package com.jfk.repository;


import com.jfk.entity.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author William Arustamyan
 */


public class EmployeeRepository implements Repository<Employee, Integer> {

    private Connection connection;
    private String url = "jdbc:postgresql://localhost:5432/postgres";


    public EmployeeRepository() {

        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123");
        String url = "jdbc:postgresql://localhost:5432/postgres";
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(this.url, props);
        } catch (Exception e) {
            System.out.println("Unable to connect with database...");
        }
    }


    @Override
    public Integer save(Employee employee) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "insert into t_employee values(default,?,?)"
            );
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setInt(2, employee.getAge());
            int insertCount = preparedStatement.executeUpdate();
            System.out.println("Updated insertCount count : " + insertCount);
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 10;
    }
}
