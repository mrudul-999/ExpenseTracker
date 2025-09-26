package com.mrudul.exception;

import java.sql.SQLException;

public class DatabaseOperationException extends Exception{
    public DatabaseOperationException()
    {
        super("OwO, database operation exception mrudul saan :((( ");
    }

    public DatabaseOperationException(String message)
    {
        super(message);
    }

    public DatabaseOperationException(String s, SQLException ex) {
    }
}
