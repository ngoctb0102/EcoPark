package bikeFactory;

import model.generalBike.EBike;
import model.generalBike.GeneralBike;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EBikeFactory implements GeneralBikeFactory{
    @Override
    public GeneralBike createBikeObject(String bikeCode, Connection connection){
        EBike eBike = new EBike();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT EBike.licensePlate, name, weight, manufacturedDate," +
                            "batteryPercent, loadCycle, estimatedTimeLeft " +
                            "FROM GeneralBike JOIN EBike " +
                            "ON EBike.licensePlate = GeneralBike.licensePlate " +
                            "WHERE EBike.licensePlate = '"+bikeCode+"';";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                eBike.setName(resultSet.getString("name"));
                eBike.setWeight(resultSet.getDouble("weight"));
                eBike.setLicensePlate(resultSet.getString("licensePlate"));
                eBike.setManufacturedDate(resultSet.getDate("manufacturedDate"));
                eBike.setBatteryPercent(resultSet.getDouble("batteryPercent"));
                eBike.setLoadCycle(resultSet.getInt("loadCycle"));
                eBike.setEstimatedTimeLeft(resultSet.getTime("estimatedTimeLeft"));
            }

            query = "SELECT * FROM Asset WHERE type = 'EBike';";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                eBike.setCost(resultSet.getInt("cost"));
                eBike.setImage(resultSet.getString("image"));
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return eBike;
    }
}
