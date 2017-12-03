package com.epam.lab.service;

import com.epam.lab.dao.StudentDao;
import com.epam.lab.model.Student;

import java.sql.Connection;
import java.util.List;

public class StudentService {

    /**
     * Prints all operation for CRUD.
     */
    public static void printAddressCrud(Connection connection) {
        StudentDao studentDao = new StudentDao();

        System.out.println("__________________");
        System.out.println("READ ONE:");
        Student student = studentDao.readOne(connection, 1);
        System.out.println(student);
        System.out.println("__________________");
        System.out.println("READ ALL:");
        List<Student> students = studentDao.readAll(connection);
        for (Student st : students) {
            System.out.println(st);
        }

    }
}
