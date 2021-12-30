package rentBikeHistorySubsystem;

import java.sql.Date;

public interface IRentBikeHistory {
    public int getRentBikeNum(String customerId);
    public boolean checkBikeRent(String bikeCode);
    public void saveRentBikeHistory(String customerId, String bikeCode, int status, Date startTime);
    public int getBikeCost(String bikeCode);
}
