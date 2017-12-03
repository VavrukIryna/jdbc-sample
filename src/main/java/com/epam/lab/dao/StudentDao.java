package com.epam.lab.dao;

//import com.epam.lab.model.Address;
import com.epam.lab.model.Department;
import com.epam.lab.model.Student;
//import com.epam.lab.transformer.AddressTransformer;
import com.epam.lab.transformer.StudentTransformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements CRUD<Student> {
    private StudentTransformer studentTransformer;

    public StudentDao() {
        this.studentTransformer = new StudentTransformer();
    }

    @Override
    public Student readOne(Connection connection, Integer id) {
        Student student = null;

        try (Statement statement = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM student JOIN department ON student.dept_id = department.id_dept JOIN address ON student.address_id=address.id_address WHERE id_student='" + String.valueOf(id) + "';";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                student = studentTransformer.transform(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public List<Student> readAll(Connection connection) {
        List<Student> studentList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM student JOIN department ON student.dept_id = department.id_dept JOIN address ON student.address_id=address.id_address;";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                studentList.add(studentTransformer.transform(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public List<Student> readAll(Connection connection, Department department) {
        List<Student> studentList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM student JOIN department ON student.dept_id = department.id_dept JOIN address ON student.address_id=address.id_address WHERE dept_id='" +
                    department.getIdDept() + "';";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                studentList.add(studentTransformer.transform(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student create(Connection connection, Student student) {
//        String sqlQuery = "INSERT INTO Student (id_student, name, surname, book_number, telephone, sex, birthday_data, address_id, subject_id, specialty_id, id_parents, id_exam, group, learning_form,dept_id) VALUES(?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
//            PreparedStatement preparedStatementPopulated = studentTransformer.transform(preparedStatement, student);
//            int rowsUpdated = preparedStatementPopulated.executeUpdate();
//
//            if (rowsUpdated == 0) {
//                throw new SQLException("Creating failed, no rows affected.");
//            }
//
//            try (ResultSet generatedKeys = preparedStatementPopulated.getGeneratedKeys()) {
//                if (generatedKeys.next()) {
//                    student.setIdStudent(generatedKeys.getInt(1));
//                } else {
//                    throw new SQLException("Creating failed, no ID obtained.");
//                }
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        return student;
    }


    @Override
    public Student update(Connection connection, Student student) {

     String sqlQuery = "UPDATE Student SET id_student = ?, name = ?, surname= ?, book_number = ?,telephone = ?, sex = ?, birthday_data= ?, address_id = ?,  subject_id = ?, specialty_id= ?, id_parents = ?,id_exam = ?, group_name= ?, learning_form= ?, dept_id = ? WHERE id_student = '" +
                String.valueOf(student.getIdStudent()) + "';";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            PreparedStatement preparedStatementPopulated = studentTransformer.transform(preparedStatement, student);
            preparedStatementPopulated.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    @Override
    public void delete(Connection connection, Integer id) {

        String deleteSQL = "DELETE FROM Student WHERE id_student = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            PreparedStatement preparedStatementPopulated = studentTransformer.transformID(preparedStatement, id);
            preparedStatementPopulated.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean transactionalUpdate(Connection connection, Student entity1, Student entity2) {
        return null;
    }

   /* @Override
    public Boolean transactionalUpdate(Connection connection, Student entity1, Student entity2) {
        Boolean isCommited = false;
      //  !!!! перевырити кверы
        String sqlQueryFirst = "UPDATE Student SET id_student = ?, city = ?, street= ?, home = ? WHERE id_address = '"
                + String.valueOf(entity1.getIdStudent()) + "'";

        String sqlQuerySecond = "UPDATE Student SET id_student = ?, city = ?, street= ?, home = ? WHERE id_address = '"
                + String.valueOf(entity2.getIdStudent()) + "'";

        try {
            connection.setAutoCommit(false);

            // FIRST
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryFirst)) {
                PreparedStatement preparedStatementPopulated = studentTransformer.transform(preparedStatement, entity1);
                preparedStatementPopulated.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            // SECOND
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuerySecond)) {
                PreparedStatement preparedStatementPopulated = studentTransformer.transform(preparedStatement, entity2);
                preparedStatementPopulated.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            connection.commit();
            isCommited = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return isCommited;
    }*/
}
