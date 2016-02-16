package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import cbr.GenerateQuery;
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
	private ListView caseList;

	@FXML
	private Button btn;

	@FXML
	private Label caseNum;

	@FXML
	private TextField diagnosisText;

	@FXML
	private TextField descriptionText;

	@FXML
	private TextField solutionText;

	double hoyde;
	double vekt;
	int alder;
	int iq;
	int numCases;

	public static final ObservableList casesDisplay = FXCollections.observableArrayList();

	@FXML
	public void handleSliderChange() {
		sliderHoyde.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				hoydeNum.textProperty().setValue(String.valueOf((int) sliderHoyde.getValue()));
			}
		});

		sliderVekt.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				vektNum.textProperty().setValue(String.valueOf((int) sliderVekt.getValue()));
			}
		});

		sliderAlder.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				alderNum.textProperty().setValue(String.valueOf((int) sliderAlder.getValue()));
			}
		});

		sliderIq.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				iqNum.textProperty().setValue(String.valueOf((int) sliderIq.getValue()));
			}
		});

		sliderNumCases.valueProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				numCasesNum.textProperty().setValue(String.valueOf((int) sliderNumCases.getValue()));
			}
		});
	}

	@FXML
	public void handleButtonAction(ActionEvent e) {

		// generate query
		hoyde = Double.parseDouble(hoydeNum.getText());
		vekt = Double.parseDouble(vektNum.getText());
		alder = Integer.parseInt(alderNum.getText());
		iq = Integer.parseInt(iqNum.getText());
		numCases = Integer.parseInt(numCasesNum.getText());
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
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
