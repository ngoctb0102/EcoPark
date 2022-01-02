package fxml_view;

import controller.EcoMainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage home;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainScreen.fxml"));
        home = new Stage();
        Parent root = loader.load();
        home.setScene(new Scene(root));
        home.setTitle("EcoPark RentBike System");
        EcoMainPage ecoMainPage = loader.getController();
        ecoMainPage.setController(new EcoMainController());
        System.out.println("Welcome to EcoPark RentBike System!");
        home.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
