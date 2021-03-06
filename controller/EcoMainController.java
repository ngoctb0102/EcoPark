package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.rentBike.InputBikeCodePage;
import view.returnBike.ChooseBikeDockPage;

import java.io.IOException;

public class EcoMainController {
    public InputBikeCodePage getInputBikeCodePage() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml_view/rentBike/InputBikeCodePage.fxml"));
        Stage stage = new Stage();
        AnchorPane anchorPane = loader.load();
        stage.setScene(new Scene(anchorPane));

        InputBikeCodePage inputBikeCodePage = loader.getController();
        inputBikeCodePage.setInputBikeCodeStage(stage);
        inputBikeCodePage.setController(new RentBikeController());
        return inputBikeCodePage;
    }

    public ChooseBikeDockPage getChooseBikeDockPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml_view/returnBike/BikeDockSelection.fxml"));
        Stage stage = new Stage();
        AnchorPane anchorPane = loader.load();
        stage.setScene(new Scene(anchorPane));

        ChooseBikeDockPage chooseBikeDockPage = loader.getController();
        chooseBikeDockPage.setChooseBikeDockStage(stage);
        chooseBikeDockPage.setController(new ReturnBikePageController());
        return chooseBikeDockPage;
        
    }
    
    public Stage getAdminPage() throws IOException {
    	Stage stage = new Stage();
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/createBike/AdminHome.fxml"));
        stage.setScene(new Scene(anchorPane));
		return stage;
    	
    }
    
    public Stage getListDockPage() throws IOException {
    	Stage stage = new Stage();
    	Pane anchorPane = FXMLLoader.load(getClass().getResource("../fxml_view/listdock/SearchListDock.fxml"));
    	stage.setScene(new Scene(anchorPane));
    	return stage;
    }
}
