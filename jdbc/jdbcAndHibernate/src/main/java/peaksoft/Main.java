package peaksoft;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.List;

/**
 * Created by "Atabek Dosbaev"
 */
public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
       UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
   //  userDaoJdbc.createUsersTable();
        
//        userDaoJdbc.dropUsersTable();
        
//        userDaoJdbc.saveUser("Meerim","Nazarova", (byte) 23);
//        userDaoJdbc.saveUser("Marat","Torokulov", (byte)30);
//        userDaoJdbc.saveUser("Aigerim","Islamova", (byte)35);
//        userDaoJdbc.saveUser("Zarip","Imankulov",(byte)19);
        
//        userDaoJdbc.removeUserById(1);
        
//        List<User> allPerson = userDaoJdbc.getAllUsers();
//        System.out.println(allPerson);
        
      //  userDaoJdbc.cleanUsersTable();


    }
}
