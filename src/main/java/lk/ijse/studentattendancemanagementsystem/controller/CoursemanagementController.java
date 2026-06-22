/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.controller;

import java.math.BigDecimal;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.studentattendancemanagementsystem.BO.BOFactory;
import lk.ijse.studentattendancemanagementsystem.BO.custom.CoursemanagementBO;
import lk.ijse.studentattendancemanagementsystem.dto.CoursemanagementDTO;

public class CoursemanagementController {

    @FXML private Label cmLbl;
    @FXML private AnchorPane cmPanel;
    @FXML private TableView<CoursemanagementDTO> cmTbl;
    @FXML private Button cmaddBtn;
    @FXML private TableColumn<CoursemanagementDTO, String> cmcourseidCol;
    @FXML private Label cmcourseidLbl;
    @FXML private TextField cmstudentidTxt;
    @FXML private Button cmdeleteBtn;
    @FXML private TableColumn<CoursemanagementDTO, String> cmdurationCol;
    @FXML private Label cmdurationLbl;
    @FXML private TextField cmdurationTxt;
    @FXML private Button cmeditBtn;
    @FXML private TableColumn<CoursemanagementDTO, BigDecimal> cmfeeCol;
    @FXML private Label cmfeeLbl;
    @FXML private TextField cmfeeTxt;
    @FXML private Button cmresetBtn;
    @FXML private TableColumn<CoursemanagementDTO, String> cmnameCol;
    @FXML private Label cmnameLbl;
    @FXML private TextField cmnameTxt;
    @FXML private TableColumn<CoursemanagementDTO, String> cmsubidCol;
    @FXML private Label cmsubidLbl;
    @FXML private TextField cmsubidTxt;
    @FXML private TableColumn<CoursemanagementDTO, String> cmsubnameCol;
    @FXML private Label cmsubnameLbl;
    @FXML private TextField cmsubnameTxt;

    private final CoursemanagementBO coursemanagementBO =
        (CoursemanagementBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);

    public void initialize() {
        cmcourseidCol.setCellValueFactory(new PropertyValueFactory<>("courseId"));
        cmnameCol.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        cmdurationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
        cmfeeCol.setCellValueFactory(new PropertyValueFactory<>("courseFee"));
        cmsubidCol.setCellValueFactory(new PropertyValueFactory<>("subId"));
        cmsubnameCol.setCellValueFactory(new PropertyValueFactory<>("subName"));

        loadAllCourses();

        cmTbl.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                cmstudentidTxt.setText(newVal.getCourseId());
                cmnameTxt.setText(newVal.getCourseName());
                cmdurationTxt.setText(newVal.getDuration());
                cmfeeTxt.setText(newVal.getCourseFee().toString());
                cmsubidTxt.setText(newVal.getSubId());
                cmsubnameTxt.setText(newVal.getSubName());
            }
        });
    }

    private void loadAllCourses() {
        try {
            List<CoursemanagementDTO> courses = coursemanagementBO.getAllCoursesWithSubjects();
            ObservableList<CoursemanagementDTO> obList = FXCollections.observableArrayList(courses);
            cmTbl.setItems(obList);
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error loading courses: " + e.getMessage());
        }
    }

    @FXML
    void cmaddBtnOnAction(ActionEvent event) {
        String courseId = cmstudentidTxt.getText().trim();
        String courseName = cmnameTxt.getText().trim();
        String duration = cmdurationTxt.getText().trim();
        String fee = cmfeeTxt.getText().trim();
        String subId = cmsubidTxt.getText().trim();
        String subName = cmsubnameTxt.getText().trim();

        if (courseId.isEmpty() || courseName.isEmpty() || duration.isEmpty()
                || fee.isEmpty() || subId.isEmpty() || subName.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "All fields are required!");
            return;
        }

        try {
            CoursemanagementDTO dto = new CoursemanagementDTO(
                courseId, courseName, duration, new BigDecimal(fee), subId, subName
            );
            boolean result = coursemanagementBO.addCourseWithSubject(dto);
            if (result) {
                showAlert(Alert.AlertType.INFORMATION, "Course added successfully!");
                clearFields();
                loadAllCourses();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to add course.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Course Fee must be a valid number!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    @FXML
    void cmeditBtnOnAction(ActionEvent event) {
        String courseId = cmstudentidTxt.getText().trim();
        if (courseId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a course to edit.");
            return;
        }
        try {
            CoursemanagementDTO dto = new CoursemanagementDTO(
                courseId,
                cmnameTxt.getText().trim(),
                cmdurationTxt.getText().trim(),
                new BigDecimal(cmfeeTxt.getText().trim()),
                cmsubidTxt.getText().trim(),
                cmsubnameTxt.getText().trim()
            );
            boolean result = coursemanagementBO.editCourseWithSubject(dto);
            if (result) {
                showAlert(Alert.AlertType.INFORMATION, "Course updated successfully!");
                clearFields();
                loadAllCourses();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed to update course.");
            }
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Course Fee must be a valid number!");
        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    @FXML
    void cmdeleteBtnOnAction(ActionEvent event) {
        String courseId = cmstudentidTxt.getText().trim();
        if (courseId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Please select a course to delete.");
            return;
        }
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION,
            "Delete course " + courseId + "? This will also delete related subjects.",
            ButtonType.YES, ButtonType.NO);
        confirm.showAndWait().ifPresent(response -> {
            if (response == ButtonType.YES) {
                try {
                    boolean result = coursemanagementBO.deleteCourse(courseId);
                    if (result) {
                        showAlert(Alert.AlertType.INFORMATION, "Course deleted successfully!");
                        clearFields();
                        loadAllCourses();
                    } else {
                        showAlert(Alert.AlertType.ERROR, "Failed to delete course.");
                    }
                } catch (Exception e) {
                    showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
                }
            }
        });
    }

    @FXML
    void cmresetBtnOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        cmstudentidTxt.clear();
        cmnameTxt.clear();
        cmdurationTxt.clear();
        cmfeeTxt.clear();
        cmsubidTxt.clear();
        cmsubnameTxt.clear();
        cmTbl.getSelectionModel().clearSelection();
    }

    private void showAlert(Alert.AlertType type, String message) {
        new Alert(type, message).showAndWait();
    }
}