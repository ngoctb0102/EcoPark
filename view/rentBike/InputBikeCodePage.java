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
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

public class InputBikeCodePage implements Initializable {
    private RentBikeController controller;
    private String bikeCode; //inputted by User
    public static Stage generalBikeStage;
    public static Stage inputBikeCodeStage;
    @FXML
    private Text errMessage;

    @FXML
    private TextField bikeCodeInput;

    public InputBikeCodePage(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new RentBikeController();
        errMessage.setText("");
        bikeCodeInput.setText("");
    }

    @FXML
    public void submitBikeCode() throws IOException {
        bikeCode = bikeCodeInput.getText();
        if (bikeCode.isBlank()){
            EcoMainPage.rentBikeStage.close();
            errMessage.setText("Mã số xe không được phép để trống !");
            EcoMainPage.rentBikeStage.show();
        } else if (controller.checkBikeRent(bikeCode)){
            EcoMainPage.rentBikeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("Xe đang được người khác thuê !");
            EcoMainPage.rentBikeStage.show();
        } else if (!controller.checkBikeExist(bikeCode)){
            EcoMainPage.rentBikeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("Xe không tồn tại !");
            EcoMainPage.rentBikeStage.show();
        } else if (controller.getRentBikeNum(EcoMainPage.userId) >= 1){
            EcoMainPage.rentBikeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("Quý khách chỉ được phép thuê tối đa 1 xe!");
            EcoMainPage.rentBikeStage.show();
        } else{
            errMessage.setText("");
            GeneralBikeDetailPage generalBikeDetailPage = controller.getGeneralBikeDetail();
            generalBikeStage = generalBikeDetailPage.getGeneralBikeDetailPage();
            System.out.println("Information of selected Bike");
            generalBikeDetailPage.display(bikeCode);
            EcoMainPage.rentBikeStage.close();
            generalBikeStage.show();
        }
    }

    @FXML
    public void returnEcoMain(){
        EcoMainPage.rentBikeStage.close();
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
