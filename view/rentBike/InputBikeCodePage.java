package view.rentBike;

import controller.RentBikeController;
import fxml_view.EcoMainPage;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InputBikeCodePage implements Initializable {
    private RentBikeController controller;
    //private GeneralBikeDetailPage generalBikeDetailPage;
    private Stage inputBikeCodeStage;
    private String bikeCode; //inputted by User
    @FXML
    private Text errMessage;

    @FXML
    private TextField bikeCodeInput;

    public InputBikeCodePage(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //controller = new RentBikeController();
        errMessage.setText("");
        bikeCodeInput.setText("");
    }

    @FXML
    public void submitBikeCode() throws IOException {
        bikeCode = bikeCodeInput.getText();
        if (bikeCode.isBlank()){
            inputBikeCodeStage.close();
            errMessage.setText("Mã số xe không được phép để trống !");
            inputBikeCodeStage.show();
        } else if (controller.checkBikeRent(bikeCode)){
            inputBikeCodeStage.close();
            errMessage.setText("Xe đang được người khác thuê !");
            inputBikeCodeStage.show();
        } else if (controller.checkBikeExist(bikeCode)){
            inputBikeCodeStage.close();
            errMessage.setText("Xe không tồn tại !");
            inputBikeCodeStage.show();
        } else if (controller.getRentBikeNum(EcoMainPage.userId) >= 1){
            inputBikeCodeStage.close();
            errMessage.setText("Quý khách chỉ được phép thuê tối đa 1 xe!");
            inputBikeCodeStage.show();
        } else{
            errMessage.setText("");
            GeneralBikeDetailPage generalBikeDetailPage = controller.getGeneralBikeDetail();
            generalBikeDetailPage.display(bikeCode);
            inputBikeCodeStage.close();
            generalBikeDetailPage.getGeneralBikeDetailPage().show();
        }
    }

    @FXML
    public void returnEcoMain(){
        inputBikeCodeStage.close();
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
