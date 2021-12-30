package fxml_view;

import controller.EcoMainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class EcoMainPage implements Initializable {
    public static Stage rentBikeStage;
    public static Integer userId;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void rentBikeClick() throws IOException {
        EcoMainController ecoMainController = new EcoMainController();
        rentBikeStage = ecoMainController.getInputBikeCodePage();
        Main.home.close();
        rentBikeStage.show();
    }
}