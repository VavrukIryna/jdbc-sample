package com.epam.lab.service;

import com.epam.lab.dao.DepartmentDao;
import com.epam.lab.dao.StudentDao;
import com.epam.lab.model.Department;
import com.epam.lab.model.Student;

import java.sql.Connection;
import java.util.List;

public class DepartmentService {

    /**
     * Prints all operation for CRUD.
     */
    public static void printDepartmentCrud(Connection connection) {
        DepartmentDao departmentDao = new DepartmentDao();
        StudentDao studentDao = new StudentDao();


        Department department = departmentDao.readOne(connection, 1);

        System.out.println(" REMOVE: ");
        System.out.println("____________________________________________");
        Department newDepartment = departmentDao.readOne(connection, 2);
        System.out.println("Preparing : " + department.getDeptName() + " students to transfer to: " + newDepartment.getDeptName());
        List<Student> students = studentDao.readAll(connection, department);
        for (Student student : students) {
            student.setDepartment(newDepartment);
            studentDao.update(connection, student);
        }
        System.out.println("____________________________________________");
        System.out.println("Removing : " + department.getIdDept() + " " + department.getDeptName());
        departmentDao.delete(connection, 1);
        System.out.println("Record is deleted from Department table!");


    }
}
