/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.entity;

/**
 *
 * @author ACER
 */
public class LecturermanagementEntity {
     private String id;
    private String name;
    private String email;
    private String address;
    private String subjectId;

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

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "LecturermanagementEntity{" + "id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", subjectId=" + subjectId + '}';
    }

    public LecturermanagementEntity(String id, String name, String email, String address, String subjectId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.subjectId = subjectId;
    }

    public LecturermanagementEntity() {
    }

   
}
