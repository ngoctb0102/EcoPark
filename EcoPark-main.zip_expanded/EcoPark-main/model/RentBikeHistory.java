package model;

import java.sql.Timestamp;

public class RentBikeHistory {
    private String bikeCode;
    private int userId;
    private int status;
    private Timestamp startTime;
    public RentBikeHistory(String bikeCode, int userId, int status, Timestamp startTime) {
        this.bikeCode = bikeCode;
        this.userId = userId;
        this.status = status;
        this.startTime = startTime;
    }
    public Timestamp getStartTime() {
        return startTime;
    }
    public String getBikeCode() {
        return bikeCode;
    }
    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
    public RentBikeHistory() {
    }
    
}
