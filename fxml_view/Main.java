package fxml_view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage home;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        home = new Stage();
        home.setTitle("EcoPark RentBike System");
        home.setScene(new Scene(root));
        System.out.println("Welcome to EcoPark RentBike System!");
        home.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
