package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection connection = new Util().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS userbd.users ( " +
                        "id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, " +
                        "name VARCHAR(30), " +
                        "lastname VARCHAR(30), " +
                        "age TINYINT)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = new Util().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("DROP TABLE IF EXISTS userbd.users");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = new Util().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userbd.users (name , lastname, age) VALUES(?,?,?)")) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, lastName);
                preparedStatement.setByte(3, age);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = new Util().getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM userbd.users WHERE id=?")) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT name, lastname, age from userbd.users";
        List<User> list = new ArrayList<>();
        try (Connection connection = new Util().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String lastname = resultSet.getString("lastname");
                        byte age = resultSet.getByte("age");
                        list.add(new User(name, lastname, age));
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try (Connection connection = new Util().getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("TRUNCATE TABLE userbd.users");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

