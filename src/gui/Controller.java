package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import cbr.GenerateQuery;
import dataacquisition.RunLineReadThread;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

	public static long pause = 1000000000;
	
	RunLineReadThread R1 = new RunLineReadThread("Thread 1");

	@FXML
	private Slider sliderNumCases;

	@FXML
	private Label numCasesNum;

	@FXML
	private ListView caseList;

	@FXML
	private Button btn;

	@FXML
	private Button startRet;

	@FXML
	private Label caseNum;

	@FXML
	private TextField diagnosisText;

	@FXML
	private TextField descriptionText;

	@FXML
	private TextField solutionText;

	public static double hoyde;
	public static double vekt;
	public static int alder;
	public static int iq;
	static int numCases;

	private ObservableList casesDisplay = FXCollections.observableArrayList();

	@FXML
	public void handleSliderChange() {
		sliderNumCases.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				numCasesNum.textProperty().setValue(String.valueOf((int) sliderNumCases.getValue()));
			}
		});
	}

	@FXML
	public void handleButtonAction(ActionEvent e) {		
		numCases = 3; //Integer.parseInt(numCasesNum.getText());
		
		GenerateQuery myQuery = new GenerateQuery(hoyde, vekt, alder, iq, numCases);

		// generate objects to display in caseList
		casesDisplay.clear();
		for (int i = 0; i < cbr.Recommender.caseObjects.size(); i++) {
			casesDisplay.add(cbr.Recommender.caseObjects.get(i));
		}
		caseList.setItems(casesDisplay);
		cbr.Recommender.caseObjects.clear();

		String caseNumRetained = cbr.Recommender.caseNumber;
		caseNumRetained = caseNumRetained.replaceAll("\\D+", "");

		int caseInteger = Integer.parseInt(caseNumRetained);

		caseNum.textProperty().setValue("Case #" + caseNumRetained);

		// Fill in descriptive info
		solution.Description.add();

		diagnosisText.setText(solution.Description.description.get(caseInteger).get(1));
		descriptionText.setText(solution.Description.description.get(caseInteger).get(2));
		solutionText.setText(solution.Description.description.get(caseInteger).get(3));
		
		R1.resume();
	}

	public void startLineReader(ActionEvent e) {
		R1.start();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
