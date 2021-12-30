package generalBikeSubsystem.generalBikeAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GeneralBikeConnector {
    private static final String url = "jdbc:postgresql://localhost:5432/ITSSEcoPark";
    private static final String user = "tuanvu_local";
    private static final String password = "123456";

    public static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return conn;
    }

}