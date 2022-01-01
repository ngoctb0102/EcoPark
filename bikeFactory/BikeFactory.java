package bikeFactory;

import model.generalBike.Bike;
import model.generalBike.GeneralBike;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BikeFactory implements GeneralBikeFactory{
    @Override
    public GeneralBike createBikeObject(String bikeCode, Connection connection) {
        Bike bike = new Bike();
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM GeneralBike WHERE licensePlate = '"+bikeCode+"';";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                bike.setName(resultSet.getString("name"));
                bike.setWeight(resultSet.getDouble("weight"));
                bike.setLicensePlate(resultSet.getString("licensePlate"));
                bike.setManufacturedDate(resultSet.getDate("manufacturedDate"));
            }

            query = "SELECT * FROM Asset WHERE type = 'Bike';";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                bike.setCost(resultSet.getInt("cost"));
                bike.setImage(resultSet.getString("image"));
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return bike;
    }
}
