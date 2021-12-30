package view.rentBike;

import controller.RentBikeController;
import fxml_view.EcoMainPage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class InputBikeCodePage implements Initializable {
    private RentBikeController controller;
    private String bikeCode; //inputted by User

    @FXML
    private Text errMessage;

    @FXML
    private TextField bikeCodeInput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new RentBikeController();
    }

    @FXML
    public void submitBikeCode(){
        bikeCode = bikeCodeInput.getText();
        System.out.println("BikeCode: "+bikeCode);
        if (bikeCode.isBlank()){
            EcoMainPage.rentBikeStage.close();
            errMessage.setText("Mã số xe không được phép để trống !");
            EcoMainPage.rentBikeStage.show();
        } else if (controller.checkBikeRent(bikeCode)){
            EcoMainPage.rentBikeStage.close();
            errMessage.setText("Xe đang được người khác thuê !");
            EcoMainPage.rentBikeStage.show();
        } else if (controller.checkBikeExist(bikeCode)){
            EcoMainPage.rentBikeStage.close();
            errMessage.setText("Xe không tồn tại !");
        } else {
            //
        }
    }

    @FXML
    public void returnEcoMain(){}
}
