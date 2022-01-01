package view.returnBike;
import controller.*;
import fxml_view.EcoMainPage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;
import fxml_view.Main;
import view.returnBike.*;
public class ReturnBikePage implements Initializable{
    public static Stage returnBikeStage;
    private ReturnBikePageController controller;
    
    @FXML
    private Text transaction;
    public void setController(ReturnBikePageController controller) {
        this.controller = controller;
    }
    public void setTransaction(){
        String trans = this.controller.getTransactionInfor();
        // System.out.println(trans);
        transaction.setText(trans);
    }
    @FXML
    public void returnEcoMain(){
        ChooseBikeDockPage.returnBike.close();
        Main.home.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.controller = new ReturnBikePageController();
        setTransaction();
    }
    
}
