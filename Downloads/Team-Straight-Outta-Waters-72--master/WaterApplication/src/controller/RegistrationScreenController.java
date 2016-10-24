package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.*;

/**
 * Created by PT3 on 9/29/2016.
 */
public class RegistrationScreenController {

    private Main mainApplication;

    @FXML
    public Button registerButton;

    @FXML
    public Button cancelRegistration;

    @FXML
    public TextField registerNameField;

    @FXML
    public TextField registerUsernameField;

    @FXML
    public TextField registerPasswordField;

    @FXML
    public ComboBox accountPicker;

    @FXML
    public String userCombo;

    @FXML
    public String adminCombo;

    @FXML
    public String managerCombo;

    @FXML
    public String workerCombo;

    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(Main main) {
        mainApplication = main;
    }

    @FXML
    private void handleRegister() {
        if (registerUsernameField.getText() != null && registerPasswordField.getText() != null && registerUsernameField.getText().length() > 0 && registerPasswordField.getText().length() > 0) {
            if (accountPicker.getValue() == userCombo) {
                User user = new User(registerNameField.getText(), registerUsernameField.getText(), registerPasswordField.getText());
                mainApplication.getDatabase().add(user);
                mainApplication.setUser(user);
            }
            if (accountPicker.getValue() == managerCombo) {
                Manager manager = new Manager(registerNameField.getText(), registerUsernameField.getText(), registerPasswordField.getText());
                mainApplication.getDatabase().add(manager);
                mainApplication.setUser(manager);
            }
            if (accountPicker.getValue() == adminCombo) {
                Admin admin = new Admin(registerNameField.getText(), registerUsernameField.getText(), registerPasswordField.getText());
                mainApplication.getDatabase().add(admin);
                mainApplication.setUser(admin);
            }
            if (accountPicker.getValue() == workerCombo) {
                Worker worker = new Worker(registerNameField.getText(), registerUsernameField.getText(), registerPasswordField.getText());
                mainApplication.getDatabase().add(worker);
                mainApplication.setUser(worker);
            }
            mainApplication.showMainScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration Failed");
            alert.setHeaderText("Error");
            alert.setContentText("Username or Password was invalid.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleCancelRegistration() throws Exception {
        registerNameField.setText(null);
        registerUsernameField.setText(null);
        registerPasswordField.setText(null);
        mainApplication.showWelcomeScreen();
    }
}
