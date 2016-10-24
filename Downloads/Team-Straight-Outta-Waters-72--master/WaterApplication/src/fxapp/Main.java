package fxapp;


//import controller.CourseOverviewController;
import controller.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Account;
import model.Facade;
import model.WaterSourceReport;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//import controller.StudentEditController;
//import model.Student;


/**
 * Main application class.  Some code reused from the code makery tutorial
 *
 * This class handles all the scene switching to reuse the main stage.
 *
 */
public class Main extends Application {
    /**  the java logger for this class */
    private static final Logger LOGGER =Logger.getLogger("MainFXApplication");

    /** Loads FXML files */
    private FXMLLoader fxmlLoader;

    /** the main container for the application window */
    private Stage mainScreen;

    MapController controller;

    private Scene welcomeScene;
    private Scene loginScene;
    private Scene mainScene;
    private Scene registrationScene;
    private Scene profileScene;
    private Scene waterSourceReportScene;
    private Scene waterSourceReportViewScene;
    private Scene mapScene;

    // Make changes to the controller
    WaterSourceReportViewController waterSourceReportViewController;

    /** ArrayList that holds various Acounts */
    private ArrayList<Account> database = new ArrayList<>();

    /** Active Account */
    private int user;

    /** the main layout for the main window */
    private Parent rootLayout;

    private int reportNumber = 1;

    // private ObservableList<WaterSourceReport> sourceReports = FXCollections.observableArrayList();
    private ArrayList<WaterSourceReport> sourceReports = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        mainScreen = primaryStage;
        initRoot(mainScreen);
    }

    /**
     * return a reference to the main window stage
     * @return reference to main stage
     * */
    public Stage getMainScreen() { return mainScreen;}


    /**
     * Initialize the main screen for the application.  Most other views will be shown in this screen.
     *
     * @param mainScreen  the main Stage window of the application
     */
    private void initRoot(Stage mainScreen) {
        try {
            // Load welcome screen layout from fxml file. & Give the controller access to the main app.
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("../view/WelcomeScreen.fxml"));
            rootLayout = fxmlLoader.load();
            WelcomeScreenController controller = fxmlLoader.getController();
            controller.setMainApp(this);

            // load login screen layout from fxml file & create login Controller
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("../view/LoginScreen.fxml"));
            loginScene = new Scene(fxmlLoader.load());
            LogInController logInController = fxmlLoader.getController();
            logInController.setMainApp(this);

            // load main screen layout from fxml file & create login Controller
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("../view/ApplicationWindow.fxml"));
            mainScene = new Scene(fxmlLoader.load());
            MainScreenController mainScreenController = fxmlLoader.getController();
            mainScreenController.setMainApp(this);

            // load register Screen layout and 
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("../view/RegistrationScreen.fxml"));
            registrationScene = new Scene(fxmlLoader.load());
            RegistrationScreenController registrationScreenController = fxmlLoader.getController();
            registrationScreenController.setMainApp(this);

            // load profile Screen layout
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("../view/ProfileScreen.fxml"));
            profileScene = new Scene(fxmlLoader.load());
            ProfileScreenController profileScreenController = fxmlLoader.getController();
            profileScreenController.setMainApp(this);

            // load create water source report layout
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("../view/WaterSourceReport.fxml"));
            waterSourceReportScene = new Scene(fxmlLoader.load());
            WaterSourceReportController waterSourceReportController = fxmlLoader.getController();
            waterSourceReportController.setMainApp(this);

            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("../view/WaterSourceReportViewScreen.fxml"));
            waterSourceReportViewScene = new Scene(fxmlLoader.load());
            waterSourceReportViewController = fxmlLoader.getController();
            waterSourceReportViewController.setMainApp(this);

            //load map screen


            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(Main.class.getResource("../view/mapview.fxml"));
            mapScene = new Scene(fxmlLoader.load());
            MapController mapcontroller = fxmlLoader.getController();
            mapcontroller.setMainApp(this);


            // Set the Main App title
            mainScreen.setTitle("Welcome Screen");

            // Show the scene containing the root layout.
            welcomeScene = new Scene(rootLayout);
            mainScreen.setScene(welcomeScene);
            mainScreen.show();



        } catch (Exception e) {
            //error on load, so log it
            LOGGER.log(Level.SEVERE, "Something Went Wrong!");
            e.printStackTrace();
        }
    }

    public void showLogin() {
        mainScreen.setTitle("Login");
        mainScreen.setScene(loginScene);
        mainScreen.show();
    }

    public void showMainScreen() {
        mainScreen.setTitle("Main Application");
        mainScreen.setScene(mainScene);
        mainScreen.show();
    }

    public void showWelcomeScreen() {
        mainScreen.setScene(welcomeScene);
        mainScreen.sizeToScene(); //new Scene(rootLayout, 700, 45
        mainScreen.show();
    }

    public void showRegisterScreen() {
        mainScreen.setTitle("Registration Screen");
        mainScreen.setScene(registrationScene);
        mainScreen.sizeToScene();
        mainScreen.show();
    }

    public void showProfileScreen() {
        mainScreen.setTitle("Profile Screen");
        mainScreen.setScene(profileScene);
        mainScreen.sizeToScene();
        mainScreen.show();
    }

    public void showWaterSourceReport() {
        mainScreen.setTitle("Water Source Report");
        mainScreen.setScene(waterSourceReportScene);
        mainScreen.sizeToScene();
        mainScreen.show();
    }

    public void showWaterSourceReportView(WaterSourceReport report) {
        waterSourceReportViewController.setSourceReport(report); // change the data displayed in report
        mainScreen.setTitle("Water Source Report");
        mainScreen.setScene(waterSourceReportViewScene);
        mainScreen.sizeToScene();
        mainScreen.show();
    }

    public void showMapView() {
        mainScreen.setTitle("Water Sources");
        mainScreen.setScene(mapScene);
        mainScreen.sizeToScene();
        mainScreen.show();
    }

    /**
     * Located the index of the user in the database and saves that index.
     * @param user to find
     */
    public void setUser(Account user) {
        // this.user = user;
        this.user = database.indexOf(user);
    }

    /**
     * If the user index is already known, pass it through here.
     * @param i the index in the database of the current user.
     */
    public void setUser(int i) {
        this.user = i;
    }

    /**
     * Return the index number of the user in the database.
     * @return index of user in the array list.
     */
    public int getUser() {
        return user;
    }

    /**
     * Return the Stage so that it can be edited elsewhere.
     * @return Stage
     */

    public Stage getStage() {
        return mainScreen;
    }

    public ArrayList<Account> getDatabase() {
        return database;
    }

    public ArrayList<WaterSourceReport> getSourceReports() {
        return sourceReports;
    }

    public int getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(int num) {
        this.reportNumber = num;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
