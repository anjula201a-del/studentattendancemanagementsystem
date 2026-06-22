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
import lk.ijse.studentattendancemanagementsystem.dto.AttendanceReportDTO;
import lk.ijse.studentattendancemanagementsystem.model.AttendanceModel;

public class attendancereportController {

    @FXML private Label arLbl;
    @FXML private AnchorPane arPanel;
    @FXML private TableView<AttendanceReportDTO> arTbl;
    @FXML private Button araddBtn;
    @FXML private TableColumn<AttendanceReportDTO, String> arattendanceCol;
    @FXML private TableColumn<AttendanceReportDTO, String> ardateCol;
    @FXML private Label ardateLbl;
    @FXML private Label arfromLbl;
    @FXML private TextField arfromTxt;
    @FXML private Button arresetBtn;
    @FXML private TableColumn<AttendanceReportDTO, String> arstudentidCol;
    @FXML private Label arstudentidLbl;
    @FXML private TextField arstudentidTxt;
    @FXML private TableColumn<AttendanceReportDTO, String> arsubjectidCol;
    @FXML private Label arsubjectidLbl;
    @FXML private TextField arsubjectidTxt;
    @FXML private Label artoLbl;
    @FXML private TextField artoTxt;

    private final AttendanceModel attendanceModel = new AttendanceModel();

    public void initialize() {
        arstudentidCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        arsubjectidCol.setCellValueFactory(new PropertyValueFactory<>("subjectId"));
        ardateCol.setCellValueFactory(new PropertyValueFactory<>("classDate"));
        arattendanceCol.setCellValueFactory(new PropertyValueFactory<>("attendance"));
    }

    @FXML
    void araddBtnOnAction(ActionEvent event) {
        String studentId = arstudentidTxt.getText().trim();
        String subjectId = arsubjectidTxt.getText().trim();
        String fromDate = arfromTxt.getText().trim();
        String toDate = artoTxt.getText().trim();

        try {
            List<AttendanceReportDTO> report = attendanceModel.getAttendanceReport(studentId, subjectId, fromDate, toDate);
            ObservableList<AttendanceReportDTO> obList = FXCollections.observableArrayList(report);
            arTbl.setItems(obList);
            if (report.isEmpty()) {
                new Alert(Alert.AlertType.INFORMATION, "No records found for the given filters.").showAndWait();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading report: " + e.getMessage()).showAndWait();
        }
    }

    @FXML
    void arresetBtnOnAction(ActionEvent event) {
        arstudentidTxt.clear();
        arsubjectidTxt.clear();
        arfromTxt.clear();
        artoTxt.clear();
        arTbl.getItems().clear();
    }
}