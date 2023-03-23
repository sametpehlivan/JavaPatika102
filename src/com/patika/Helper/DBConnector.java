package com.patika.Helper;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector
{
    private static Connection connection = null;
    public static Connection getInstance()
    {
        if (connection == null)
        {
            try {
                connection = DriverManager.getConnection(Config.DB_URL,Config.DB_USER,Config.DB_PASSWORD);
            }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }

        }
        return connection;
    }


   private DBConnector(){}

}
