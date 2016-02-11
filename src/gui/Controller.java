package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;

public class Controller implements Initializable{
	

	@FXML
	private Slider sliderHoyde;
	
	@FXML
	private Slider sliderVekt;
	
	@FXML
	private Slider sliderAlder;
	
	@FXML
	private Slider sliderIq;
	
	@FXML
	private Slider sliderNumCases;
	
	@FXML
	private Label hoydeNum;
	
	@FXML
	private Label alderNum;
	
	@FXML
	private Label vektNum;
	
	@FXML
	private Label iqNum;
	
	@FXML
	private Label numCasesNum;
	
	@FXML
	private ListView<Integer> caseList;
	
	@FXML
	private Button btn;
	
	
	
	@FXML
	public void handleButtonAction(ActionEvent e) {
		hoydeNum.setText("Pekk");
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	

}
