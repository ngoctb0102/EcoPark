package generalBikeSubsystem.generalBikeAPI;

import bikeFactory.BikeFactory;
import bikeFactory.EBikeFactory;
import bikeFactory.GeneralBikeFactory;
import bikeFactory.TwinBikeFactory;
import generalBikeSubsystem.IGeneralBike;
import model.generalBike.GeneralBike;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import static generalBikeSubsystem.generalBikeAPI.GeneralBikeConnector.connect;

public class GeneralBikeManager implements IGeneralBike {
    private static Connection connection;
    private static HashMap<String,GeneralBikeFactory> records = new HashMap<>();
    private static GeneralBikeManager instance;

    private GeneralBikeManager(){
        records.put("Bike",new BikeFactory());
        records.put("TwinBike",new TwinBikeFactory());
        records.put("EBike",new EBikeFactory());
    }

    @Override
    public boolean checkBikeExist(String bikeCode) {
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
    public GeneralBike getBikeDetail(String bikeCode) {
        GeneralBike generalBike = null;
        try{
            connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT type FROM GeneralBike WHERE licensePlate = "+bikeCode);
            String bikeType = resultSet.getCharacterStream("type").toString();
            generalBike = createBikeObjectDB(getGeneralBikeWithType(bikeType),bikeCode,connect());
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return generalBike;
    }

    public GeneralBike createBikeObjectDB(GeneralBikeFactory generalBikeFactory, String bikeCode, Connection connection){
        return generalBikeFactory.createBikeObject(bikeCode, connection);
    }

    public static GeneralBikeManager getInstance(){
        if (instance == null) instance = new GeneralBikeManager();
        return instance;
    }

    public GeneralBikeFactory getGeneralBikeWithType(String bikeType){
        return records.get(bikeType);
    }
}
