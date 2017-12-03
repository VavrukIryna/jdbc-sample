package com.epam.lab.transformer;

import com.epam.lab.model.Address;
import com.epam.lab.model.Department;
import com.epam.lab.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentTransformer implements ResultSetTransformers, PrepareStatementTransformers<Student> {
    @Override
    public Student transform(ResultSet resultSet) {
        Student student = new Student();

        try {
            student = new Student();
            student.setIdStudent(resultSet.getInt("id_student"));
            student.setName(resultSet.getString("name"));
            student.setSurname(resultSet.getString("surname"));
            student.setBookNumber(resultSet.getInt("book_number"));
            student.setTelephone(resultSet.getInt("telephone"));
            student.setSex(resultSet.getString("sex"));
            student.setBirthdayData(resultSet.getDate("birthday_data"));
            student.setSubjectId(resultSet.getInt("subject_id"));
            student.setSpecialtyId(resultSet.getInt("specialty_id"));
            student.setParentsId(resultSet.getInt("id_parents"));
            student.setExamId(resultSet.getInt("id_exam"));
            student.setGroupName(resultSet.getString("group_name"));
            student.setLearningForm(resultSet.getString("learning_form"));

            Address address = new Address();
            address.setIdAddress(resultSet.getInt("id_address"));
            address.setStreet(resultSet.getString("street"));
            address.setHome(resultSet.getInt("home"));
            address.setCity(resultSet.getString("city"));
            student.setAddress(address);

            Department department = new Department();
            department.setIdDept(resultSet.getInt("id_dept"));
            department.setInstituteName(resultSet.getString("institute_name"));
            department.setDeptName(resultSet.getString("dept_name"));
            student.setDepartment(department);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public PreparedStatement transform(PreparedStatement preparedStatement, Student student) {
        try {
            preparedStatement.setInt(1, student.getIdStudent() != null ? student.getIdStudent() : 0);
            preparedStatement.setString(2,student.getName());
            preparedStatement.setString(3,student.getSurname());
            preparedStatement.setInt(4,student.getBookNumber());
            preparedStatement.setInt(5,student.getTelephone());
            preparedStatement.setString(6,student.getSex());
            preparedStatement.setDate(7,student.getBirthdayData());
            preparedStatement.setInt(8, student.getAddress().getIdAddress()); //address
            preparedStatement.setInt(9,student.getSubjectId());
            preparedStatement.setInt(10,student.getSpecialtyId());
            preparedStatement.setInt(11,student.getParentsId());
            preparedStatement.setInt(12,student.getExamId());
            preparedStatement.setString(13,student.getGroupName());
            preparedStatement.setString(14,student.getLearningForm());
            preparedStatement.setInt(15, student.getDepartment().getIdDept()); // dept
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
        Address address = (Address) entity;
        try {
            preparedStatement.setString(1, address.getCity());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setInt(3, address.getHome());
            preparedStatement.setInt(4, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }
}
