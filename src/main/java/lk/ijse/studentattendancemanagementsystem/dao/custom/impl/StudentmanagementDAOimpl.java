/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom.impl;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.dao.CrudUtil;
import lk.ijse.studentattendancemanagementsystem.entity.StudentmanagementEntity;
import lk.ijse.studentattendancemanagementsystem.dao.custom.StudentmanagementDAO;

public class StudentmanagementDAOimpl implements StudentmanagementDAO {
    @Override
    public boolean add(StudentmanagementEntity entity) throws Exception {
        return CrudUtil.executeUpdate(
            "INSERT INTO student(student_id, name, email, address, course_id) VALUES (?,?,?,?,?)",
            entity.getId(),
            entity.getName(),
            entity.getEmail(),
            entity.getAddress(),
            entity.getCourseId()
        );
    }

    @Override
    public boolean edit(StudentmanagementEntity entity) throws Exception {
        return CrudUtil.executeUpdate(
            "UPDATE student SET name=?, email=?, address=?, course_id=? WHERE student_id=?",
            entity.getName(),
            entity.getEmail(),
            entity.getAddress(),
            entity.getCourseId(),
            entity.getId()
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM student WHERE student_id=?", id);
    }

    @Override
    public List<StudentmanagementEntity> getAll() throws Exception {
        List<StudentmanagementEntity> entities = new ArrayList<>();
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM student");
        while (result.next()) {
            entities.add(new StudentmanagementEntity(
                result.getString("student_id"),
                result.getString("name"),
                result.getString("email"),
                result.getString("address"),
                result.getString("course_id")
            ));
        }
        return entities;
    }
}