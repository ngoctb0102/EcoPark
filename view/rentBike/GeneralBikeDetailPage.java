package view.rentBike;

import controller.RentBikeController;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class GeneralBikeDetailPage implements Initializable {
    private Stage generalBikeDetailPage;
    private RentBikeController rentBikeController;

    @FXML
    private Text bikeInfo;

    @FXML
    private ImageView bikeImage;

    public GeneralBikeDetailPage(){
        bikeInfo = new Text();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setController(RentBikeController rentBikeController) {
        this.rentBikeController = rentBikeController;
    }

    public RentBikeController getRentBikeController(){
        return this.rentBikeController;
    }

    public Stage getGeneralBikeDetailPage() {
        return generalBikeDetailPage;
    }

    public Map<String,String> getBikeDetail(String bikeCode){
        return rentBikeController.getBikeDetail(bikeCode);
    }

    public void display(String bikeCode){
        HashMap<String,String> container = (HashMap<String, String>) getBikeDetail(bikeCode);
        //bikeImage.setImage(new Image(container.get("image")));
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> set = container.keySet();
        for(String key: set){
            stringBuilder.append(key+"\t\t:\t"+container.get(key)+"\n");
            System.out.format("%-20s\t:\t%s\n",key,container.get(key));
        }
        bikeInfo.setText(stringBuilder.toString());
    }

    public void setGeneralBikeDetailPage(Stage generalBikeDetailPage) {
        this.generalBikeDetailPage = generalBikeDetailPage;
    }

    public Text getBikeInfo() {
        return bikeInfo;
    }

    @FXML
    public void returnMain(){
        InputBikeCodePage.generalBikeStage.close();
        Main.home.show();
    }

    @FXML
    public void nextToPay(){

    }
}
