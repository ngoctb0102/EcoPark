package controller;

import bankSubsytem.IBankSubsystem;
import bankSubsytem.bankAPI.BankManager;
import generalBikeSubsystem.IGeneralBike;
import generalBikeSubsystem.generalBikeAPI.GeneralBikeManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rentBikeHistorySubsystem.IRentBikeHistory;
import rentBikeHistorySubsystem.rentBikeHistoryAPI.RentBikeHistoryManager;
import view.bank.InputCardIdPage;
import view.rentBike.GeneralBikeDetailPage;
import view.rentBike.InputBikeCodePage;

import java.io.IOException;
import java.util.Map;

public class RentBikeController {
    private IGeneralBike generalBike;
    private IRentBikeHistory rentBikeHistory;
    private IBankSubsystem bankSubsystem;
    private InputBikeCodePage view;

    public RentBikeController(){
        this.generalBike = GeneralBikeManager.getInstance();
        this.rentBikeHistory = new RentBikeHistoryManager();
        this.bankSubsystem = new BankManager();
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml_view/rentBike/GeneralBikeDetailPage.fxml"));
        Stage stage = new Stage();
        AnchorPane anchorPane = loader.load();
        stage.setScene(new Scene(anchorPane));

        GeneralBikeDetailPage generalBikeDetailPage = loader.getController();
        generalBikeDetailPage.setController(this);
        generalBikeDetailPage.setGeneralBikeDetailPage(stage);
        return generalBikeDetailPage;
    }

    public InputCardIdPage getInputCardIdPage(String money) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml_view/payment/InputCardScreen.fxml"));
        Stage stage = new Stage();
        AnchorPane anchorPane = loader.load();
        stage.setScene(new Scene(anchorPane));

        InputCardIdPage inputCardIdPage = loader.getController();
        inputCardIdPage.setRentBikeController(this);
        inputCardIdPage.setInputCardStage(stage);
        inputCardIdPage.setMoneyFromBikeDetail(money);
        return inputCardIdPage;
    }

}
