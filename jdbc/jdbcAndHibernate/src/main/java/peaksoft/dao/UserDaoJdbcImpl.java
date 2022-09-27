package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE person(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(40) NOT NULL," +
                "lastName VARCHAR(40) NOT NULL," +
                "age INT);";
        try(
                Connection connection = Util.connection();
                Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("table is create");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE person";
        try (
                Connection connection = Util.connection();
                Statement statement = connection.createStatement()){
                statement.executeUpdate(sql);
            System.out.println("Table is drop");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "Insert into person(name,lastName,age) values(?,?,?)";
        try(
                Connection connection = Util.connection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,name);
            statement.setString(2,lastName);
            statement.setInt(3,age);
            statement.executeUpdate();
            System.out.println("Successfully added "+name);
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM person WHERE id = ?";
        try(
                Connection connection = Util.connection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, (int) id);
            statement.executeUpdate();
            System.out.println("The person is delete");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM person";
        List<User> person = new ArrayList<>();
        try (Connection connection = Util.connection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)){
            while (resultSet.next()){
                User user = new User();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                int age = resultSet.getInt("age");
                user.setId((long)id);
                user.setName(name);
                user.setLastName(lastName);
                user.setAge((byte)age);
                person.add(user);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return person;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE person";
        try (
                Connection connection = Util.connection();
                Statement statement = connection.createStatement()){
            statement.executeUpdate(sql);
            System.out.println("Table is cleaned");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


}