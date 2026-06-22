/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.entity;

/**
 *
 * @author ACER
 */
public class SubjectmanagementEntity {
    private String subjectId;
    private String subjectName;
    private String courseId;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "SubjectmanagementEntity{" + "subjectId=" + subjectId + ", subjectName=" + subjectName + ", courseId=" + courseId + '}';
    }

    public SubjectmanagementEntity(String subjectId, String subjectName, String courseId) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.courseId = courseId;
    }

    public SubjectmanagementEntity() {
    }
}
