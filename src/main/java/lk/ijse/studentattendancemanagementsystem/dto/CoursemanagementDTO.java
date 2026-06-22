/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dto;

import java.math.BigDecimal;

/**
 *
 * @author ACER
 */
public class CoursemanagementDTO {
    private String courseId;
    private String courseName;
    private String duration;
    private BigDecimal courseFee;
    private String subId;
    private String subName;

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

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    @Override
    public String toString() {
        return "CoursemanagementDTO{" + "courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", courseFee=" + courseFee + ", subId=" + subId + ", subName=" + subName + '}';
    }

    public CoursemanagementDTO(String courseId, String courseName, String duration, BigDecimal courseFee, String subId, String subName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
        this.courseFee = courseFee;
        this.subId = subId;
        this.subName = subName;
    }

    public CoursemanagementDTO() {
    }
}
