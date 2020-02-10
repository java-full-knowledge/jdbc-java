package com.jfk;


import com.jfk.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author William Arustamyan
 */


public class SimpleJDBCApplication {

    private static final String userName = "postgres";
    private static final String password = "123";
    private static final String dbUrl = "jdbc:postgresql://localhost:5432/postgres";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123");

        String url = "jdbc:postgresql://localhost:5432/postgres";
        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection(url, props);
        Statement statement = connection.createStatement();
        statement.execute("select * from t_employee");
        ResultSet records = statement.getResultSet();

        List<Employee> employees = new ArrayList<>();
        while (records.next()) {
            String employeeName = records.getString("name");
            int employeeAge = records.getInt("age");
            employees.add(new Employee(employeeName, employeeAge));
        }

        System.out.println("Employees : " + employees);

    }
}
