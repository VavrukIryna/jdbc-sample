package com.epam.lab.dao;


import java.sql.*;

public class ReadMetaData {
    public void readMetaData(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet;
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            System.out.println("Meta Information:");
            System.out.println("User Name is: " + databaseMetaData.getUserName());
            System.out.println("URL name is: " + databaseMetaData.getURL());
            System.out.println("Information about DataBase:");
            System.out.println("Database Major Version is: " + databaseMetaData.getDatabaseMajorVersion());
            System.out.println("Database Minor Version is: " + databaseMetaData.getDatabaseMinorVersion());
            System.out.println("Database Product Name is: " + databaseMetaData.getDatabaseProductName());
            System.out.println("Database Product Version is: " + databaseMetaData.getDatabaseProductVersion());

            System.out.println("Information about Driver:");
            System.out.println("Driver name is: " + databaseMetaData.getDriverName());
            System.out.println("Driver version is: " + databaseMetaData.getDriverVersion());
            System.out.println("Driver Major Version is: " + databaseMetaData.getDriverMajorVersion());
            System.out.println("Driver Minor version is: " + databaseMetaData.getDriverMinorVersion());
            System.out.println("Information about tables:");
            System.out.println("Max columns in table: " + databaseMetaData.getMaxColumnsInTable());
            System.out.println(databaseMetaData.getMaxColumnNameLength());
            databaseMetaData.getMaxColumnsInGroupBy();
            databaseMetaData.getJDBCMajorVersion();
            databaseMetaData.getJDBCMinorVersion();
            databaseMetaData.getCatalogSeparator();
            databaseMetaData.getCatalogTerm();
            databaseMetaData.getMaxCatalogNameLength();
            databaseMetaData.getMaxColumnsInIndex();
            ResultSet rs = databaseMetaData.getTypeInfo();
            System.out.println("Primitive types:\n");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            ResultSet rset = databaseMetaData.getColumns(null, "%", "Student", "%");
            int i = 0;
            while (rset.next()) {
                i++;
                System.out.println(rset.getString(i));
            }
            rs = statement.executeQuery("select * from address");
            ResultSetMetaData rsmd = rs.getMetaData();

            int cols = rsmd.getColumnCount();
            int rownum = 1;

            // while(rsmd.next()) {
            System.out.println("Row : " + rownum++);
            i = 0;
            for (i = 0; i < cols; i++) {
                System.out.println("\tColumnLabel : '" + rsmd.getColumnLabel(i + 1) + "', " +
                                "\tDisplaySize : " + rsmd.getColumnDisplaySize(i + 1) + ", " +
                                "\tColumnType  : '" + rsmd.getColumnType(i + 1) + "', " //+
                        //   rsmd.getObject(i + 1) + ", "
                );
            }
            // }
            rs.close();
            // databaseMetaData.getAttributes("address",)
            //    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        /*    if (resultSet.next()) {
                address = addressTransformer.transform(resultSet);
            }
            resultSet.close();*/
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //  return address;
    }


}
