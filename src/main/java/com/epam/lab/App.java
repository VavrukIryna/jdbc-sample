package com.epam.lab;

import com.epam.lab.dao.ReadMetaData;
import com.epam.lab.service.AddressService;
import com.epam.lab.service.DepartmentService;
import com.epam.lab.service.MySqlService;

import java.sql.Connection;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        MySqlService mySqlService = new MySqlService();
        Connection connection = mySqlService.getConnection();


        ReadMetaData metaData = new ReadMetaData();

        AddressService.printAddressCrud(connection);

//        DepartmentService.printDepartmentCrud(connection);

        System.out.println("____________________________________________");
        System.out.println("READ METADATA");
        metaData.readMetaData(connection);
        System.out.println("____________________________________________");

        mySqlService.disconnect();
    }
}
