package view.rentBike;

import controller.RentBikeController;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import view.bank.InputCardIdPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class GeneralBikeDetailPage implements Initializable {
    private Stage generalBikeDetailPage;
    public static Stage inputCardStage;
    private RentBikeController rentBikeController;
    private String money;

    @FXML
    private Label bikeInfo;

    @FXML
    private ImageView bikeImage;

    public GeneralBikeDetailPage(){

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rentBikeController = new RentBikeController();
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
        String handler;
        for(String key: set){
            handler = String.format("%-30s\t:\t%s\n\n",key,container.get(key));
            if(!key.equals("Image")) {
                stringBuilder.append(handler);
            }
        }
//        this.money = container.get("cost");
        System.out.println(stringBuilder.toString());
        bikeInfo.setText(stringBuilder.toString());
        bikeImage.setImage(new Image(container.get("Image")));
    }

    public void setGeneralBikeDetailPage(Stage generalBikeDetailPage) {
        this.generalBikeDetailPage = generalBikeDetailPage;
    }


    @FXML
    public void returnMain(){
        InputBikeCodePage.generalBikeStage.close();
        Main.home.show();
    }

    @FXML
    public void nextToPay() throws IOException {
        InputCardIdPage inputCardIdPage = rentBikeController.getInputCardIdPage(money);
        Stage stage = inputCardIdPage.getInputCardStage();
        inputCardStage = stage;
        InputBikeCodePage.generalBikeStage.close();
        stage.show();
    }
}
