/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.entity;

import java.math.BigDecimal;

/**
 *
 * @author ACER
 */
public class CoursemanagementEntity {
    private String courseId;
    private String courseName;
    private String duration;
    private BigDecimal courseFee;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public BigDecimal getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(BigDecimal courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "CoursemanagementEntity{" + "courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", courseFee=" + courseFee + '}';
    }

    public CoursemanagementEntity(String courseId, String courseName, String duration, BigDecimal courseFee) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.courseFee = courseFee;
    }

    public CoursemanagementEntity() {
    }
}
