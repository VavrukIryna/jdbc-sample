package com.epam.lab.service;

import com.epam.lab.dao.AddressDao;
import com.epam.lab.model.Address;

import java.sql.Connection;

public class DepartmentService {

    /**
     * Prints all operation for CRUD.
     */
    public static void printDepartmentCrud(Connection connection) {
        AddressDao addressDao = new AddressDao();
        System.out.println("____________________________________________");
        System.out.println(" CREATE: ");
        System.out.println("____________________________________________");
        Address newAddress = new Address();
        newAddress.setStreet("Chornovola");
        newAddress.setCity("Lviv");
        newAddress.setHome(42);
        Address insertedAddress = addressDao.create(connection, newAddress);
        System.out.println(insertedAddress);
        System.out.println("____________________________________________");
        System.out.println(" READ AND UPDATE: ");
        System.out.println("____________________________________________");
        Integer idOfAddressToUpdate = insertedAddress.getIdAddress();

        System.out.println("Searching for id: " + idOfAddressToUpdate);
        Address updateAddress = addressDao.readOne(connection, idOfAddressToUpdate);
        System.out.println("Found:");
        System.out.println(updateAddress);

        System.out.println("Updating : [" + idOfAddressToUpdate + "] " +  insertedAddress.getStreet());
        updateAddress.setStreet("Derybasivska");
        updateAddress.setCity("Odessa");
        updateAddress.setHome(42);
        Address updatedAddress = addressDao.update(connection, updateAddress);
        System.out.println(updatedAddress);
        System.out.println("Record is updated to Address table!");

        System.out.println("____________________________________________");
        System.out.println(" REMOVE: ");
        System.out.println("____________________________________________");
        System.out.println("Removing : " + insertedAddress.getIdAddress() + " " +  updatedAddress.getStreet());
        addressDao.delete(connection,idOfAddressToUpdate);
        System.out.println("Record is deleted from Address table!");


        System.out.println("____________________________________________");
        System.out.println(" READ ALL: ");
        System.out.println("____________________________________________");
        for (Address item: addressDao.readAll(connection)){
            System.out.println("All addresses: "+item);
        }
    }
}
