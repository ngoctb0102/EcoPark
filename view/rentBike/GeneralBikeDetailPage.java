package view.rentBike;

import controller.RentBikeController;
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
        generalBikeDetailPage = new Stage();
        try{
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../../fxml_view/rentBike/GeneralBikeDetailPage.fxml"));
            generalBikeDetailPage.setScene(new Scene(anchorPane));
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bikeInfo.setText("");
    }

    public void setController(RentBikeController rentBikeController) {
        this.rentBikeController = rentBikeController;
    }

    public Stage getGeneralBikeDetailPage() {
        return generalBikeDetailPage;
    }

    public Map<String,String> getBikeDetail(String bikeCode){
        return rentBikeController.getBikeDetail(bikeCode);
    }

    public void display(String bikeCode){
        HashMap<String,String> container = (HashMap<String, String>) getBikeDetail(bikeCode);
        bikeImage.setImage(new Image(container.get("image")));
        StringBuilder stringBuilder = new StringBuilder();
        Set<String> set = container.keySet();
        for(String key: set){
            stringBuilder.append(key+"  :   "+container.get(key)+"\n");
        }
        bikeInfo.setText(stringBuilder.toString());
    }


}
