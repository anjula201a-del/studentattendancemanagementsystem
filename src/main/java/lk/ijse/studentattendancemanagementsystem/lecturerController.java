/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class lecturerController {

    @FXML
    private Button lamBtn;

    @FXML
    private Label lecturerLbl;

    @FXML
    private TextField lecturerTxt;

    @FXML
    private Label lecturerfLbl;

    @FXML
    private AnchorPane lecturerfPanel;

    @FXML
    private AnchorPane lecturerlPanel;

    @FXML
    private Button lscBtn;

    @FXML
    void lamBtnOnAction(ActionEvent event) {
        
        lecturerTxt.setText("Attendance Marking");

        try {
            // 2. Load the sub-panel FXML file
            Parent subView = FXMLLoader.load(getClass().getResource("/lk/ijse/studentattendancemanagementsystem/attendancemanagement.fxml"));
            
            // 3. Clear the right-side panel completely
            lecturerfPanel.getChildren().clear();
            
            // 4. Add the loaded layout into the panel
            lecturerfPanel.getChildren().add(subView);
            
        } catch (IOException e) {
            e.printStackTrace();
            
            // Show an alert if something goes wrong with the file path or FXML loading
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not find or load attendancemanagement.fxml!");
            alert.showAndWait();
        }
    }

    @FXML
    void lscBtnOnAction(ActionEvent event) {
         lecturerTxt.setText("Show Classes");

        try {
           
            Parent subView = FXMLLoader.load(getClass().getResource("/lk/ijse/studentattendancemanagementsystem/classsheduling.fxml"));
            
          
            lecturerfPanel.getChildren().clear();
            
           
            lecturerfPanel.getChildren().add(subView);
            
        } catch (IOException e) {
            e.printStackTrace();
            
           
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not find or load show Classes.fxml!");
            alert.showAndWait();
        }
         
    }
}