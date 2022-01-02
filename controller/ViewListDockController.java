package controller;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewListDockController {
	public Stage getMainPage() throws IOException {
    	Stage stage = new Stage();
        AnchorPane Pane = FXMLLoader.load(getClass().getResource("../fxml_view/MainScreen.fxml"));
        stage.setScene(new Scene(Pane));
        return stage;
    }
	public Stage getdetaildock() throws IOException {
    	Stage stage = new Stage();
        AnchorPane Pane = FXMLLoader.load(getClass().getResource("../fxml_view/listdock/DetailDock.fxml"));
        stage.setScene(new Scene(Pane));
        return stage;
    }
	public Stage exitPrj() throws IOException {
    	Stage stage = new Stage();
        System.exit(0);
        return stage;
    }
}
