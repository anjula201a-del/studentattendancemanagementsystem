/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.SuperBO;
import lk.ijse.studentattendancemanagementsystem.dto.StudentmanagementDTO;

/**
 *
 * @author ACER
 */
public interface StudentmanagementBO extends SuperBO {
    boolean addStudent(StudentmanagementDTO dto) throws Exception;
    boolean editStudent(StudentmanagementDTO dto) throws Exception;
    boolean deleteStudent(String id) throws Exception;    
    List<StudentmanagementDTO> getAllStudents() throws Exception;
    
    
}
