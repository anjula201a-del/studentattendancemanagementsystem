/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom.impl;

import java.sql.ResultSet;
import lk.ijse.studentattendancemanagementsystem.dao.CrudUtil;
import lk.ijse.studentattendancemanagementsystem.dao.custom.AttendanceDAO;
import lk.ijse.studentattendancemanagementsystem.entity.AttendanceEntity;

/**
 *
 * @author ACER
 */
public class AttendanceDAOimpl implements AttendanceDAO {
    @Override
    public boolean save(AttendanceEntity entity) throws Exception {
       
        return CrudUtil.executeUpdate(
            "INSERT INTO attendance(class_id, student_id, attendance) VALUES (?,?,?) " +
            "ON DUPLICATE KEY UPDATE attendance=VALUES(attendance)",
            entity.getClassId(),
            entity.getStudentId(),
            entity.getAttendance()
        );
    }

    @Override
    public ResultSet getAttendanceReport(String studentId, String subjectId, String fromDate, String toDate) throws Exception {
        StringBuilder sql = new StringBuilder(
            "SELECT a.student_id, sc.subject_id, sc.class_date, a.attendance " +
            "FROM attendance a " +
            "JOIN schedules sc ON a.class_id = sc.class_id " +
            "WHERE 1=1"
        );
       
        if (studentId != null && !studentId.isEmpty()) sql.append(" AND a.student_id = '").append(studentId).append("'");
        if (subjectId != null && !subjectId.isEmpty()) sql.append(" AND sc.subject_id = '").append(subjectId).append("'");
        if (fromDate != null && !fromDate.isEmpty()) sql.append(" AND sc.class_date >= '").append(fromDate).append("'");
        if (toDate != null && !toDate.isEmpty()) sql.append(" AND sc.class_date <= '").append(toDate).append("'");
        sql.append(" ORDER BY sc.class_date DESC");

        return CrudUtil.executeQuery(sql.toString());
    }
}
