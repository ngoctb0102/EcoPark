package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.rentBike.InputBikeCodePage;

import java.io.IOException;

public class EcoMainController {
    public InputBikeCodePage getInputBikeCodePage() throws IOException{
        RentBikeController rentBikeController = new RentBikeController();
        InputBikeCodePage inputBikeCodePage = new InputBikeCodePage();
        inputBikeCodePage.setController(rentBikeController);
        Stage stage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/rentBike/InputBikeCodePage.fxml"));
        stage.setScene(new Scene(anchorPane));

        InputBikeCodePage inputBikeCodePage = loader.getController();
        inputBikeCodePage.setInputBikeCodeStage(stage);
        inputBikeCodePage.setController(new RentBikeController());
        return inputBikeCodePage;
    }

    public Stage getChooseBikeDockPage() throws IOException {
        Stage stage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/returnBike/BikeDockSelection.fxml"));
        stage.setScene(new Scene(anchorPane));
        return stage;
    }
    
    public Stage getListDockPage() throws IOException {
    	Stage stage = new Stage();
        Pane Pane = FXMLLoader.load(getClass().getResource("../fxml_view/listdock/SearchListDock.fxml"));
        stage.setScene(new Scene(Pane));
        return stage;
    }
}
