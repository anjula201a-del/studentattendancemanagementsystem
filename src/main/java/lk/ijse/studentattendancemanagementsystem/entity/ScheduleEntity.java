package lk.ijse.studentattendancemanagementsystem.entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
public class ScheduleEntity {
     private String classId;
    private String courseId;
    private String subjectId;
    private String lecturerId;
    private String classDate;
    private String timeSlot;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getClassDate() {
        return classDate;
    }

    public void setClassDate(String classDate) {
        this.classDate = classDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "ScheduleEntity{" + "classId=" + classId + ", courseId=" + courseId + ", subjectId=" + subjectId + ", lecturerId=" + lecturerId + ", classDate=" + classDate + ", timeSlot=" + timeSlot + '}';
    }

    public ScheduleEntity(String classId, String courseId, String subjectId, String lecturerId, String classDate, String timeSlot) {
        this.classId = classId;
        this.courseId = courseId;
        this.subjectId = subjectId;
        this.lecturerId = lecturerId;
        this.classDate = classDate;
        this.timeSlot = timeSlot;
    }

    public ScheduleEntity() {
    }

}
