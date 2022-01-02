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
                bikeNum = resultSet.getInt("bikeNum");
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
            String query = "SELECT status FROM RentBikeHistory " +
                    "WHERE licensePlate = '"+bikeCode+"' ORDER BY startTime DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(query);
            if(!resultSet.next()) rentResult = false;
            else {
                if (resultSet.getInt("status") == 0) rentResult = false;
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
    public void saveRentBikeHistory(int customerId, String bikeCode, int status, Timestamp startTime) {
        try{
            connection = connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "INSERT INTO RentBikeHistory(licensePlate, userId, status, startTime)" +
                    "VALUES ('"+bikeCode+"',"+customerId+","+status+",'"+startTime+"')");
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
            ResultSet resultSet = statement.executeQuery("SELECT cost FROM GeneralBike WHERE licensePlate = \'"+bikeCode+"\';");
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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rentbikehistory WHERE userid = " + customerId + "ORDER BY starttime DESC LIMIT 1");
            if(resultSet.next()){
                 rentHis = new RentBikeHistory(resultSet.getString("licenseplate"),resultSet.getInt("userid"),resultSet.getInt("status"),resultSet.getTimestamp("starttime"));
            }
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return rentHis;
    }
    @Override
    public int getRentBikeDeposit(String bikeCode){
        int cost = 0;
        try{
            connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT deposit FROM GeneralBike WHERE licensePlate = \'"+bikeCode+"\';");
            if(resultSet.next()) cost = resultSet.getInt("deposit");
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return cost;
    }
    @Override
    public void returnBikeHistory(int customerId, String bikeCode){
        try{
            connection = connect();
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "UPDATE RentBikeHistory " +
                    "SET status = '0' " + "WHERE userid = \'" + customerId + "\'AND licenseplate = \'" + bikeCode + "\'");
            statement.close();
            connection.close();
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
