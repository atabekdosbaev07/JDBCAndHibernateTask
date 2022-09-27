package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String userrname = "postgres";
    private static final String password = "1227";

    public static Connection connection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,userrname,password);
            System.out.println("Connected to db successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
