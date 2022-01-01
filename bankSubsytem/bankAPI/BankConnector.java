package bankSubsytem.bankAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankConnector {
    private static final String url = "jdbc:postgresql://localhost:5432/ITSSEcoPark";
    private static final String user = "postgres";
    private static final String password = "123";
    //private static final String password = "123456";

    public static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException sqlException){
            System.out.print("Connection Failed!");
            sqlException.printStackTrace();
        }
        return conn;
    }  
}
