package fxml_view;

import controller.EcoMainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EcoMainPage implements Initializable {
    public static Stage rentBikeStage;

    public static Stage returnBikeStage;

    public static Integer userId;
    private EcoMainController controller;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void rentBikeClick() throws IOException {
        EcoMainController ecoMainController = new EcoMainController();
        ecoMainController.getInputBikeCodePage();
        Main.home.close();
        rentBikeStage.show();
    }

    public void setController(EcoMainController controller) {
        this.controller = controller;
    }

    @FXML
    public void returnBikeClick() throws IOException {
        EcoMainController ecoMainController = new EcoMainController();
        returnBikeStage = ecoMainController.getChooseBikeDockPage();
        Main.home.close();
        returnBikeStage.show();
    }
}


