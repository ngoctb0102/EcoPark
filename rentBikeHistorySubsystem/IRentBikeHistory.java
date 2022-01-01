package rentBikeHistorySubsystem;

import java.sql.Timestamp;

import model.*;

public interface IRentBikeHistory {
    public int getRentBikeNum(int customerId);
    public boolean checkBikeRent(String bikeCode);
    public void saveRentBikeHistory(int customerId, String bikeCode, int status, Timestamp startTime);
    public int getBikeCost(String bikeCode);
    public RentBikeHistory getRentBikeHistory(int customerId);
}
