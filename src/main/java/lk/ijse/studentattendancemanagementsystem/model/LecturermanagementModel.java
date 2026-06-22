/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.model;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.BOFactory;
import lk.ijse.studentattendancemanagementsystem.BO.custom.LecturermanagementBO;
import lk.ijse.studentattendancemanagementsystem.dto.LecturermanagementDTO;

/**
 *
 * @author ACER
 */
public class LecturermanagementModel {
   LecturermanagementBO lecturermanagementBO =
        (LecturermanagementBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.LECTURER);

    public boolean addLecturer(LecturermanagementDTO dto) throws Exception {
        return lecturermanagementBO.addLecturer(dto);
    }

    public boolean editLecturer(LecturermanagementDTO dto) throws Exception {
        return lecturermanagementBO.editLecturer(dto);
    }

    public boolean deleteLecturer(String id) throws Exception {   // FIXED: String not int
        return lecturermanagementBO.deleteLecturer(id);
    }

    public List<LecturermanagementDTO> getLecturers() throws Exception {
        return lecturermanagementBO.getAllLecturers();
    }
}
