package model;

import java.sql.Timestamp;

public class RentBikeHistory {
    private String bikeCode;
    private String userId;
    private int status;
    private Timestamp startTime;
    public RentBikeHistory(String bikeCode, String userId, int status, Timestamp startTime) {
        this.bikeCode = bikeCode;
        this.userId = userId;
        this.status = status;
        this.startTime = startTime;
    }
    public RentBikeHistory() {
    }
    
}
