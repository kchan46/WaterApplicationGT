package controller;

import fxapp.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Account;

/**
 * Created by PT3 on 10/1/2016.
 */
public class ProfileScreenController {

    private Main mainApplication;

    @FXML
    public Button savePS;

    @FXML
    public Button cancelPS;

    @FXML
    public TextField namePS;

    @FXML
    public TextField usernamePS;

    @FXML
    public TextField passwordPS;

    @FXML
    public TextField titlePS;

    @FXML
    public TextField homeAddressPS;

    @FXML
    public TextField emailPS;

    public void setMainApp(Main main) {
        mainApplication = main;
    }

    @FXML
    private void handleEditProfile() {
        int user = mainApplication.getUser();
        if (usernamePS.getText() != null) {
            // this mess will directly edit the current user within the database.
            mainApplication.getDatabase().get(user).setName(namePS.getText());
        }
        if (usernamePS.getText() != null && usernamePS.getText().length() > 1) {
            mainApplication.getDatabase().get(user).setUser(usernamePS.getText());
        }
        if (passwordPS.getText() != null && passwordPS.getText().length() > 1) {
            mainApplication.getDatabase().get(user).setPass(passwordPS.getText());
        }
        if (titlePS.getText() != null) {
            mainApplication.getDatabase().get(user).setTitle(titlePS.getText());
        }
        if (homeAddressPS.getText() != null) {
            mainApplication.getDatabase().get(user).setAddress(homeAddressPS.getText());
        }
        if (emailPS.getText() != null) {
            mainApplication.getDatabase().get(user).setEmail(emailPS.getText());
        }

        namePS.setText(null);
        usernamePS.setText(null);
        passwordPS.setText(null);
        titlePS.setText(null);
        homeAddressPS.setText(null);
        emailPS.setText(null);
        mainApplication.showMainScreen();
    }

    @FXML
    private void handleCancelEditProfile() {
        namePS.setText(null);
        usernamePS.setText(null);
        passwordPS.setText(null);
        titlePS.setText(null);
        homeAddressPS.setText(null);
        emailPS.setText(null);
        mainApplication.showMainScreen();
    }
}
