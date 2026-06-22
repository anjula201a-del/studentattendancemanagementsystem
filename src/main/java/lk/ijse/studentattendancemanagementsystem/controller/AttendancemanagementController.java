/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.studentattendancemanagementsystem.dto.AttendanceDTO;
import lk.ijse.studentattendancemanagementsystem.model.AttendanceModel;

public class AttendancemanagementController {

    @FXML private Label amLbl;
    @FXML private AnchorPane amPanel;
    @FXML private Label amattendanceLbl;
    @FXML private ChoiceBox<String> amattendanceTxt;
    @FXML private Label amclassidLbl;
    @FXML private TextField amclassidTxt;
    @FXML private Button amsaveBtn;
    @FXML private Label amstudentidLbl;
    @FXML private TextField amstudentidTxt;

    private final AttendanceModel attendanceModel = new AttendanceModel();

    public void initialize() {
        amattendanceTxt.setItems(FXCollections.observableArrayList("Present", "Absent", "Late"));
    }

    @FXML
    void amsaveBtnOnAction(ActionEvent event) {
        String classId = amclassidTxt.getText().trim();
        String studentId = amstudentidTxt.getText().trim();
        String attendance = amattendanceTxt.getValue();

        if (classId.isEmpty() || studentId.isEmpty() || attendance == null) {
            new Alert(Alert.AlertType.WARNING, "All fields are required!").showAndWait();
            return;
        }
        try {
            boolean result = attendanceModel.saveAttendance(new AttendanceDTO(classId, studentId, attendance));
            if (result) {
                new Alert(Alert.AlertType.INFORMATION, "Attendance saved successfully!").showAndWait();
                amclassidTxt.clear();
                amstudentidTxt.clear();
                amattendanceTxt.setValue(null);
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save attendance.").showAndWait();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error: " + e.getMessage()).showAndWait();
        }
    }
}