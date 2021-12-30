package generalBikeSubsystem.generalBikeAPI;

import generalBikeSubsystem.IGeneralBike;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import static generalBikeSubsystem.generalBikeAPI.GeneralBikeConnector.connect;

public class GeneralBikeManager implements IGeneralBike {
    private static Connection connection;

    @Override
    public boolean checkBikeExist(String bikeCode) {
        //TODO
        boolean isExist = true;
        try {
            connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM GeneralBike WHERE licensePlate = "+bikeCode);
            if (!resultSet.next()) isExist = false;
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return isExist;
    }

    @Override
    public Map<String, String> getBikeDetail() {
        //TODO
        return null;
    }
}
