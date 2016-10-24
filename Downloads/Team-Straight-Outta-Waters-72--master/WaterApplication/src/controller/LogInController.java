package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Account;
import model.User;

/**
 * Created by Pranshav on 9/22/2016.
 */
public class LogInController {

    private Main mainApplication;

    @FXML
    public TextField userNameField;

    @FXML
    public TextField passwordField;

    @FXML
    public Button LISLogIn;

    @FXML
    public Button LISCancel;


    /**
     * allow for calling back to the main application code if necessary
     * @param main   the reference to the FX Application instance
     * */
    public void setMainApp(Main main) {
        mainApplication = main;
    }

    @FXML
    private void handleLoginAttempt() throws Exception {
        // create a temp account that will be used to check user/pass.
        Account tempAccount = new User(null, userNameField.getText(), passwordField.getText());
        // if the user is in the database, then it will return the corresponding index, else -1
        int index = mainApplication.getDatabase().indexOf(tempAccount);
        if (index != -1 && tempAccount.getUser() != null && tempAccount.getPass() != null && tempAccount.getUser().length() > 0
                && tempAccount.getPass().length() > 0) {
            mainApplication.setUser(index);
            // TODO: Remove: this is only for debugging purposes.
            Account user = mainApplication.getDatabase().get(index);
            System.out.println("Welcome, " + user.getName());
            System.out.println("    " + user.getUser() + "\n    " + user.getPass() + "\n    " + user.getEmail());
            System.out.println("    " + user.getAddress() + "\n    " + user.getTitle());
            System.out.println("    Account Type: " + user.getType());
            mainApplication.showMainScreen();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login failed");
            alert.setHeaderText("Error");
            alert.setContentText("Username or Password was invalid.");
            alert.showAndWait();
        }
        passwordField.setText(null);
        userNameField.setText(null);
    }

    @FXML
    private void handleCancelLogin() throws Exception {
        passwordField.setText(null);
        userNameField.setText(null);
        mainApplication.showWelcomeScreen();
    }

}
