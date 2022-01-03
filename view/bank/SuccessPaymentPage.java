package view.bank;

import controller.PaymentController;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import view.bank.finalPayment.IPayment;

public class SuccessPaymentPage {
    private PaymentController paymentController;
    private Stage stage;

    public void setPaymentController(PaymentController paymentController) {
        this.paymentController = paymentController;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

    @FXML
    public void clickOK(){
        //TODO
        paymentController.completeLastStep();
        this.stage.close();
        Main.home.show();
    }
}
