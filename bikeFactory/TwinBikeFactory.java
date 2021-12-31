package bikeFactory;

import model.generalBike.GeneralBike;
import model.generalBike.TwinBike;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TwinBikeFactory implements GeneralBikeFactory{
    @Override
    public GeneralBike createBikeObject(String bikeCode, Connection connection) {
        TwinBike twinBike = new TwinBike();
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM GeneralBike WHERE licensePlate = '"+bikeCode+"';";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                twinBike.setName(resultSet.getString("name"));
                twinBike.setWeight(resultSet.getDouble("weight"));
                twinBike.setLicensePlate(resultSet.getString("licensePlate"));
                twinBike.setManufacturedDate(resultSet.getDate("manufacturedDate"));
                //twinBike.setImage(resultSet.getString("image"));
                //twinBike.setCost(resultSet.getInt("cost"));
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return twinBike;
    }
}
