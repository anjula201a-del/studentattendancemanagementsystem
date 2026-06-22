/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dto;

/**
 *
 * @author ACER
 */
public class AttendanceReportDTO {
    private String studentId;
    private String subjectId;
    private String classDate;
    private String attendance;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "AttendanceReportDTO{" + "studentId=" + studentId + ", subjectId=" + subjectId + ", classDate=" + classDate + ", attendance=" + attendance + '}';
    }

    public AttendanceReportDTO(String studentId, String subjectId, String classDate, String attendance) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.classDate = classDate;
        this.attendance = attendance;
    }

    public AttendanceReportDTO() {
    }
}
