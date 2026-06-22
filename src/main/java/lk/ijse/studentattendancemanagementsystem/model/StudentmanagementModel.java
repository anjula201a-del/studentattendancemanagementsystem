/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.model;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.BOFactory;
import lk.ijse.studentattendancemanagementsystem.dto.StudentmanagementDTO;
import lk.ijse.studentattendancemanagementsystem.BO.custom.StudentmanagementBO;

/**
 *
 * @author ACER
 */
public class StudentmanagementModel {
   StudentmanagementBO studentmanagementBO =
        (StudentmanagementBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.STUDENT);

    public boolean addStudent(StudentmanagementDTO dto) throws Exception {
        return studentmanagementBO.addStudent(dto);
    }

    public boolean editStudent(StudentmanagementDTO dto) throws Exception {
        return studentmanagementBO.editStudent(dto);
    }

    public boolean deleteStudent(String id) throws Exception {    // FIXED: String not int
        return studentmanagementBO.deleteStudent(id);
    }

    public List<StudentmanagementDTO> getStudents() throws Exception {
        return studentmanagementBO.getAllStudents();
    }
}
