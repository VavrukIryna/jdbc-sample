package com.epam.lab.transformer;

import com.epam.lab.model.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentTransformer implements ResultSetTransformers, PrepareStatementTransformers<Department> {
    @Override
    public Department transform(ResultSet resultSet) {
        Department department = null;
        try {
            department = new Department();
            department.setIdDept(resultSet.getInt("id_dept"));
            department.setDeptName(resultSet.getString("dept_name"));
            department.setInstituteName(resultSet.getString("institute_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

    @Override
    public PreparedStatement transform(PreparedStatement preparedStatement, Department department) {
        try {
            preparedStatement.setInt(1, department.getIdDept() != null ? department.getIdDept() : 0);
            preparedStatement.setString(2, department.getDeptName());
            preparedStatement.setString(3, department.getInstituteName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }


    public PreparedStatement transformID(PreparedStatement preparedStatement, Integer id) {
        try {
        preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }


    public PreparedStatement transformUpdate(PreparedStatement preparedStatement, Object entity, Integer id) {
        Department department = (Department) entity;
        try {
            preparedStatement.setInt(1, department.getIdDept());
            preparedStatement.setString(2, department.getDeptName());
            preparedStatement.setString(3, department.getInstituteName());
            preparedStatement.setInt(4, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }
}
