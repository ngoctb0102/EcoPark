package controller;

import generalBikeSubsystem.IGeneralBike;
import generalBikeSubsystem.generalBikeAPI.GeneralBikeManager;
import rentBikeHistorySubsystem.IRentBikeHistory;
import rentBikeHistorySubsystem.rentBikeHistoryAPI.RentBikeHistoryManager;
import view.rentBike.InputBikeCodePage;

import java.util.Map;

public class RentBikeController {
    private IGeneralBike generalBike;
    private IRentBikeHistory rentBikeHistory;
    private InputBikeCodePage view;

    public RentBikeController(){
        this.generalBike = GeneralBikeManager.getInstance();
        this.rentBikeHistory = new RentBikeHistoryManager();
    }

    public boolean checkBikeExist(String bikeCode){
        return generalBike.checkBikeExist(bikeCode);
    }

    public boolean checkBikeRent(String bikeCode){
        return rentBikeHistory.checkBikeRent(bikeCode);
    }

    public int getRentBikeNum(String customerId){
        return rentBikeHistory.getRentBikeNum(customerId);
    }

    public Map<String, String> getBikeDetail(String bikeCode){
        return generalBike.getBikeDetail(bikeCode).encapsulate();
    }

    public void setView(){
        //TODO
    }

//    public BikeDetailPage getBikeDetailPage(){
//
//    }


}
