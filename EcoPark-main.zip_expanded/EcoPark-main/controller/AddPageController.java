package controller;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import generalBikeSubsystem.generalBikeAPI.GeneralBikeManager;
public class AddPageController  implements Initializable{
	@FXML private ChoiceBox<String> choiceBox;
	@FXML private Label battery;
	@FXML private Label loadCycle;
	@FXML private Label time;
	@FXML private TextField batteryField;
	@FXML private TextField loadCycleField;
	@FXML private TextField timeField;
	@FXML private TextField nameField;
	@FXML private TextField weightField;
	@FXML private TextField licenseField;
	@FXML private DatePicker manufacturedDateField;
	@FXML private TextField dockIDField;
	
	public HashMap<String, String> BikeInfo = new HashMap<String, String>();
	public static Scene addPagePane;
	public AddPageController() {
		// TODO Auto-generated constructor stub
		
	}
	public void createAddPagePane() throws IOException {
		Parent addPageParent = FXMLLoader.load(getClass().getResource("../fxml_view/createBike/CreateBike.fxml"));
		AddPageController.addPagePane = new Scene(addPageParent);
	}
	
	
	//  event when click create button: add admin's input to object hashmap BikeInfo
	public void fireAddEvent(ActionEvent event) throws IOException, NumberFormatException, ParseException {
		BikeInfo.put("Name", nameField.getText());
		BikeInfo.put("Weight", weightField.getText());
		BikeInfo.put("Manufactured Date", manufacturedDateField.getValue().toString());
		BikeInfo.put("License Plate", licenseField.getText());
		BikeInfo.put("Type", choiceBox.getValue());
		BikeInfo.put("DockId", dockIDField.getText());
		if(choiceBox.getValue().toString() == "EBike" ) {
			
			BikeInfo.put("Battery Percent", batteryField.getText());
			BikeInfo.put("Load Cycle", loadCycleField.getText());
			BikeInfo.put("Estimate time left", timeField.getText());
		}
		validation();
	}
	
	public void validation() throws NumberFormatException, ParseException  {
		GeneralBikeManager manager = new GeneralBikeManager();
		if(nameField.getText().isEmpty() || nameField.getText().length() > 30) 
			errorMessage("name field is empty or length is larger than 30 character");
		else if(!weightField.getText().matches("[1-9]{1,2}(\\.[0-9]*)?") || 
				Double.parseDouble(weightField.getText()) < 0 || 
				Double.parseDouble(weightField.getText()) > 150)
			errorMessage("weight is empty, too light or too heavy");
		else if(manufacturedDateField.getValue() == null) 
			errorMessage("Manufactured date must not empty");
		else if(licenseField.getText().isEmpty()) 
			errorMessage("New bike need a license plate");
		else if(choiceBox.getValue().toString() == "EBike") {
			if(!batteryField.getText().matches("[0-9]{1,3}(\\.[0-9]*)?") || Double.parseDouble(batteryField.getText()) < 0 || Double.parseDouble(batteryField.getText()) > 100) 
				errorMessage("Battery percent must be in range from 0% to 100%");
			else if(!loadCycleField.getText().matches("^\\d+$") || Integer.valueOf(loadCycleField.getText()) < 0) 
				errorMessage("Load cycle must be a integer larger than zero");
			else if(timeField.getText().isEmpty() || checkdate(timeField.getText()) == false)
				errorMessage("Estimate time field must be in 'hh:mm:ss' format");
			else if(manager.checkBikeExist(licenseField.getText()) == true) 
				errorMessage("Bike is existed");
			else {
				manager.createBike(BikeInfo);
				successMessage();
			}
		}
		else if(manager.checkBikeExist(licenseField.getText()) == true) 
			errorMessage("Bike is existed");
		else {
			manager.createBike(BikeInfo);
			successMessage();
		}
		
		
	
		
	}
	
	public void errorMessage(String content) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error message");
		alert.setHeaderText("Can not create bike ");
		alert.setContentText(content);
		alert.showAndWait();
	}
	
	public void successMessage() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Success message");
		alert.setContentText("Bike was created");
		alert.showAndWait();
	}
	public  boolean checkdate(String dt1)
    {
        SimpleDateFormat df1=new SimpleDateFormat("hh:mm:ss");
        System.out.println(df1.toPattern());
        df1.setLenient(false);
        try {
            System.out.println(df1.parse(dt1));
        } catch (ParseException e) {

            return false;
        }
        return true;
    }

	
	/*
	 * public void message() { if(validation() == 1) { Alert alert = new
	 * Alert(AlertType.INFORMATION); alert.setTitle("Succesful message");
	 * alert.setContentText("Add new bike to the database successfully!");
	 * 
	 * alert.showAndWait(); } else if(validation() == 2){ Alert alert = new
	 * Alert(AlertType.INFORMATION); alert.setTitle("Error message");
	 * alert.setContentText("Has a invalid input!");
	 * 
	 * alert.showAndWait(); }
	 * 
	 * else { Alert alert = new Alert(AlertType.INFORMATION);
	 * alert.setTitle("Error message"); alert.setContentText("Bike existed");
	 * 
	 * alert.showAndWait(); }
	 * 
	 * }
	 */

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		choiceBox.getItems().addAll("Bike", "EBike", "TwinBike");
		choiceBox.setValue("");
		choiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				// TODO Auto-generated method stub
				//System.out.println(choiceBox.getItems().get((Integer) arg2));
				
				//set text field visiable or not depend on type bike in choice box
				/*
				 * if(choiceBox.getValue().toString() != "EBike") { battery.setVisible(false);
				 * loadCycle.setVisible(false); time.setVisible(false);
				 * batteryField.setVisible(false); loadCycleField.setVisible(false);
				 * timeField.setVisible(false);
				 * 
				 * } else { battery.setVisible(true); loadCycle.setVisible(true);
				 * time.setVisible(true); batteryField.setVisible(true);
				 * loadCycleField.setVisible(true); timeField.setVisible(true); }
				 */
			}
			
		});
		
		  
		 
		
	} 
	
	
	
	
}
