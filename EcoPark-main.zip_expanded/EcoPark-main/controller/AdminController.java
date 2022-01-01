package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminController implements Initializable{
	public AddPageController controller;
	public AdminController() {
		// TODO Auto-generated constructor stub
		
		
	}
	public void getAddPage(ActionEvent event) throws IOException {
		controller = new AddPageController();
		controller.createAddPagePane();
		Scene addPagePane = AddPageController.addPagePane;
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(addPagePane);
		window.show();
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
