/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.SuperBO;
import lk.ijse.studentattendancemanagementsystem.dto.AttendanceDTO;
import lk.ijse.studentattendancemanagementsystem.dto.AttendanceReportDTO;

/**
 *
 * @author ACER
 */
public interface AttendanceBO extends SuperBO {
    boolean saveAttendance(AttendanceDTO dto) throws Exception;
    List<AttendanceReportDTO> getAttendanceReport(String studentId, String subjectId, String fromDate, String toDate) throws Exception;
}
