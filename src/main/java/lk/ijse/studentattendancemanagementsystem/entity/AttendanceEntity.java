/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.entity;

/**
 *
 * @author ACER
 */
public class AttendanceEntity {
    private String classId;
    private String studentId;
    private String attendance;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "AttendanceEntity{" + "classId=" + classId + ", studentId=" + studentId + ", attendance=" + attendance + '}';
    }

    public AttendanceEntity(String classId, String studentId, String attendance) {
        this.classId = classId;
        this.studentId = studentId;
        this.attendance = attendance;
    }

    public AttendanceEntity() {
    }
}
