/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.controller;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.studentattendancemanagementsystem.dto.ScheduleDTO;
import lk.ijse.studentattendancemanagementsystem.model.ScheduleModel;

public class classschedulingController {

    @FXML private Label csLbl;
    @FXML private AnchorPane csPanel;
    @FXML private TableView<ScheduleDTO> csTbl;
    @FXML private Button csaddBtn;
    @FXML private TableColumn<ScheduleDTO, String> csclassidCol;
    @FXML private Label csclassidLbl;
    @FXML private TextField csclassidTxt;
    @FXML private TableColumn<ScheduleDTO, String> cscourseidCol;
    @FXML private Label cscourseidLbl;
    @FXML private TextField cscourseidTxt;
    @FXML private TableColumn<ScheduleDTO, String> csdateCol;
    @FXML private Label csdateLbl;
    @FXML private TextField csdateTxt;
    @FXML private Button csdeleteBtn;
    @FXML private Button cseditBtn;
    @FXML private Label cslecturerLbl;
    @FXML private TableColumn<ScheduleDTO, String> cslectureridCol;
    @FXML private TextField cslectureridTxt;
    @FXML private Button csresetBtn;
    @FXML private TableColumn<ScheduleDTO, String> cssubjectidCol;
    @FXML private Label cssubjectidLbl;
    @FXML private TextField cssubjectidTxt;
    @FXML private TableColumn<ScheduleDTO, String> cstimeslotCol;
    @FXML private Label cstimeslotLbl;
    @FXML private TextField cstimeslotTxt;

    private final ScheduleModel scheduleModel = new ScheduleModel();

    public void initialize() {
        csclassidCol.setCellValueFactory(new PropertyValueFactory<>("classId"));
        cscourseidCol.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        cssubjectidCol.setCellValueFactory(new PropertyValueFactory<>("subjectId"));
        csdateCol.setCellValueFactory(new PropertyValueFactory<>("classDate"));
        cstimeslotCol.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        cslectureridCol.setCellValueFactory(new PropertyValueFactory<>("lecturerId"));

        loadAllSchedules();

        csTbl.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                csclassidTxt.setText(newVal.getClassId());
                cscourseidTxt.setText(newVal.getCourseId());
                cssubjectidTxt.setText(newVal.getSubjectId());
                csdateTxt.setText(newVal.getClassDate());
                cstimeslotTxt.setText(newVal.getTimeSlot());
                cslectureridTxt.setText(newVal.getLecturerId());
            }
        });
    }

    private void loadAllSchedules() {
        try {
            List<ScheduleDTO> schedules = scheduleModel.getSchedules();
            ObservableList<ScheduleDTO> obList = FXCollections.observableArrayList(schedules);
            csTbl.setItems(obList);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error loading schedules: " + e.getMessage());
        }
    }

    @FXML
    void csaddBtnOnAction(ActionEvent event) {
        String classId = csclassidTxt.getText().trim();
        String courseId = cscourseidTxt.getText().trim();
        String subjectId = cssubjectidTxt.getText().trim();
        String date = csdateTxt.getText().trim();
        String timeSlot = cstimeslotTxt.getText().trim();
        String lecturerId = cslectureridTxt.getText().trim();

        if (classId.isEmpty() || courseId.isEmpty() || subjectId.isEmpty()
                || date.isEmpty() || timeSlot.isEmpty() || lecturerId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "All fields are required!");
            return;
        }
        try {
            boolean result = scheduleModel.addSchedule(
                new ScheduleDTO(classId, courseId, subjectId, lecturerId, date, timeSlot)
            );
            if (result) {
                showAlert(Alert.AlertType.INFORMATION, "Schedule added successfully!");
                clearFields();
                loadAllSchedules();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to add schedule.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    @FXML
    void cseditBtnOnAction(ActionEvent event) {
        String classId = csclassidTxt.getText().trim();
        if (classId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a schedule to edit.");
            return;
        }
        try {
            boolean result = scheduleModel.editSchedule(new ScheduleDTO(
                classId,
                cscourseidTxt.getText().trim(),
                cssubjectidTxt.getText().trim(),
                cslectureridTxt.getText().trim(),
                csdateTxt.getText().trim(),
                cstimeslotTxt.getText().trim()
            ));
            if (result) {
                showAlert(Alert.AlertType.INFORMATION, "Schedule updated successfully!");
                clearFields();
                loadAllSchedules();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to update schedule.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    @FXML
    void csdeleteBtnOnAction(ActionEvent event) {
        String classId = csclassidTxt.getText().trim();
        if (classId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a schedule to delete.");
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Delete schedule " + classId + "?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                try {
                    boolean result = scheduleModel.deleteSchedule(classId);
                    if (result) {
                        showAlert(Alert.AlertType.INFORMATION, "Schedule deleted successfully!");
                        clearFields();
                        loadAllSchedules();
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Failed to delete schedule.");
                    }
                } catch (Exception e) {
                    showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
                }
            }
        });
    }

    @FXML
    void csresetBtnOnAAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        csclassidTxt.clear();
        cscourseidTxt.clear();
        cssubjectidTxt.clear();
        csdateTxt.clear();
        cstimeslotTxt.clear();
        cslectureridTxt.clear();
        csTbl.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String message) {
        new Alert(type, message).showAndWait();
    }
}