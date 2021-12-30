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
    private Stage inputBikeCodeStage;
    private String bikeCode; //inputted by User
    @FXML
    private Text errMessage;

    @FXML
    private TextField bikeCodeInput;

    public InputBikeCodePage(){
        inputBikeCodeStage = new Stage();
        try{
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../../fxml_view/rentBike/InputBikeCodePage.fxml"));
            inputBikeCodeStage.setScene(new Scene(anchorPane));
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new RentBikeController();
    }

    @FXML
    public void submitBikeCode() throws IOException {
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
            EcoMainPage.rentBikeStage.show();
        } else if (controller.getRentBikeNum(EcoMainPage.userId) >= 1){
            EcoMainPage.rentBikeStage.close();
            errMessage.setText("Quý khách chỉ được phép thuê tối đa 1 xe!");
            EcoMainPage.rentBikeStage.show();
        } else{
            errMessage.setText("");
            //generalBikeDetailStage = controller.getGeneralBikeDetail();
            EcoMainPage.rentBikeStage.close();
        }
    }

    @FXML
    public void returnEcoMain(){
        EcoMainPage.rentBikeStage.close();
        Main.home.show();
    }
}
