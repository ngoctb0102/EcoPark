package rentBikeHistorySubsystem;

import java.sql.Date;

public interface IRentBikeHistory {
    public int getRentBikeNum(Integer customerId);
    public boolean checkBikeRent(String bikeCode);
    public void saveRentBikeHistory(String customerId, String bikeCode, int status, Date startTime);

}