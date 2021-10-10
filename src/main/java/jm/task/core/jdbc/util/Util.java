package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final String URL = "jdbc:mysql://localhost:3306/userbd";
    private final String LOGIN = "root";
    private final String PASSWORD = "12345678";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
//            System.out.println("Driver susses connect");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Driver error connect");
        }
        return connection;
    }
}
