package rentBikeHistorySubsystem.rentBikeHistoryAPI;

import rentBikeHistorySubsystem.IRentBikeHistory;
import java.sql.*;
import static rentBikeHistorySubsystem.rentBikeHistoryAPI.RentBikeHistoryConnector.connect;
import model.*;

public class RentBikeHistoryManager implements IRentBikeHistory {
    public static Connection connection;
    @Override
    public int getRentBikeNum(int customerId) {
        int bikeNum = 0;
        try {
            connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT COUNT(licensePlate) AS bikeNum FROM RentBikeHistory " +
                            " WHERE userId = "+customerId+" AND status = 1");
            if (resultSet.next()){
                bikeNum = resultSet.getInt("bkeNum");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return bikeNum;
    }

    @Override
    public boolean checkBikeRent(String bikeCode) {
        boolean rentResult = true;
        try{
            connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                        "SELECT state FROM RentBikeHistory " +
                            "WHERE licensePlate = "+bikeCode+" ORDER BY startTime DESC LIMIT 1");
            if(!resultSet.next()) rentResult = false;
            else {
                resultSet.next();
                if (resultSet.getInt("state") == 0) rentResult = false;
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return rentResult;
    }

    @Override
    public void saveRentBikeHistory(int customerId, String bikeCode, int status, Date startTime) {
        try{
            connection = connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO RentBikeHistory(licensePlate, userId, status, startTime)" +
                    "VALUES ("+bikeCode+","+customerId+","+status+","+startTime+")");
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public int getBikeCost(String bikeCode){
        int cost = 0;
        try{
            connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT cost FROM GeneralBike WHERE licensePlate = " + bikeCode);
            if(resultSet.next()) cost = resultSet.getInt("cost");
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return cost;
    }
    @Override
    public RentBikeHistory getRentBikeHistory(int customerId){
        RentBikeHistory rentHis = new RentBikeHistory();
        try{
            connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.\"rentbikehistory\" WHERE userId = " + customerId + "ORDER BY startTime DESC LIMIT 1");
            if(resultSet.next()){
                 rentHis = new RentBikeHistory(resultSet.getString("licensePlate"),resultSet.getInt("userid"),resultSet.getInt("status"),resultSet.getTimestamp("starttime"));
            }
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return rentHis;
    }
}