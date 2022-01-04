package generalBikeSubsystem;

import java.text.ParseException;
import java.util.HashMap;

import model.generalBike.GeneralBike;

public interface IGeneralBike {
    //Rent Bike
    public boolean checkBikeExist(String bikeCode);
    public GeneralBike getBikeDetail(String bikeCode);

    //Add Bike
    public void createBike(HashMap<String, String> BikeInfo) throws ParseException ;
}
