package bikeDockSubsystem.bikeDockAPI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class BikeDockconnector {
    private static final String url = "jdbc:postgresql://localhost:5432/ITSSEcoPark";
    private static final String user = "postgre";
    private static final String password = "123";

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
