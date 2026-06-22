/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.dao.CrudUtil;
import lk.ijse.studentattendancemanagementsystem.dao.custom.LecturermanagementDAO;
import lk.ijse.studentattendancemanagementsystem.entity.LecturermanagementEntity;

/**
 *
 * @author ACER
 */
public class LecturermanagementDAOimpl implements LecturermanagementDAO{
     @Override
    public boolean add(LecturermanagementEntity entity) throws Exception {
        // Insert into lecturer table first
        boolean lecturerSaved = CrudUtil.executeUpdate(
            "INSERT INTO lecturer(lecturer_id, name, email, address) VALUES (?,?,?,?)",
            entity.getId(),
            entity.getName(),
            entity.getEmail(),
            entity.getAddress()
        );
        // Then insert subject assignment into lecturer_subject table
        if (lecturerSaved && entity.getSubjectId() != null && !entity.getSubjectId().isEmpty()) {
            return CrudUtil.executeUpdate(
                "INSERT INTO lecturer_subject(lecturer_id, subject_id) VALUES (?,?)",
                entity.getId(),
                entity.getSubjectId()
            );
        }
        return lecturerSaved;
    }

    @Override
    public boolean edit(LecturermanagementEntity entity) throws Exception {
        boolean lecturerUpdated = CrudUtil.executeUpdate(
            "UPDATE lecturer SET name=?, email=?, address=? WHERE lecturer_id=?",
            entity.getName(),
            entity.getEmail(),
            entity.getAddress(),
            entity.getId()
        );
        // Update lecturer_subject: delete old, insert new
        if (lecturerUpdated && entity.getSubjectId() != null && !entity.getSubjectId().isEmpty()) {
            CrudUtil.executeUpdate("DELETE FROM lecturer_subject WHERE lecturer_id=?", entity.getId());
            return CrudUtil.executeUpdate(
                "INSERT INTO lecturer_subject(lecturer_id, subject_id) VALUES (?,?)",
                entity.getId(),
                entity.getSubjectId()
            );
        }
        return lecturerUpdated;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM lecturer WHERE lecturer_id=?", id);
    }

    @Override
    public List<LecturermanagementEntity> getAll() throws Exception {
        List<LecturermanagementEntity> entities = new ArrayList<>();
        ResultSet result = CrudUtil.executeQuery(
            "SELECT l.lecturer_id, l.name, l.email, l.address, ls.subject_id " +
            "FROM lecturer l LEFT JOIN lecturer_subject ls ON l.lecturer_id = ls.lecturer_id"
        );
        while (result.next()) {
            entities.add(new LecturermanagementEntity(
                result.getString("lecturer_id"),
                result.getString("name"),
                result.getString("email"),
                result.getString("address"),
                result.getString("subject_id")
            ));
        }
        return entities;
    }
    
}
