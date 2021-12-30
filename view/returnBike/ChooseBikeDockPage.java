package view.returnBike;
import controller.*;
import fxml_view.EcoMainPage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.BindException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import model.*;

public class ChooseBikeDockPage implements Initializable{
    private ReturnBikePageController controller;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        controller = new ReturnBikePageController();
    }
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
        List<BikeDock> list = controller.getDockList();
        String dockList = "";
        int i = 0;
        for(BikeDock b : list){
            if((i%3) == 0){
                dockList = dockList + "\n";
            }
            dockList = dockList + b.getDockId() + ": " + b.getDockName() + "    ";
        }
        bikeDock.setText(dockList);
    }
    @FXML
    public void submitBikeDockId(){
        String dockId = chooseDock.getText();
        if (dockId.isBlank()){
            EcoMainPage.returnBikeStage.close();
            err.setText("Mã số bãi xe không được phép để trống !");
            EcoMainPage.returnBikeStage.show();
        } else if (!controller.checkRented()){
            EcoMainPage.returnBikeStage.close();
            err.setText("Bạn chưa thuê xe");
            EcoMainPage.returnBikeStage.show();
        } else {
            //
        }
    }

    
}
