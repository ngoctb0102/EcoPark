package fxml_view;

import controller.EcoMainController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import view.rentBike.InputBikeCodePage;
import view.returnBike.ChooseBikeDockPage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EcoMainPage implements Initializable {
    public static Stage rentBikeStage;
    public static Stage returnBikeStage;
    public static Integer userId = 1;
    private EcoMainController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void rentBikeClick() throws IOException {
        InputBikeCodePage inputBikeCodePage = controller.getInputBikeCodePage();
        rentBikeStage = inputBikeCodePage.getInputBikeCodeStage();
        Main.home.close();
        rentBikeStage.show();
    }

    @FXML
    public void returnBikeClick() throws IOException {
        ChooseBikeDockPage chooseBikeDockPage = controller.getChooseBikeDockPage();
        returnBikeStage = chooseBikeDockPage.getChooseBikeDockStage();
        Main.home.close();
        returnBikeStage.show();
    }
    @FXML
    public void Exit() throws IOException {
        Main.home.close();
    }

    public void setController(EcoMainController controller) {
        this.controller = controller;
    }
}


