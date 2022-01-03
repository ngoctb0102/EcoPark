package view.rentBike;

import controller.PaymentController;
import controller.RentBikeController;
import fxml_view.EcoMainPage;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import view.bank.InputCardIdPage;
import view.bank.finalPayment.RentPayment;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class GeneralBikeDetailPage implements Initializable {
    private Stage generalBikeDetailStage;
    private RentBikeController rentBikeController;
    private PaymentController paymentController;
    private String money;
    private String bikeCode;

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

    public void setPaymentController(PaymentController paymentController) {
        this.paymentController = paymentController;
    }

    public Stage getGeneralBikeDetailStage() {
        return generalBikeDetailStage;
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
        this.money = container.get("Cost/Deposit (VND)");
        this.bikeCode = container.get("License Plate");
        System.out.println(stringBuilder.toString());
        bikeInfo.setText(stringBuilder.toString());
        bikeImage.setImage(new Image(container.get("Image")));
    }

    public void setGeneralBikeDetailStage(Stage generalBikeDetailStage) {
        this.generalBikeDetailStage = generalBikeDetailStage;
    }


    @FXML
    public void returnMain(){
        this.generalBikeDetailStage.close();
        Main.home.show();
    }

    @FXML
    public void nextToPay() throws IOException {
        InputCardIdPage inputCardIdPage = paymentController.getInputCardIdPage(this.money,0);
        Stage stage = inputCardIdPage.getInputCardStage();
        this.generalBikeDetailStage.close();
        stage.show();
    }
}
