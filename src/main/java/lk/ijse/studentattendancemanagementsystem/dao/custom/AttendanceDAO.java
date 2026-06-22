/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom;

import java.sql.ResultSet;
import lk.ijse.studentattendancemanagementsystem.dao.SuperDAO;
import lk.ijse.studentattendancemanagementsystem.entity.AttendanceEntity;

/**
 *
 * @author ACER
 */
public interface AttendanceDAO extends SuperDAO{
    boolean save(AttendanceEntity entity) throws Exception;
    ResultSet getAttendanceReport(String studentId, String subjectId, String fromDate, String toDate) throws Exception;

}
