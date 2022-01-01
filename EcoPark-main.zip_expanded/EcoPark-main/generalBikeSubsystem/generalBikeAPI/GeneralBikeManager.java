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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import static generalBikeSubsystem.generalBikeAPI.GeneralBikeConnector.connect;

public class GeneralBikeManager implements IGeneralBike {
    private static Connection connection;
    private static HashMap<String,GeneralBikeFactory> records = new HashMap<>();
    private static GeneralBikeManager instance;

    public GeneralBikeManager(){
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

    //create new bike data in database.
    @Override
    public void createBike(HashMap<String, String> BikeInfo) throws ParseException  {
		// TODO Auto-generated method stub
		try {
            connection = connect();
            
            //insert to general bike table
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO GeneralBike VALUES ( "
            		+ "'" + BikeInfo.get("License Plate") + "',"
            		+ "'" + BikeInfo.get("Name") + "',"
            		+ Double.parseDouble(BikeInfo.get("Weight")) + ","
            		+ "'" + BikeInfo.get("Manufactured Date") + "',"
            		+ "'" + BikeInfo.get("Type") + "',"
            		+ "'" + BikeInfo.get("DockId") + "'"
            		+ ")");	
            if(BikeInfo.get("Type") == "EBike") {
            	SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
    			java.util.Date dt2 = dt.parse(BikeInfo.get("Estimate time left"));
    			Timestamp timestamp = new java.sql.Timestamp(dt2.getTime());
	           statement.executeUpdate("INSERT INTO EBike VALUES ("
	        		   + "'" + BikeInfo.get("License Plate") + "',"
	        		   + Double.parseDouble(BikeInfo.get("Battery Percent")) + ","
	        		   + Integer.parseInt(BikeInfo.get("Load Cycle")) + ","
	        		   + "'" + timestamp +"'"
	        		   + ")");
            }
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
}
