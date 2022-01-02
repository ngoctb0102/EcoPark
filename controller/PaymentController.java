package controller;

import bankSubsytem.IBankSubsystem;
import bankSubsytem.bankAPI.BankManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import rentBikeHistorySubsystem.IRentBikeHistory;
import rentBikeHistorySubsystem.rentBikeHistoryAPI.RentBikeHistoryManager;
import view.bank.InputCardIdPage;
import view.bank.SuccessPaymentPage;
import view.bank.finalPayment.IPayment;

import java.io.IOException;
import java.sql.Timestamp;

public class PaymentController {
    private IBankSubsystem bankSubsystem;
    private IRentBikeHistory rentBikeHistory;

    public PaymentController() {
        this.bankSubsystem = new BankManager();
        this.rentBikeHistory = new RentBikeHistoryManager();
    }

    public Integer getBalance(String cardId){
        return bankSubsystem.getBalance(cardId);
    }

    public int subtract(String cardId, int money){
        return bankSubsystem.subtract(cardId,money);
    }

    public int add(String cardId, int money){ return bankSubsystem.add(cardId,money);}

    public InputCardIdPage getInputCardIdPage(String money, int addMoney, IPayment iPayment) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml_view/payment/InputCardScreen.fxml"));
        Stage stage = new Stage();
        AnchorPane anchorPane = loader.load();
        stage.setScene(new Scene(anchorPane));

        InputCardIdPage inputCardIdPage = loader.getController();
        inputCardIdPage.setController(this);
        inputCardIdPage.setInputCardStage(stage);
        inputCardIdPage.setMoneyFromBikeDetail(money);
        inputCardIdPage.setAddMoney(addMoney);
        inputCardIdPage.setIPayment(iPayment);
        return inputCardIdPage;
    }

    public SuccessPaymentPage getSuccessPaymentPage(IPayment iPayment) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml_view/payment/SuccessPayment.fxml"));
        Stage stage = new Stage();
        AnchorPane anchorPane = loader.load();
        stage.setScene(new Scene(anchorPane));

        SuccessPaymentPage successPaymentPage = loader.getController();
        successPaymentPage.setPaymentController(this);
        successPaymentPage.setStage(stage);
        successPaymentPage.setPaymentLastStep(iPayment);

        return successPaymentPage;
    }

    public void saveRentBikeHistory(int customerId, String bikeCode, int status, Timestamp startTime) {
        rentBikeHistory.saveRentBikeHistory(customerId,bikeCode,status,startTime);
    }
}
