/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.dao.CrudUtil;
import lk.ijse.studentattendancemanagementsystem.dao.SuperDAO;
import lk.ijse.studentattendancemanagementsystem.dao.custom.ScheduleDAO;
import lk.ijse.studentattendancemanagementsystem.entity.ScheduleEntity;

/**
 *
 * @author ACER
 */
public class ScheduleDAOimpl implements ScheduleDAO {
     @Override
    public boolean add(ScheduleEntity entity) throws Exception {
        return CrudUtil.executeUpdate(
            "INSERT INTO schedules(class_id, course_id, subject_id, lecturer_id, class_date, time_slot) VALUES (?,?,?,?,?,?)",
            entity.getClassId(),
            entity.getCourseId(),
            entity.getSubjectId(),
            entity.getLecturerId(),
            entity.getClassDate(),
            entity.getTimeSlot()
        );
    }

    @Override
    public boolean edit(ScheduleEntity entity) throws Exception {
        return CrudUtil.executeUpdate(
            "UPDATE schedules SET course_id=?, subject_id=?, lecturer_id=?, class_date=?, time_slot=? WHERE class_id=?",
            entity.getCourseId(),
            entity.getSubjectId(),
            entity.getLecturerId(),
            entity.getClassDate(),
            entity.getTimeSlot(),
            entity.getClassId()
        );
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM schedules WHERE class_id=?", id);
    }

    @Override
    public List<ScheduleEntity> getAll() throws Exception {
        List<ScheduleEntity> list = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM schedules");
        while (rst.next()) {
            list.add(new ScheduleEntity(
                rst.getString("class_id"),
                rst.getString("course_id"),
                rst.getString("subject_id"),
                rst.getString("lecturer_id"),
                rst.getString("class_date"),
                rst.getString("time_slot")
            ));
        }
        return list;
    }
}
