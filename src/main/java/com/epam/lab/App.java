package com.epam.lab;

import com.epam.lab.dao.ReadMetaData;
import com.epam.lab.service.AddressService;
import com.epam.lab.service.DepartmentService;
import com.epam.lab.service.MySqlService;
import com.epam.lab.service.StudentService;

import java.sql.Connection;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        /*
         TASK 1
         */
        MySqlService mySqlService = new MySqlService();
        Connection connection = mySqlService.getConnection();

        StudentService.printAddressCrud(connection);

        AddressService.printAddressCrud(connection);
        mySqlService.disconnect();


        /*
         TASK 2
         */
        mySqlService = new MySqlService();
        connection = mySqlService.getConnection();
        DepartmentService.printDepartmentCrud(connection);

        System.out.println("____________________________________________");
        System.out.println("READ METADATA");
        ReadMetaData metaData = new ReadMetaData();
        metaData.readMetaData(connection);
        System.out.println("____________________________________________");

        mySqlService.disconnect();
    }
}
