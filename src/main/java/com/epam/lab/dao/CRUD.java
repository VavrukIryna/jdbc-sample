package com.epam.lab.dao;

import java.sql.Connection;
import java.util.List;

public interface CRUD<T> {
    T readOne(Connection connection, Integer id);

    List<T> readAll(Connection connection);

    T create(Connection connection, T entity);

    T update(Connection connection, T entity);

    void delete(Connection connection, Integer id);

    Boolean transactionalUpdate(Connection connection, T entity1, T entity2);
}
