package view.bank;

import controller.PaymentController;
import fxml_view.EcoMainPage;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.bank.finalPayment.IPayment;
import view.rentBike.GeneralBikeDetailPage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InputCardIdPage implements Initializable {
    @FXML
    private Text moneyText;

    @FXML
    private Text errMessage;

    @FXML
    private TextField cardTextInput;
    private PaymentController controller;

    private Stage inputCardStage;
    public static Stage successPayment;
    private String cardId;
    private String bikeCode;
    private int status;
    private String moneyFromBikeDetail;
    private IPayment iPayment;
    private int addMoney;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void confirmToPay(){
        cardId = cardTextInput.getText();
        if(cardId.isBlank()){
            GeneralBikeDetailPage.inputCardStage.close();
            errMessage.setText("Thẻ ngân hàng không được để trống!");
            GeneralBikeDetailPage.inputCardStage.show();
        } else if (this.controller.getBalance(cardId) < 0){
            // balance = -1 -->
            GeneralBikeDetailPage.inputCardStage.close();
            errMessage.setText("Thẻ không tồn tại!");
            cardTextInput.setText("");
            GeneralBikeDetailPage.inputCardStage.show();
        } else {
            controller.add(cardId,addMoney);
            int subtractResult = controller.subtract(cardId, Integer.parseInt(moneyFromBikeDetail));
            if(subtractResult == 0){
                //NOT ENOUGH
                GeneralBikeDetailPage.inputCardStage.close();
                errMessage.setText("Số dư không đủ thanh toán!");
                cardTextInput.setText("");
                GeneralBikeDetailPage.inputCardStage.show();
            } else if (subtractResult == -1){
                // ERR WITH UPDATE
                GeneralBikeDetailPage.inputCardStage.close();
                errMessage.setText("Không thể cập nhật số dư tài khoản");
                cardTextInput.setText("");
                GeneralBikeDetailPage.inputCardStage.show();
            } else {
                // PAYMENT SUCCESSFULLY
                try {
                    SuccessPaymentPage successPaymentPage = getSuccessPaymentPage(this.iPayment);
                    successPayment = successPaymentPage.getStage();
                    cardTextInput.setText("");
                    errMessage.setText("");
                    GeneralBikeDetailPage.inputCardStage.close();
                    successPayment.show();
                }catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        }
    }

    @FXML
    public void returnEcoMain(){
        GeneralBikeDetailPage.inputCardStage.close();
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

    public SuccessPaymentPage getSuccessPaymentPage(IPayment iPayment) throws IOException {
        return this.controller.getSuccessPaymentPage(iPayment);
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
