package controller;

import fxapp.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.WaterSourceReport;

/**
 * Created by PT3 on 10/10/2016.
 */
public class WaterSourceReportController {
    private Main mainApplication;
    private ObservableList<WaterSourceReport> options = FXCollections.observableArrayList();

    @FXML
    public Button saveWSR;

    @FXML
    public Button cancelWSR;

    @FXML
    public TextField locationWSR;

    @FXML
    public ComboBox pickWaterTypeWSR;

    @FXML
    public ComboBox pickConditionTypeWSR;



    public void setMainApp(Main main) {
        mainApplication = main;
    }


    @FXML
    private void handleSaveWaterSourceReport() {
        if (locationWSR.getText() != null && pickWaterTypeWSR.getValue() != null && pickConditionTypeWSR.getValue() != null) {
            WaterSourceReport report = new WaterSourceReport(locationWSR.getText(), mainApplication.getReportNumber(), mainApplication.getDatabase().get(mainApplication.getUser()).getName(), pickWaterTypeWSR.getValue().toString(), pickConditionTypeWSR.getValue().toString());
            mainApplication.setReportNumber(mainApplication.getReportNumber() + 1);
            mainApplication.getSourceReports().add(report);
            locationWSR.setText(null);
            pickWaterTypeWSR.setValue(null);
            pickConditionTypeWSR.setValue(null);
            mainApplication.showMainScreen();
        }
    }

    @FXML
    private void handleCancelWaterSourceReport() {
        locationWSR.setText(null);
        pickWaterTypeWSR.setValue(null);
        pickConditionTypeWSR.setValue(null);
        mainApplication.showMainScreen();
    }
}
