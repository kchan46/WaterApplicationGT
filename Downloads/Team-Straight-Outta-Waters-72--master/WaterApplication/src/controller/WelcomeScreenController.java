package controller;


import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class WelcomeScreenController {

    @FXML
    public Button WSLogin;

    @FXML
    public Button WSRegister;

    //WSLogin.setOnAction(new EventHandler<ActionEvent>() {
    private Main mainApplication;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(Main main) {
        mainApplication = main;
    }

    @FXML
    private void handleLogIn() {
        mainApplication.showLogin();

    }

    @FXML
    private void handleRegister() {
        mainApplication.showRegisterScreen();
    }
}