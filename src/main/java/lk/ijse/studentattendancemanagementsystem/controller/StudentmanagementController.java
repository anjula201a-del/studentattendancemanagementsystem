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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.studentattendancemanagementsystem.dto.StudentmanagementDTO;
import lk.ijse.studentattendancemanagementsystem.model.StudentmanagementModel;

public class StudentmanagementController {

    @FXML private Label smLbl;
    @FXML private AnchorPane smPanel;
    @FXML private TableView<StudentmanagementDTO> smTbl;
    @FXML private Button smaddBtn;
    @FXML private TableColumn<StudentmanagementDTO, String> smadressCol;
    @FXML private Label smadressLbl;
    @FXML private TextField smadressTxt;
    @FXML private TableColumn<StudentmanagementDTO, String> smcourseidCol;
    @FXML private Label smcourseidLbl;
    @FXML private TextField smcourseidTxt;
    @FXML private Button smdeleteTxt;
    @FXML private Button smeditTxt;
    @FXML private TableColumn<StudentmanagementDTO, String> smemailCol;
    @FXML private Label smemailLbl;
    @FXML private TextField smemailTxt;
    @FXML private TableColumn<StudentmanagementDTO, String> smnameCol;
    @FXML private Label smnameLbl;
    @FXML private TextField smnameTxt;
    @FXML private Button smresetTxt;
    @FXML private TableColumn<StudentmanagementDTO, String> smstudentidCol;
    @FXML private Label smstudentidLbl;
    @FXML private TextField smstudentidTxt;

    private final StudentmanagementModel studentmanagementModel = new StudentmanagementModel();

    public void initialize() {
        smstudentidCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        smnameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        smemailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        smadressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        smcourseidCol.setCellValueFactory(new PropertyValueFactory<>("courseId"));

        loadAllStudents();

        // Click on row to fill fields
        smTbl.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                smstudentidTxt.setText(newVal.getId());
                smnameTxt.setText(newVal.getName());
                smemailTxt.setText(newVal.getEmail());
                smadressTxt.setText(newVal.getAddress());
                smcourseidTxt.setText(newVal.getCourseId());
            }
        });
    }

    private void loadAllStudents() {
        try {
            List<StudentmanagementDTO> students = studentmanagementModel.getStudents();
            ObservableList<StudentmanagementDTO> obList = FXCollections.observableArrayList(students);
            smTbl.setItems(obList);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error loading students: " + e.getMessage());
        }
    }

    @FXML
    void smaddBtnOnAction(ActionEvent event) {
        String id = smstudentidTxt.getText().trim();
        String name = smnameTxt.getText().trim();
        String email = smemailTxt.getText().trim();
        String address = smadressTxt.getText().trim();
        String courseId = smcourseidTxt.getText().trim();

        if (id.isEmpty() || name.isEmpty() || courseId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Student ID, Name, and Course ID are required!");
            return;
        }

        try {
            StudentmanagementDTO dto = new StudentmanagementDTO(id, name, email, address, courseId);
            boolean result = studentmanagementModel.addStudent(dto);
            if (result) {
                showAlert(Alert.AlertType.INFORMATION, "Student added successfully!");
                clearFields();
                loadAllStudents();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to add student.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    @FXML
    void smeditTxtOnAction(ActionEvent event) {
        String id = smstudentidTxt.getText().trim();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a student to edit.");
            return;
        }
        try {
            StudentmanagementDTO dto = new StudentmanagementDTO(
                id,
                smnameTxt.getText().trim(),
                smemailTxt.getText().trim(),
                smadressTxt.getText().trim(),
                smcourseidTxt.getText().trim()
            );
            boolean result = studentmanagementModel.editStudent(dto);
            if (result) {
                showAlert(Alert.AlertType.INFORMATION, "Student updated successfully!");
                clearFields();
                loadAllStudents();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to update student.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    @FXML
    void smdeleteTxtOnAction(ActionEvent event) {
        String id = smstudentidTxt.getText().trim();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a student to delete.");
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Delete student " + id + "?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                try {
                    boolean result = studentmanagementModel.deleteStudent(id);
                    if (result) {
                        showAlert(Alert.AlertType.INFORMATION, "Student deleted successfully!");
                        clearFields();
                        loadAllStudents();
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Failed to delete student.");
                    }
                } catch (Exception e) {
                    showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
                }
            }
        });
    }

    @FXML
    void smresetTxtOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        smstudentidTxt.clear();
        smnameTxt.clear();
        smemailTxt.clear();
        smadressTxt.clear();
        smcourseidTxt.clear();
        smTbl.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String message) {
        new Alert(type, message).showAndWait();
    }
}