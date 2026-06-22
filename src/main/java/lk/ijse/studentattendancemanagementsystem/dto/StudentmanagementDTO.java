/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dto;

/**
 *
 * @author ACER
 */
public class StudentmanagementDTO {
    private String id;
    private String name;
    private String email;
    private String address;
    private String courseId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "StudentmanagementDTO{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", courseId=" + courseId + '}';
    }

    public StudentmanagementDTO(String id, String name, String email, String address, String courseId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.courseId = courseId;
    }

    public StudentmanagementDTO() {
    }

}
