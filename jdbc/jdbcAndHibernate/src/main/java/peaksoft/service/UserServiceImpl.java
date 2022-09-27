package peaksoft.service;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

    public void createUsersTable() {
        userDaoJdbc.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJdbc.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJdbc.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
        userDaoJdbc.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return  userDaoJdbc.getAllUsers();

    }

    public void cleanUsersTable() {
        userDaoJdbc.cleanUsersTable();
    }
}
