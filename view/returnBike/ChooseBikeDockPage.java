package view.returnBike;
import controller.*;
import fxml_view.EcoMainPage;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import fxml_view.Main;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import model.*;

import javafx.stage.Stage;

import java.io.IOException;


public class ChooseBikeDockPage implements Initializable{
    private ReturnBikePageController controller;
    public static Stage returnBike;
    
    public void setController(ReturnBikePageController controller) {
        this.controller = controller;
    }

    @FXML
    private Text bikeDock;
    @FXML
    private TextField chooseDock;
    @FXML Text err;

    @FXML
    public void setDockList(){
        List<BikeDock> list = this.controller.getDockList();
        String dockList = "";
        for(BikeDock b : list){
            dockList = dockList + b.getDockId() + ": " + b.getDockName() + "\n";
        }
        bikeDock.setText(dockList);
    }
    @FXML
    public void submitBikeDockId() throws IOException{
        String dockId = chooseDock.getText();
        if (dockId.isBlank()){
            EcoMainPage.returnBikeStage.close();
            err.setText("Mã số bãi xe không được phép để trống !");
            EcoMainPage.returnBikeStage.show();
        } //else if (!controller.checkRented()){
        //     EcoMainPage.returnBikeStage.close();
        //     err.setText("Bạn chưa thuê xe");
        //     EcoMainPage.returnBikeStage.show();
        //     EcoMainPage.returnBikeStage.close();
        //     Main.home.show();
        // } 
        else {
            ReturnBikePageController returnController = new ReturnBikePageController();
            returnBike = returnController.showTransaction();
            EcoMainPage.returnBikeStage.close();
            returnBike.show();
        }
    }
    @FXML
    public void returnEcoMain(){
        EcoMainPage.returnBikeStage.close();
        Main.home.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.controller = new ReturnBikePageController();
        setDockList();
    }
}
