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
import javafx.stage.Stage;
import view.rentBike.InputBikeCodePage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import view.bank.finalPayment.ReturnPayment;
import view.bank.InputCardIdPage;


public class ReturnBikePageController {
    private RentBikeHistory rentHis;
    private List<BikeDock> dockList;
    private IRentBikeHistory rentBikeHistory;
    private IBikeDockSubsystem bikeDockSubsystem;
    public int userId;
    private ReturnPayment iPayment;
    private PaymentController paymentController = new PaymentController();
    public ReturnBikePageController() {
        this.rentBikeHistory = new RentBikeHistoryManager();
        this.bikeDockSubsystem = new BikeDockManager();
        this.userId = 1;
        this.rentHis = this.rentBikeHistory.getRentBikeHistory(userId);
        this.iPayment = new ReturnPayment();
        this.iPayment.setBikeCode(this.rentHis.getBikeCode());
        this.iPayment.setUserId(this.userId);
        this.paymentController.setiPayment(this.iPayment);
    }
    public RentBikeHistory getRentHis() {
        return rentHis;
    }
    public ChooseBikeDockPage createChooseBikeDockPage(){
        return new ChooseBikeDockPage();
    }

    public List<BikeDock> getDockList(){
        return bikeDockSubsystem.getDockList();
    }
    public int getDeposit(){
        return rentBikeHistory.getRentBikeDeposit(this.rentHis.getBikeCode());
    }
    public int calculateTime(){
        Timestamp rentTime = this.rentHis.getStartTime();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        long diff = now.getTime() - rentTime.getTime();
        return (int)(diff / 1000 / 60);
    }
    public int calculateTotalMoney(int cost, int minute){
        // int minute = calculateTime();
        // int cost = rentBikeHistory.getBikeCost(this.rentHis.getBikeCode());
        if(minute <= 10){
            return 0;
        }else if (minute <= 30){
            return cost;
        }else{
            return (cost + cost/10*3*(int)((Math.abs((minute-30)/2) + (minute - 30)/2)/15 + 1)) ;
        }
    }
    public int calculateTotalMoney(){
        int minute = calculateTime();
        int cost = rentBikeHistory.getBikeCost(this.rentHis.getBikeCode());
        if(minute <= 10){
            return 0;
        }else if (minute <= 30){
            return cost;
        }else{
            return (cost + cost/10*3*(int)((Math.abs((minute-30)/2) + (minute - 30)/2)/15 + 1)) ;
        }
    }
    public String getTransactionInfor(){
        // System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa\n");
        String temp = "";
        temp = temp + "Tổng thời gian bạn đã thuê là " + String.valueOf(calculateTime()) + " phút\n";
        temp = temp + "Tổng số tiền bạn phải thanh toán là " + String.valueOf(calculateTotalMoney(rentBikeHistory.getBikeCost(this.rentHis.getBikeCode()),calculateTime())) + "\n";
        return temp;
    }
    public int checkRented(){
        return rentBikeHistory.getRentBikeNum(this.rentHis.getUserId());
    }
    public Stage showTransaction() throws IOException {
        Stage stage = new Stage();
        // ReturnBikePage r = new ReturnBikePage();
        // r.setController(this);
        // r.setTransaction();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/returnBike/SuccessTransaction.fxml"));
        stage.setScene(new Scene(anchorPane));
        return stage;
    }
    public InputCardIdPage inputCardIdPage() throws IOException{
        return this.paymentController.getInputCardIdPage(String.valueOf(this.calculateTotalMoney()),this.getDeposit());
    }
    public ReturnBikePage createReturnBikePage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml_view/returnBike/SuccessTransaction.fxml"));
        Stage stage = new Stage();
        AnchorPane anchorPane = loader.load();
        stage.setScene(new Scene(anchorPane));

        ReturnBikePage returnBikePage = loader.getController();
        returnBikePage.setReturnBikeStage(stage);
        returnBikePage.setController(this);
        return returnBikePage;
    }
}
