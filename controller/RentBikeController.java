package controller;

import fxml_view.EcoMainPage;
import generalBikeSubsystem.IGeneralBike;
import generalBikeSubsystem.generalBikeAPI.GeneralBikeManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rentBikeHistorySubsystem.IRentBikeHistory;
import rentBikeHistorySubsystem.rentBikeHistoryAPI.RentBikeHistoryManager;
import view.bank.finalPayment.RentPayment;
import view.rentBike.GeneralBikeDetailPage;

import java.io.IOException;
import java.util.Map;

public class RentBikeController {
    private IGeneralBike generalBike;
    private IRentBikeHistory rentBikeHistory;
    private String bikeCode;

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

    public void setBikeCode(String bikeCode){
        this.bikeCode = bikeCode;
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

        PaymentController paymentController = new PaymentController();
        RentPayment iPayment = new RentPayment();
        iPayment.setBikeCode(bikeCode);
        iPayment.setUserId(EcoMainPage.userId);
        paymentController.setiPayment(iPayment);

        GeneralBikeDetailPage generalBikeDetailPage = loader.getController();
        generalBikeDetailPage.setController(this);
        generalBikeDetailPage.setPaymentController(paymentController);
        generalBikeDetailPage.setGeneralBikeDetailStage(stage);
        generalBikeDetailPage.display(this.bikeCode);
        return generalBikeDetailPage;
    }

}
