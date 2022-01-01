package view.bank;

import controller.RentBikeController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InputCardIdPage implements Initializable {
    @FXML
    private Text moneyText;

    @FXML
    private TextField cardTextInput;
    private RentBikeController rentBikeController;
    private Stage inputCardStage;
    private String cardId;
    private String moneyFromBikeDetail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //moneyText.setText(this.moneyFromBikeDetail);
    }

    @FXML
    public void confirmToPay(){
        cardId = cardTextInput.getText();
    }

    @FXML
    public void returnEcoMain(){

    }

    public void setRentBikeController(RentBikeController rentBikeController) {
        this.rentBikeController = rentBikeController;
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
}
