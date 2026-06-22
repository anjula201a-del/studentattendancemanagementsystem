/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class adminController {

    @FXML
    private Button aamBtn;

    @FXML
    private Button aarBtn;

    @FXML
    private Button acmBtn;

    @FXML
    private Label adinfLbl;

    @FXML
    private Label adminLbl;

    @FXML
    private TextField adminTxt;

    @FXML
    private AnchorPane adminlPanel;

    @FXML
    private AnchorPane adminrPanel;

    @FXML
    private Button almBtn;

    @FXML
    private Button asmBtn;

    @FXML
    void aamBtnOnAction(ActionEvent event) {
         adminTxt.setText("Attendance Marking");

        try {
            Parent subView = FXMLLoader.load(getClass().getResource("/lk/ijse/studentattendancemanagementsystem/attendancemanagement.fxml"));
          
            adminrPanel.getChildren().clear();
           
            adminrPanel.getChildren().add(subView);
            
        } catch (IOException e) {
            e.printStackTrace();
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not find or load attendancemanagement.fxml!");
            alert.showAndWait();
        }
    }

    @FXML
    void aarBtnOnAction(ActionEvent event) {
         adminTxt.setText("Attendance Report");

        try {
            Parent subView = FXMLLoader.load(getClass().getResource("/lk/ijse/studentattendancemanagementsystem/attendancereport.fxml"));
          
            adminrPanel.getChildren().clear();
           
            adminrPanel.getChildren().add(subView);
            
        } catch (IOException e) {
            e.printStackTrace();
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not find or load attendancereport.fxml!");
            alert.showAndWait();
        }

    }

    @FXML
    void acmBtnOnAction(ActionEvent event) {
    adminTxt.setText("Course management");

        try {
            Parent subView = FXMLLoader.load(getClass().getResource("/lk/ijse/studentattendancemanagementsystem/coursemanagement.fxml"));
          
            adminrPanel.getChildren().clear();
           
            adminrPanel.getChildren().add(subView);
            
        } catch (IOException e) {
            e.printStackTrace();
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not find or load coursemanagement.fxml!");
            alert.showAndWait();
        }
    }
        
     @FXML
    void acsBtnOnAction(ActionEvent event) {
      adminTxt.setText("Class Scheduling");

        try {
            Parent subView = FXMLLoader.load(getClass().getResource("/lk/ijse/studentattendancemanagementsystem/classsheduling.fxml"));
          
            adminrPanel.getChildren().clear();
           
            adminrPanel.getChildren().add(subView);
            
        } catch (IOException e) {
            e.printStackTrace();
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not find or load classsheduling.fxml!");
            alert.showAndWait();
        }  
    }    
        
        
        
        
        
        
    
     @FXML
    void almBtnOnAction(ActionEvent event) {
        adminTxt.setText("Lecturer Management");

        try {
            Parent subView = FXMLLoader.load(getClass().getResource("/lk/ijse/studentattendancemanagementsystem/lecturermanagement.fxml"));
          
            adminrPanel.getChildren().clear();
           
            adminrPanel.getChildren().add(subView);
            
        } catch (IOException e) {
            e.printStackTrace();
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not find or load lecturermanagement.fxml!");
            alert.showAndWait();
        }
    }

    @FXML
    void asmBtnOnAction(ActionEvent event) {
         adminTxt.setText("Student Management");

        try {
            Parent subView = FXMLLoader.load(getClass().getResource("/lk/ijse/studentattendancemanagementsystem/studentmanagement.fxml"));
          
            adminrPanel.getChildren().clear();
           
            adminrPanel.getChildren().add(subView);
            
        } catch (IOException e) {
            e.printStackTrace();
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Navigation Error");
            alert.setHeaderText(null);
            alert.setContentText("Could not find or load studentmanagement.fxml!");
            alert.showAndWait();
        }

    }

}
