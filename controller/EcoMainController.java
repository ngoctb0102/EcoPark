package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.rentBike.InputBikeCodePage;

import java.io.IOException;

public class EcoMainController {
    public InputBikeCodePage getInputBikeCodePage() {
        return new InputBikeCodePage();
    }
    public Stage getChooseBikeDockPage() throws IOException {
        Stage stage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/returnBike/BikeDockSelection.fxml"));
        stage.setScene(new Scene(anchorPane));
        return stage;
    }
}
