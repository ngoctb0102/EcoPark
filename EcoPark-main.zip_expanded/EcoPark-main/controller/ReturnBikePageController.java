package controller;
import view.returnBike.*;

import java.util.List;
import java.sql.Timestamp;
import model.*;
import model.generalBike.*;
import bikeDockSubsystem.*;
import rentBikeHistorySubsystem.*;
import rentBikeHistorySubsystem.rentBikeHistoryAPI.*;
import bikeDockSubsystem.bikeDockAPI.*;

public class ReturnBikePageController {
    private RentBikeHistory rentHis;
    private List<BikeDock> dockList;
    private IRentBikeHistory rentBikeHistory;
    private IBikeDockSubsystem bikeDockSubsystem;
    private int userId = 1;
    public ReturnBikePageController() {
        this.rentBikeHistory = new RentBikeHistoryManager();
        this.bikeDockSubsystem = new BikeDockManager();
        this.userId = 1;
        this.rentHis = this.rentBikeHistory.getRentBikeHistory(userId);
    }
    public ReturnBikePage createReturnBikePage(){
        return new ReturnBikePage();
    }
    public ChooseBikeDockPage createChooseBikeDockPage(){
        return new ChooseBikeDockPage();
    }
    public RentBikeHistory getRentBikeHistory(){
        return new RentBikeHistory();
    }

    public List<BikeDock> getDockList(){
        return bikeDockSubsystem.getDockList();
    }
    public int calculateTime(){
        Timestamp rentTime = this.rentHis.getStartTime();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        long diff = now.getTime() - rentTime.getTime();
        return (int)(diff / 1000 / 60);
    }
    public int calculateTotalMoney(){
        int minute = calculateTime();
        int cost = rentBikeHistory.getBikeCost(this.rentHis.getBikeCode());
        if(minute < 10){
            return 0;
        }else{
            return cost + cost/10*3 * (int)((Math.abs((minute-30)/2) + (minute - 30)/2)/15) ;
        }
    }
    public String getTransactionInfor(){
        String temp = "";
        temp = temp + "Chúc mừng bạn đã thanh toán thành công\n";
        temp = temp + "Tổng thời gian bạn đã thuê là " + String.valueOf(calculateTime()) + "\n";
        temp = temp + "Tổng số tiền bạn đã thanh toán là " + String.valueOf(calculateTotalMoney()) + "\n";
        return temp;
    }
    public boolean checkRented(){
        return rentBikeHistory.checkBikeRent(this.rentHis.getBikeCode());
    }
    
}