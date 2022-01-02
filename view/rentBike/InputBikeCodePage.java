package view.rentBike;

import controller.RentBikeController;
import fxml_view.EcoMainPage;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InputBikeCodePage implements Initializable {
    private RentBikeController controller;
    private String bikeCode; //inputted by User
    public Stage inputBikeCodeStage;
    @FXML
    private Text errMessage;

    @FXML
    private TextField bikeCodeInput;

    public InputBikeCodePage(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errMessage.setText("");
        bikeCodeInput.setText("");
    }

    @FXML
    public void submitBikeCode() throws IOException {
        bikeCode = bikeCodeInput.getText();
        if (bikeCode.isBlank()){
            this.inputBikeCodeStage.close();
            errMessage.setText("Mã số xe không được phép để trống !");
            this.inputBikeCodeStage.show();
        } else if (!controller.checkBikeExist(bikeCode)){
            this.inputBikeCodeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("Xe không tồn tại !");
            this.inputBikeCodeStage.show();
        } else if (controller.checkBikeRent(bikeCode)){
            this.inputBikeCodeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("Xe đang được người khác thuê !");
            this.inputBikeCodeStage.show();
        } else if (controller.getRentBikeNum(EcoMainPage.userId) >= 1){
            this.inputBikeCodeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("Quý khách chỉ được phép thuê tối đa 1 xe!");
            this.inputBikeCodeStage.show();
        } else{
            errMessage.setText("");
            GeneralBikeDetailPage generalBikeDetailPage = controller.getGeneralBikeDetail();
            Stage generalBikeStage = generalBikeDetailPage.getGeneralBikeDetailPage();
            generalBikeDetailPage.display(bikeCode);
            this.inputBikeCodeStage.close();
            generalBikeStage.show();
        }
    }

    @FXML
    public void returnEcoMain(){
        this.inputBikeCodeStage.close();
        Main.home.show();
    }

    public void setController(RentBikeController controller) {
        this.controller = controller;
    }

    public Stage getInputBikeCodeStage() {
        return inputBikeCodeStage;
    }

    public void setInputBikeCodeStage(Stage inputBikeCodeStage) {
        this.inputBikeCodeStage = inputBikeCodeStage;
    }
}
