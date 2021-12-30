package bikeDockSubsystem.bikeDockAPI;
import java.util.List;
import java.util.ArrayList;

import bikeDockSubsystem.*;
import model.*;
import static bikeDockSubsystem.bikeDockAPI.BikeDockconnector.connect;
import java.sql.*;


public class BikeDockManager implements IBikeDockSubsystem{
    public static Connection connection;
    @Override
    public List<BikeDock> getDockList() {
        List<BikeDock> list = new ArrayList<BikeDock>();
        try {
            connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT *  FROM BikeDock ");
            while(resultSet.next()){
                BikeDock bikedock = new BikeDock(resultSet.getString("dockId"),resultSet.getString("dockName"),resultSet.getString("description"),resultSet.getDouble("distance"));
                list.add(bikedock);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return list;
    }
}
