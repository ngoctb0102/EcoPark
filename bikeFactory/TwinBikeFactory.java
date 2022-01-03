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
            }

            query = "SELECT * FROM Asset WHERE type = 'TwinBike';";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                twinBike.setCost(resultSet.getInt("deposit"));
                twinBike.setImage(resultSet.getString("image"));
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return twinBike;
    }
}
