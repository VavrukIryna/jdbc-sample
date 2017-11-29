package com.epam.lab.dao;

import com.epam.lab.model.Address;
import com.epam.lab.transformer.AddressTransformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements CRUD<Address> {
    private AddressTransformer addressTransformer;

    public AddressDao() {
        this.addressTransformer = new AddressTransformer();
    }

    @Override
    public Address readOne(Connection connection, Integer id) {
        Address address = null;

        try (Statement statement = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM address WHERE id_address='" + String.valueOf(id) + "';";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            if (resultSet.next()) {
                address = addressTransformer.transform(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public List<Address> readAll(Connection connection) {
        List<Address> addressList = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            String sqlQuery = "SELECT * FROM address";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                addressList.add(addressTransformer.transform(resultSet));
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addressList;
    }

    @Override
    public Address create(Connection connection, Address address) {
        String sqlQuery = "INSERT INTO Address (id_address, city, street, home) VALUES(?, ?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            PreparedStatement preparedStatementPopulated = addressTransformer.transform(preparedStatement, address);
            int rowsUpdated = preparedStatementPopulated.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("Creating failed, no rows affected.");
            }

            try (ResultSet generatedKeys = preparedStatementPopulated.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    address.setIdAddress(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating failed, no ID obtained.");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }


    @Override
    public Address update(Connection connection, Address address) {
        String sqlQuery = "UPDATE Address SET id_address = ?, city = ?, street= ?, home = ? WHERE id_address = '"
                + String.valueOf(address.getIdAddress()) + "'";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            PreparedStatement preparedStatementPopulated = addressTransformer.transform(preparedStatement, address);
            preparedStatementPopulated.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }

    @Override
    public void delete(Connection connection, Integer id) {
        String deleteSQL = "DELETE FROM Address WHERE id_address = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            PreparedStatement preparedStatementPopulated = addressTransformer.transformID(preparedStatement, id);
            preparedStatementPopulated.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean transactionalUpdate(Connection connection, Address entity1, Address entity2) {
        Boolean isCommited = false;
        String sqlQueryFirst = "UPDATE Address SET id_address = ?, city = ?, street= ?, home = ? WHERE id_address = '"
                + String.valueOf(entity1.getIdAddress()) + "'";

        String sqlQuerySecond = "UPDATE Address SET id_address = ?, city = ?, street= ?, home = ? WHERE id_address = '"
                + String.valueOf(entity2.getIdAddress()) + "'";

        try {
            connection.setAutoCommit(false);

            // FIRST
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQueryFirst)) {
                PreparedStatement preparedStatementPopulated = addressTransformer.transform(preparedStatement, entity1);
                preparedStatementPopulated.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

            // SECOND
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuerySecond)) {
                PreparedStatement preparedStatementPopulated = addressTransformer.transform(preparedStatement, entity2);
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
    }
}
