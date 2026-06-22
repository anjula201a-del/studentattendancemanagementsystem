/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.custom.AttendanceBO;
import lk.ijse.studentattendancemanagementsystem.dao.DAOFactory;
import lk.ijse.studentattendancemanagementsystem.dao.custom.AttendanceDAO;
import lk.ijse.studentattendancemanagementsystem.dto.AttendanceDTO;
import lk.ijse.studentattendancemanagementsystem.dto.AttendanceReportDTO;
import lk.ijse.studentattendancemanagementsystem.entity.AttendanceEntity;

/**
 *
 * @author ACER
 */
public class AttendanceBOimpl implements AttendanceBO {
     private final AttendanceDAO attendanceDAO =
        (AttendanceDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ATTENDANCE);

    @Override
    public boolean saveAttendance(AttendanceDTO dto) throws Exception {
        return attendanceDAO.save(new AttendanceEntity(dto.getClassId(), dto.getStudentId(), dto.getAttendance()));
    }

    @Override
    public List<AttendanceReportDTO> getAttendanceReport(String studentId, String subjectId,
                                                          String fromDate, String toDate) throws Exception {
        List<AttendanceReportDTO> list = new ArrayList<>();
        ResultSet rst = attendanceDAO.getAttendanceReport(studentId, subjectId, fromDate, toDate);
        while (rst.next()) {
            list.add(new AttendanceReportDTO(
                rst.getString("student_id"),
                rst.getString("subject_id"),
                rst.getString("class_date"),
                rst.getString("attendance")
            ));
        }
        return list;
    }
}
