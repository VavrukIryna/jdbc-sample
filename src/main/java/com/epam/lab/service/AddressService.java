package com.epam.lab.service;

import com.epam.lab.dao.AddressDao;
import com.epam.lab.model.Address;

import java.sql.Connection;
import java.util.List;

public class AddressService {

    /**
     * Prints all operation for CRUD.
     */
    public static void printAddressCrud(Connection connection) {
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
        List<Address> addresses = addressDao.readAll(connection);
        for (Address item: addresses){
            System.out.println("All addresses: "+item);
        }

        System.out.println("____________________________________________");
        System.out.println(" TRANSACTIONAL UPDATE FOR TWO ENTITIES: ");
        System.out.println("____________________________________________");
        if (addresses.size() > 2) {
            Address address1 = addresses.get(0);
            Address address2 = addresses.get(1);


            System.out.println("UPDATING: ");
            System.out.println(address1.getIdAddress());
            System.out.println(address1.getStreet());
            address1.setStreet("Вулиця_Транзакційна_1");
            System.out.println("UPDATING: ");
            System.out.println(address2.getIdAddress());
            System.out.println(address2.getStreet());
            address2.setStreet("Вулиця_Транзакційна_2");
            addressDao.transactionalUpdate(connection, address1, address2);
            System.out.println("UPDATED");
            System.out.println(address1.getIdAddress());
            System.out.println(address1.getStreet());
            System.out.println("UPDATED");
            System.out.println(address2.getIdAddress());
            System.out.println(address2.getStreet());

        }

    }
}
