package controller;
import view.returnBike.*;

import java.util.List;
import java.sql.Timestamp;
import model.*;
import model.generalBike.*;

public class ReturnBikePageController {
    private RentBikeHistory rentHis;
    private List<BikeDock> dockList;
    public ReturnBikePageController() {
    }
    public ReturnBikePage createReturnBikePage(){
        return new ReturnBikePage();
    }
    public ChooseBikeDockPage createChooseBikeDockPage(){
        return new ChooseBikeDockPage();
    }
    public RentBikeHistory getRentBikeHistory(String userId){
        return new RentBikeHistory();
    }
    public int getBikeCost(String bikeCode){
        return 0;
    }
    public int calculateTotalMoney(RentBikeHistory rentHis){
        Timestamp rentTime = rentHis.getStartTime();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        long diff = now.getTime() - rentTime.getTime();
        int minute = (int) diff / 1000 / 60;
        int cost = getBikeCost(rentHis.getBikeCode());
        if(minute < 10){
            return 0;
        }else{
            return cost + cost/10*3 * (int)((Math.abs((minute-30)/2) + (minute - 30)/2)/15) ;
        }
    }
    public String getTransactionInfor(RentBikeHistory rentHis){
        return null;
    }
}
