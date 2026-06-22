package lk.ijse.studentattendancemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class securityController {

    @FXML
    private Button loginBtn;

    @FXML
    private Label pwLbl;

    @FXML
    private TextField pwTxt;

    @FXML
    private AnchorPane securityPane;

    @FXML
    private Label unLbl;

    @FXML
    private TextField unTxt;

    @FXML
    void loginBtnOnAction(ActionEvent event) {
        String username = unTxt.getText();
        String password = pwTxt.getText();

        if (username.equals("admin") && password.equals("admin123")) {
            navigateTo("/lk/ijse/studentattendancemanagementsystem/admin.fxml");
        } 
        else if (username.equals("lecturer") && password.equals("lec123")) {
            navigateTo("/lk/ijse/studentattendancemanagementsystem/lecturer.fxml");
        } 
        
        else {
            showAlert("Login Failed", "Invalid Username or Password. Please try again.");
            unTxt.clear();
            pwTxt.clear();
            unTxt.requestFocus(); // Places the typing cursor back to username field
        }
    }

    // Helper method to handle FXML switching dynamically
    private void navigateTo(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) securityPane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Could not load the next page: " + fxmlPath);
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
