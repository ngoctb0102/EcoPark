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
    private int userId;
    public ReturnBikePageController() {
        this.rentBikeHistory = new RentBikeHistoryManager();
        this.bikeDockSubsystem = new BikeDockManager();
        this.userId = 1;
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
    public int calculateTotalMoney(RentBikeHistory rentHis){
        Timestamp rentTime = rentHis.getStartTime();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        long diff = now.getTime() - rentTime.getTime();
        int minute = (int) diff / 1000 / 60;
        int cost = rentBikeHistory.getBikeCost(rentHis.getBikeCode());
        if(minute < 10){
            return 0;
        }else{
            return cost + cost/10*3 * (int)((Math.abs((minute-30)/2) + (minute - 30)/2)/15) ;
        }
    }
    public String getTransactionInfor(RentBikeHistory rentHis){
        return null;
    }
    public boolean checkRented(){
        return rentBikeHistory.checkBikeRent(this.rentHis.getBikeCode());
    }
}
