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
        //inputted by User
        String bikeCode = bikeCodeInput.getText();
        if (bikeCode.isBlank()){
            this.inputBikeCodeStage.close();
            errMessage.setText("Please fill in this blank bikeCode !");
            this.inputBikeCodeStage.show();
        } else if (!controller.checkBikeExist(bikeCode)){
            this.inputBikeCodeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("Bike with inputted bikeCode not exist !");
            this.inputBikeCodeStage.show();
        } else if (controller.checkBikeRent(bikeCode)){
            this.inputBikeCodeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("Bike with inputted bikeCode is being rent !");
            this.inputBikeCodeStage.show();
        } else if (controller.getRentBikeNum(EcoMainPage.userId) >= 1){
            this.inputBikeCodeStage.close();
            bikeCodeInput.setText("");
            errMessage.setText("You can only rent 1 bike with 1 account !");
            this.inputBikeCodeStage.show();
        } else{
            errMessage.setText("");
            this.controller.setBikeCode(bikeCode);
            GeneralBikeDetailPage generalBikeDetailPage = this.getBikeDetailPage();
            Stage generalBikeStage = generalBikeDetailPage.getGeneralBikeDetailStage();
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

    public GeneralBikeDetailPage getBikeDetailPage() throws IOException {
        return this.controller.getGeneralBikeDetail();
    }
}
