package controller;

import generalBikeSubsystem.IGeneralBike;
import generalBikeSubsystem.generalBikeAPI.GeneralBikeManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rentBikeHistorySubsystem.IRentBikeHistory;
import rentBikeHistorySubsystem.rentBikeHistoryAPI.RentBikeHistoryManager;
import view.rentBike.GeneralBikeDetailPage;
import view.rentBike.InputBikeCodePage;

import java.io.IOException;
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

    public int getRentBikeNum(Integer customerId){
        return rentBikeHistory.getRentBikeNum(customerId);
    }

    public Map<String, String> getBikeDetail(String bikeCode){
        return generalBike.getBikeDetail(bikeCode).encapsulate();
    }

    public GeneralBikeDetailPage getGeneralBikeDetail() throws IOException {
        GeneralBikeDetailPage generalBikeDetailPage = new GeneralBikeDetailPage();
        generalBikeDetailPage.setController(this);
        Stage stage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/rentBike/GeneralBikeDetailPage.fxml"));
        stage.setScene(new Scene(anchorPane));
        generalBikeDetailPage.setGeneralBikeDetailPage(stage);
        return generalBikeDetailPage;

//        RentBikeController rentBikeController = new RentBikeController();
//        InputBikeCodePage inputBikeCodePage = new InputBikeCodePage();
//        inputBikeCodePage.setController(rentBikeController);
//        Stage stage = new Stage();
//        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/rentBike/InputBikeCodePage.fxml"));
//        stage.setScene(new Scene(anchorPane));
//        inputBikeCodePage.setInputBikeCodeStage(stage);
//        return inputBikeCodePage;
    }

}
