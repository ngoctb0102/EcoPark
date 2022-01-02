//package view.listdock;
//
//import java.io.IOException;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import controller.ViewListDockController;
//import fxml_view.Main;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.stage.Stage;
//
//public class DetailDockPage implements Initializable {
//	private Stage detailDockPage;
//	 private ViewListDockController viewListDockController;
//	 private Stage getdetaildock;
//	 
//	 public DetailDockPage(){
//
//	    }
//	 public Stage getDetailDockPage() {
//	        return detailDockPage;
//	    }
//	 @Override
//		public void initialize(URL arg0, ResourceBundle arg1) {
//			viewListDockController = new ViewListDockController();
//		}
//		public void setController(ViewListDockController viewListDockController) {
//	        this.viewListDockController = viewListDockController;
//	    }
//		@FXML
//		public void getDetailDock() throws IOException {
//			ViewListDockController viewListDockController = new ViewListDockController();
//			getdetaildock = viewListDockController.getDetailPage();
//			Main.home.close();
//			getdetaildock.show();
//	    }
//}
