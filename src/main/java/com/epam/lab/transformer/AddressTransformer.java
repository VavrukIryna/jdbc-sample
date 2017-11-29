package com.epam.lab.transformer;

import com.epam.lab.model.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressTransformer implements ResultSetTransformers, PrepareStatementTransformers<Address> {
    @Override
    public Address transform(ResultSet resultSet) {
        Address address = null;
        try {
            address = new Address();
            address.setIdAddress(resultSet.getInt("id_address"));
            address.setCity(resultSet.getString("city"));
            address.setStreet(resultSet.getString("street"));
            address.setHome(resultSet.getInt("home"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public PreparedStatement transform(PreparedStatement preparedStatement, Address address) {
        try {
            preparedStatement.setInt(1, address.getIdAddress() != null ? address.getIdAddress() : 0);
            preparedStatement.setString(2, address.getCity());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setInt(4, address.getHome());
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
