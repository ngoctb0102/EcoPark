package fxml_view;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void rentBikeClick() throws IOException {
        rentBikeStage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("./rentBike/InputBikeCodePage.fxml"));
        rentBikeStage.setScene(new Scene(anchorPane));
        Main.home.close();
        rentBikeStage.show();
    }
}
