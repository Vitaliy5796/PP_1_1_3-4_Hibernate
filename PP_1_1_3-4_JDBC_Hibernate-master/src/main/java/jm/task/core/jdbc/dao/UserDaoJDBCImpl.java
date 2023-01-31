package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = Util.getDbConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String create = "CREATE TABLE IF NOT EXISTS test1.users (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45), lastName VARCHAR(45), age INT);";
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.execute(create);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void dropUsersTable() {
        String drop = "DROP TABLE test1.users;";
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.execute(drop);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = connection
                .prepareStatement("INSERT INTO test1.users (name, lastName, age) VALUE(?,?,?)")){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public void removeUserById(long id) {
        String remove = "delete from users where id = " + id + ";";
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.execute(remove);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new LinkedList<>();
        String getAll = "SELECT * FROM test1.users;";
        Statement statement;
        ResultSet resultSet;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getAll);
            while (resultSet.next()) {
                list.add(new User(resultSet.getString("name"), resultSet.getString("lastName"), resultSet.getByte("age")));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return list;
    }

    public void cleanUsersTable() {
        String clean = "delete from users;";
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.execute(clean);
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
