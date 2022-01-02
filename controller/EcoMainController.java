package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.rentBike.InputBikeCodePage;

import java.io.IOException;

public class EcoMainController {
    public InputBikeCodePage getInputBikeCodePage() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml_view/rentBike/InputBikeCodePage.fxml"));
        Stage stage = new Stage();
        AnchorPane anchorPane = loader.load();
        stage.setScene(new Scene(anchorPane));

        InputBikeCodePage inputBikeCodePage = loader.getController();
        inputBikeCodePage.setController(new RentBikeController());
        inputBikeCodePage.setInputBikeCodeStage(stage);
        return inputBikeCodePage;
    }

    public Stage getChooseBikeDockPage() throws IOException {
        Stage stage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/returnBike/BikeDockSelection.fxml"));
        stage.setScene(new Scene(anchorPane));
        return stage;
    }
}
