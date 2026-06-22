/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.dao.CrudUtil;
import lk.ijse.studentattendancemanagementsystem.dao.custom.CoursemanagementDAO;
import lk.ijse.studentattendancemanagementsystem.entity.CoursemanagementEntity;

/**
 *
 * @author ACER
 */
public class CoursemanagementDAOimpl implements CoursemanagementDAO {
    @Override
    public boolean add(CoursemanagementEntity entity) throws Exception {
        return CrudUtil.executeUpdate(
            "INSERT INTO course(course_id, course_name, duration, course_fee) VALUES (?,?,?,?)",
            entity.getCourseId(),
            entity.getCourseName(),
            entity.getDuration(), 
            entity.getCourseFee()
        );
    }

    @Override
    public boolean edit(CoursemanagementEntity entity) throws Exception {
        return CrudUtil.executeUpdate(
            "UPDATE course SET course_name=?, duration=?, course_fee=? WHERE course_id=?",
            entity.getCourseName(),
            entity.getDuration(),
            entity.getCourseFee(),
            entity.getCourseId()
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM course WHERE course_id=?", id);
    }

    @Override
    public List<CoursemanagementEntity> getAll() throws Exception {
        List<CoursemanagementEntity> list = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM course");
        while (rst.next()) {
            list.add(new CoursemanagementEntity(
                rst.getString("course_id"),
                rst.getString("course_name"),
                rst.getString("duration"),
                rst.getBigDecimal("course_fee")
            ));
        }
        return list;
    }
    
    
}
