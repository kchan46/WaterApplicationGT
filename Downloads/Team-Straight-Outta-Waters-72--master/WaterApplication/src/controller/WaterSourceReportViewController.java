package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import model.WaterSourceReport;

/**
 * Created by Armando on 10/13/2016.
 */
public class WaterSourceReportViewController {

    private Main mainApplication;

    @FXML
    public ListView<String> listViewWSR;

    @FXML
    public Button cancelButton;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(Main main) {
        mainApplication = main;
    }

    /**
     * allow the current report data to be changed
     * @param report whose data will be reflected in the list view;
     */
    public void setSourceReport(WaterSourceReport report) {
        listViewWSR.getItems().clear();
        listViewWSR.getItems().addAll(Integer.toString(report.getReportNumber()), report.getWaterLocation(),
                report.getWaterType(), report.getWaterCondition(), report.getReporterName());
    }

    @FXML
    private void cancelView() {
        mainApplication.showMainScreen();
    }
}
