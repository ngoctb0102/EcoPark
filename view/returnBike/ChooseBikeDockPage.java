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
import view.bank.InputCardIdPage;
import view.bank.InputCardIdPage;
import controller.PaymentController;
import view.bank.finalPayment.ReturnPayment;



public class ChooseBikeDockPage implements Initializable{
    private ReturnBikePageController controller;
    public static Stage returnBike;
    public static Stage inputCardStage;
    private PaymentController paymentController = new PaymentController();
    public void setController(ReturnBikePageController controller) {
        this.controller = controller;
    }
    public void setPaymentController(PaymentController paymentController) {
        this.paymentController = paymentController;
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
            err.setText("Mã số bãi xe không được phép để trống !");
            EcoMainPage.returnBikeStage.show();
        } 
        else if (controller.checkRented() == 0){
            EcoMainPage.returnBikeStage.close();
            err.setText("Bạn chưa thuê xe");
            EcoMainPage.returnBikeStage.show();
            // EcoMainPage.returnBikeStage.close();
            // Main.home.show();
        } else if(checkDockId(dockId) == false){
            EcoMainPage.returnBikeStage.close();
            err.setText("Bạn nhập sai bãi xe, mời nhập lại");
            EcoMainPage.returnBikeStage.show();
        }
        else {
            // ReturnBikePageController returnController = new ReturnBikePageController();
//            ReturnPayment rentPayment = new ReturnPayment();
//            rentPayment.setBikeCode(this.controller.getRentHis().getBikeCode());
//            rentPayment.setUserId(this.controller.userId);
            System.out.println(this.controller.getDeposit());
            System.out.println(this.controller.calculateTotalMoney());
            InputCardIdPage inputCardIdPage = paymentController.getInputCardIdPage(String.valueOf(this.controller.calculateTotalMoney()),this.controller.getDeposit());
            Stage stage = inputCardIdPage.getInputCardStage();
            inputCardStage = stage;
            EcoMainPage.returnBikeStage.close();
            stage.show();
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
