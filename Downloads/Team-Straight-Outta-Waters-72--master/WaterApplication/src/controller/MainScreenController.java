package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import model.WaterSourceReport;

/**
 * The controller for the root/main window
 *
 */
public class MainScreenController {

    /** reference back to mainApplication if needed */
    private Main mainApplication;

    @FXML
    public Button loadReportMS;

    @FXML
    public Button submitReportMS;

    @FXML
    public ComboBox chooseReportMS;

    @FXML
    public Button viewMap;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(Main main) {
        mainApplication = main;
    }

    /**
     * Close menu item event handler
     */
    @FXML
    private void handleCloseMenu() {
        System.exit(0);

    }

    @FXML
    private void handleLogOut() {
        mainApplication.showWelcomeScreen();
    }

    @FXML
    private void handleEditProfile() {
        mainApplication.showProfileScreen();
    }

    @FXML
    private void handleSubmitNewReport() {
        mainApplication.showWaterSourceReport();
    }

    @FXML
    private void displayReports() {
        chooseReportMS.getItems().clear();
        chooseReportMS.getItems().addAll(mainApplication.getSourceReports());
        changeRowsToDisplay();

    }

    @FXML
    private void handleLoadReport() {
        mainApplication.showWaterSourceReportView((WaterSourceReport) chooseReportMS.getValue());
    }

    @FXML
    private void handleViewMap() {
        mainApplication.showMapView();
    }
    /**
     * This will change the number of rows that will be displayed by the combobox,
     * the number of reports to displayed will not go above 10.
     */
    private void changeRowsToDisplay() {
        chooseReportMS.hide(); //before you set new visibleRowCount value
        if (mainApplication.getReportNumber() < 10) {
            chooseReportMS.setVisibleRowCount(mainApplication.getReportNumber());
        } else {
            chooseReportMS.setVisibleRowCount(10);
        }
        chooseReportMS.show(); //after you set new visibleRowCount value
    }

}
