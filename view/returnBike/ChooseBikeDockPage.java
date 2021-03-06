package view.returnBike;
import controller.*;
import fxml_view.EcoMainPage;
import javafx.fxml.*;
import javafx.scene.control.TextField;
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
    public Stage chooseBikeDockPage;
    public void setController(ReturnBikePageController controller) {
        this.controller = controller;
    }
    public void setChooseBikeDockStage(Stage chooseBikeDockPage) {
        this.chooseBikeDockPage = chooseBikeDockPage;
    }
    public Stage getChooseBikeDockStage() {
        return chooseBikeDockPage;
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
    public boolean checkDockId(String dockId){
        List<BikeDock> list = this.controller.getDockList();
        for(BikeDock b : list){
            if(b.getDockId().equalsIgnoreCase(dockId)){
                return true;
            }
        }
        return false;
    }
    @FXML
    public void submitBikeDockId() throws IOException{
        String dockId = chooseDock.getText();
        if (dockId.isBlank()){
            EcoMainPage.returnBikeStage.close();
            err.setText("DockId cannot be empty !");
            EcoMainPage.returnBikeStage.show();
        } 
        else if (controller.checkRented() == 0){
            EcoMainPage.returnBikeStage.close();
            err.setText("You haven't rent a bike yet !");
            EcoMainPage.returnBikeStage.show();
            // EcoMainPage.returnBikeStage.close();
            // Main.home.show();
        } else if(checkDockId(dockId) == false){
            EcoMainPage.returnBikeStage.close();
            err.setText("Inputted dockID not exist, please input again !");
            EcoMainPage.returnBikeStage.show();
        }
        else {
            Stage stage = this.controller.createReturnBikePage().getReturnBikeStage();
            EcoMainPage.returnBikeStage.close();
            stage.show();
            // Stage stage = this.controller.inputCardIdPage().getInputCardStage();
            // inputCardStage = stage;
            // EcoMainPage.returnBikeStage.close();
            // stage.show();
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
