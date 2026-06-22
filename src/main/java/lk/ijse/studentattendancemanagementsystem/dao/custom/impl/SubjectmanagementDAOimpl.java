/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.dao.CrudUtil;
import lk.ijse.studentattendancemanagementsystem.dao.custom.SubjectmanagementDAO;
import lk.ijse.studentattendancemanagementsystem.entity.SubjectmanagementEntity;

/**
 *
 * @author ACER
 */
public class SubjectmanagementDAOimpl implements SubjectmanagementDAO{
      @Override
    public boolean add(SubjectmanagementEntity entity) throws Exception {
        return CrudUtil.executeUpdate(
            "INSERT INTO subject(subject_id, subject_name, course_id) VALUES (?,?,?)",
            entity.getSubjectId(),
            entity.getSubjectName(),
            entity.getCourseId()
        );
    }

    @Override
    public boolean edit(SubjectmanagementEntity entity) throws Exception {
        return CrudUtil.executeUpdate(
            "UPDATE subject SET subject_name=?, course_id=? WHERE subject_id=?",
            entity.getSubjectName(), 
            entity.getCourseId(),
            entity.getSubjectId()
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM subject WHERE subject_id=?", id);
    }

    @Override
    public List<SubjectmanagementEntity> getAll() throws Exception {
        List<SubjectmanagementEntity> list = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM subject");
        while (rst.next()) {
            list.add(new SubjectmanagementEntity(
                rst.getString("subject_id"),
                rst.getString("subject_name"),
                rst.getString("course_id")
            ));
        }
        return list;
    } 
    
}
