package rentBikeHistorySubsystem;

import java.sql.Timestamp;

import model.*;

public interface IRentBikeHistory {
    //Rent Bike
    public int getRentBikeNum(int customerId);
    public boolean checkBikeRent(String bikeCode);
    public void saveRentBikeHistory(int customerId, String bikeCode, int status, Timestamp startTime);

    //Return Bike
    public int getBikeCost(String bikeCode);
    public RentBikeHistory getRentBikeHistory(int customerId);
    public int getRentBikeDeposit(String bikeCode);
    public void returnBikeHistory(int customerId, String bikeCode);
}
