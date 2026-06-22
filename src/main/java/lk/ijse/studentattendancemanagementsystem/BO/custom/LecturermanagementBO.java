/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.SuperBO;
import lk.ijse.studentattendancemanagementsystem.dto.LecturermanagementDTO;

/**
 *
 * @author ACER
 */
public interface LecturermanagementBO extends SuperBO {
    boolean addLecturer(LecturermanagementDTO dto) throws Exception;
    boolean editLecturer(LecturermanagementDTO dto) throws Exception;
    boolean deleteLecturer(String id) throws Exception;   
    List<LecturermanagementDTO> getAllLecturers() throws Exception;
}
