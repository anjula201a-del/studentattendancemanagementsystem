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
import lk.ijse.studentattendancemanagementsystem.dto.LecturermanagementDTO;
import lk.ijse.studentattendancemanagementsystem.model.LecturermanagementModel;

public class LecturermanagementController {

    @FXML private Label lmLbl;
    @FXML private AnchorPane lmPanel;
    @FXML private TableView<LecturermanagementDTO> lmTbl;
    @FXML private Button lmaddBtn;
    @FXML private TableColumn<LecturermanagementDTO, String> lmadressCol;
    @FXML private Label lmadressLbl;
    @FXML private TextField lmadressTxt;
    @FXML private Button lmdeleteBtn;
    @FXML private Button lmeditBtn;
    @FXML private TableColumn<LecturermanagementDTO, String> lmemailCol;
    @FXML private Label lmemailLbl;
    @FXML private TextField lmemailTxt;
    @FXML private TableColumn<LecturermanagementDTO, String> lmlectureridCol;
    @FXML private Label lmlectureridLbl;
    @FXML private TextField lmlectureridTxt;
    @FXML private TableColumn<LecturermanagementDTO, String> lmnameCol;
    @FXML private Label lmnameLbl;
    @FXML private TextField lmnameTXt;
    @FXML private Button lmresetBtn;
    @FXML private TableColumn<LecturermanagementDTO, String> lmsubjectidCol;
    @FXML private Label lmsubjectidLbl;
    @FXML private TextField lmsubjectidTxt;

    private final LecturermanagementModel lecturermanagementModel = new LecturermanagementModel();

    public void initialize() {
        lmlectureridCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        lmnameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        lmemailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        lmadressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        lmsubjectidCol.setCellValueFactory(new PropertyValueFactory<>("subjectId"));

        loadAllLecturers();

        lmTbl.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                lmlectureridTxt.setText(newVal.getId());
                lmnameTXt.setText(newVal.getName());
                lmemailTxt.setText(newVal.getEmail());
                lmadressTxt.setText(newVal.getAddress());
                lmsubjectidTxt.setText(newVal.getSubjectId());
            }
        });
    }

    private void loadAllLecturers() {
        try {
            List<LecturermanagementDTO> lecturers = lecturermanagementModel.getLecturers();
            ObservableList<LecturermanagementDTO> obList = FXCollections.observableArrayList(lecturers);
            lmTbl.setItems(obList);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error loading lecturers: " + e.getMessage());
        }
    }

    @FXML
    void lmaddBtnOnAction(ActionEvent event) {
        String id = lmlectureridTxt.getText().trim();
        String name = lmnameTXt.getText().trim();
        String email = lmemailTxt.getText().trim();
        String address = lmadressTxt.getText().trim();
        String subjectId = lmsubjectidTxt.getText().trim();

        if (id.isEmpty() || name.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Lecturer ID and Name are required!");
            return;
        }
        try {
            boolean result = lecturermanagementModel.addLecturer(
                new LecturermanagementDTO(id, name, email, address, subjectId)
            );
            if (result) {
                showAlert(Alert.AlertType.INFORMATION, "Lecturer added successfully!");
                clearFields();
                loadAllLecturers();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to add lecturer.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    @FXML
    void lmeditBtnOnAction(ActionEvent event) {
        String id = lmlectureridTxt.getText().trim();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a lecturer to edit.");
            return;
        }
        try {
            boolean result = lecturermanagementModel.editLecturer(
                new LecturermanagementDTO(id, lmnameTXt.getText().trim(), lmemailTxt.getText().trim(),
                    lmadressTxt.getText().trim(), lmsubjectidTxt.getText().trim())
            );
            if (result) {
                showAlert(Alert.AlertType.INFORMATION, "Lecturer updated successfully!");
                clearFields();
                loadAllLecturers();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to update lecturer.");
            }
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    @FXML
    void lmdeleteBtnOnAction(ActionEvent event) {
        String id = lmlectureridTxt.getText().trim();
        if (id.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a lecturer to delete.");
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Delete lecturer " + id + "?", ButtonType.YES, ButtonType.NO);
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                try {
                    boolean result = lecturermanagementModel.deleteLecturer(id);
                    if (result) {
                        showAlert(Alert.AlertType.INFORMATION, "Lecturer deleted successfully!");
                        clearFields();
                        loadAllLecturers();
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Failed to delete lecturer.");
                    }
                } catch (Exception e) {
                    showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
                }
            }
        });
    }

    @FXML
    void lmresetBtnOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        lmlectureridTxt.clear();
        lmnameTXt.clear();
        lmemailTxt.clear();
        lmadressTxt.clear();
        lmsubjectidTxt.clear();
        lmTbl.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String message) {
        new Alert(type, message).showAndWait();
    }
}