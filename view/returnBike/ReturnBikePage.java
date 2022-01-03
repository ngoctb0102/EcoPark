package view.returnBike;
import controller.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import view.bank.InputCardIdPage;
public class ReturnBikePage implements Initializable{
    public Stage returnBikeStage;
    private ReturnBikePageController controller;
    private PaymentController paymentController;
    public void setPaymentController(PaymentController paymentController) {
        this.paymentController = paymentController;
    }
    public static Stage inputCardStage;
    
    @FXML
    private Text transaction;
    public void setController(ReturnBikePageController controller) {
        this.controller = controller;
    }
    public void setTransaction(){
        String trans = this.controller.getTransactionInfor();
        // System.out.println(trans);
        transaction.setText(trans);
    }
    public void setReturnBikeStage(Stage returnBikeStage){
        this.returnBikeStage = returnBikeStage;
    }
    public Stage getReturnBikeStage() {
        return returnBikeStage;
    }
    @FXML
    public void nextToPay() throws IOException{
        this.returnBikeStage.close();
        InputCardIdPage inputCardIdPage = paymentController.getInputCardIdPage(String.valueOf(this.controller.calculateTotalMoney()),this.controller.getDeposit());
        Stage stage = inputCardIdPage.getInputCardStage();
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.controller = new ReturnBikePageController();
        setTransaction();
    }
    
}
