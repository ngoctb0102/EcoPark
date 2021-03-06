package view.bank;

import controller.PaymentController;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.bank.finalPayment.IPayment;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InputCardIdPage implements Initializable {
    public static Stage returnBike;
    @FXML
    private Text moneyText;

    @FXML
    private Text errMessage;

    @FXML
    private TextField cardTextInput;
    private PaymentController controller;

    private Stage inputCardStage;
    private String bikeCode;
    private String moneyFromBikeDetail;
    private IPayment iPayment;
    private int addMoney;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void confirmToPay() throws IOException{
        String cardId = cardTextInput.getText();
        if(cardId.isBlank()){
            this.inputCardStage.close();
            errMessage.setText("Please fill in this blank cardId field !");
            this.inputCardStage.show();
        } else if (this.controller.getBalance(cardId) < 0){
            // balance = -1 -->
            this.inputCardStage.close();
            errMessage.setText("cardId not existed !");
            cardTextInput.setText("");
            this.inputCardStage.show();
        } else {
            controller.add(cardId,addMoney);
            int subtractResult = controller.subtract(cardId, Integer.parseInt(moneyFromBikeDetail));
            if(subtractResult == 0){
                //NOT ENOUGH
                this.inputCardStage.close();
                errMessage.setText("Your balance is not enough to pay !");
                cardTextInput.setText("");
                this.inputCardStage.show();
            } else if (subtractResult == -1){
                // ERR WITH UPDATE
                this.inputCardStage.close();
                errMessage.setText("Cannot update your balance !");
                cardTextInput.setText("");
                this.inputCardStage.show();
            } else {
                // PAYMENT SUCCESSFULLY
                // if(ChooseBikeDockPage.inputCardStage != null){
                //     ReturnBikePageController returnController = new ReturnBikePageController(); 
                //     returnBike = returnController.showTransaction();
                //     this.inputCardStage.close();
                //     returnBike.show();
                // }
                try {
                    SuccessPaymentPage successPaymentPage = getSuccessPaymentPage();
                    Stage successPayment = successPaymentPage.getStage();
                    cardTextInput.setText("");
                    errMessage.setText("");
                    this.inputCardStage.close();
                    successPayment.show();
                }catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void returnEcoMain(){
        this.inputCardStage.close();
        Main.home.show();
    }

    public void setInputCardStage(Stage inputCardStage) {
        this.inputCardStage = inputCardStage;
    }

    public Stage getInputCardStage() {
        return inputCardStage;
    }

    public void setMoneyFromBikeDetail(String moneyFromBikeDetail) {
        this.moneyFromBikeDetail = moneyFromBikeDetail;
        moneyText.setText(this.moneyFromBikeDetail);
    }

    public void setController(PaymentController controller) {
        this.controller = controller;
    }

    public SuccessPaymentPage getSuccessPaymentPage() throws IOException {
        return this.controller.getSuccessPaymentPage();
    }

    public void setAddMoney(int addMoney) {
        this.addMoney = addMoney;
    }

    public void setIPayment(IPayment iPayment) {
        this.iPayment = iPayment;
    }

    public void setBikeCode(String bikeCode) {
        this.bikeCode = bikeCode;
    }


}
