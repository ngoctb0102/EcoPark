package view.listdock;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controller.ViewListDockController;
import fxml_view.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ListDockPage implements Initializable{
	 private Stage listDockPage;
	 private ViewListDockController viewListDockController;
	 private Stage returnMainPage;
	 private Stage exitPage;
	
	 public ListDockPage(){

	    }
	 public Stage getListDockPage() {
	        return listDockPage;
	    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		viewListDockController = new ViewListDockController();
	}
	public void setController(ViewListDockController viewListDockController) {
        this.viewListDockController = viewListDockController;
    }
	@FXML
	public void returnMenu() throws IOException {
		ViewListDockController viewListDockController = new ViewListDockController();
		returnMainPage = viewListDockController.getMainPage();
		Main.home.close();
		returnMainPage.show();
    }
	public void exitPrj() throws IOException {
		ViewListDockController viewListDockController = new ViewListDockController();
		exitPage = viewListDockController.exitPrj();
		Main.home.close();
		exitPage.show();
    }
	public void getDetailDock() throws IOException {
		ViewListDockController viewListDockController = new ViewListDockController();
		returnMainPage = viewListDockController.getdetaildock();
		Main.home.close();
		returnMainPage.show();
    }
}