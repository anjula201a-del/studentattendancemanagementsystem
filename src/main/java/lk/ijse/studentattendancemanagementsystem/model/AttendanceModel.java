/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.model;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.BOFactory;
import lk.ijse.studentattendancemanagementsystem.BO.custom.AttendanceBO;
import lk.ijse.studentattendancemanagementsystem.dto.AttendanceDTO;
import lk.ijse.studentattendancemanagementsystem.dto.AttendanceReportDTO;

/**
 *
 * @author ACER
 */
public class AttendanceModel {
   AttendanceBO attendanceBO =
        (AttendanceBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ATTENDANCE);
 
    public boolean saveAttendance(AttendanceDTO dto) throws Exception {
        return attendanceBO.saveAttendance(dto);
    }
 
    public List<AttendanceReportDTO> getAttendanceReport(String studentId, String subjectId,
                                                          String fromDate, String toDate) throws Exception {
        return attendanceBO.getAttendanceReport(studentId, subjectId, fromDate, toDate);
    }

}
