package controller;
import view.returnBike.*;

import java.util.List;

import model.*;

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
    
}
