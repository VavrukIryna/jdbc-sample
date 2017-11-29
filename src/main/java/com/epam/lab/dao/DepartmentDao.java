package com.epam.lab.dao;

//import com.epam.lab.model.Address;
//import com.epam.lab.transformer.AddressTransformer;

import com.epam.lab.model.Department;
import com.epam.lab.transformer.DepartmentTransformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao implements CRUD<Department> {
    private DepartmentTransformer departmentTransformer;

    public DepartmentDao() {
        this.departmentTransformer = new DepartmentTransformer();
    }

    @Override
    public Department readOne(Connection connection, Integer id) {
        Department department = null;

        try (Statement statement = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM department WHERE id_dept='" + String.valueOf(id) + "';";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                department = departmentTransformer.transform(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }

    @Override
    public List<Department> readAll(Connection connection) {
        List<Department> departmentList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM department";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                departmentList.add(departmentTransformer.transform(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentList;
    }

    @Override
    public Department create(Connection connection, Department department) {
        String sqlQuery = "INSERT INTO department (id_dept, dept_name, institute_name) VALUES(?, ?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            PreparedStatement preparedStatementPopulated = departmentTransformer.transform(preparedStatement, department);
            int rowsUpdated = preparedStatementPopulated.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("Creating failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatementPopulated.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    department.setIdDept(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating failed, no ID obtained.");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }


    @Override
    public Department update(Connection connection, Department department) {
        String sqlQuery = "UPDATE department SET id_dept = ?, dept_name = ?, institute_name= ? WHERE id_dept = '"
                + String.valueOf(department.getIdDept()) + "'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            PreparedStatement preparedStatementPopulated = departmentTransformer.transform(preparedStatement,department);
            preparedStatementPopulated.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return department;
    }

    @Override
    public void delete(Connection connection, Integer id) {
        String deleteSQL = "DELETE FROM departments WHERE id_dept = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            PreparedStatement preparedStatementPopulated = departmentTransformer.transformID(preparedStatement, id);
            preparedStatementPopulated.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Boolean transactionalUpdate(Connection connection, Department entity1, Department entity2) {
        return null;
    }

}
