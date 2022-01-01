package view.returnBike;
import controller.*;
import fxml_view.EcoMainPage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
public class ReturnBikePage implements Initializable{
    private ReturnBikePageController controller;
    
    @FXML
    private Text transaction;
    public void setController(ReturnBikePageController controller) {
        this.controller = controller;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.controller = new ReturnBikePageController();
        setTransaction();
    }
    @FXML
    public void setTransaction(){
        String trans = controller.getTransactionInfor();
        transaction.setText(trans);
    }

    
}
