package com.epam.lab.transformer;

import java.sql.ResultSet;

public interface ResultSetTransformers<T> {
    T transform(ResultSet resultSet);
}
