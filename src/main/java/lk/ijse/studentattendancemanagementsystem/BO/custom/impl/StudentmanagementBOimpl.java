/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.dao.DAOFactory;
import lk.ijse.studentattendancemanagementsystem.dto.StudentmanagementDTO;
import lk.ijse.studentattendancemanagementsystem.entity.StudentmanagementEntity;
import lk.ijse.studentattendancemanagementsystem.BO.custom.StudentmanagementBO;
import lk.ijse.studentattendancemanagementsystem.dao.custom.StudentmanagementDAO;

/**
 *
 * @author ACER
 */
public class StudentmanagementBOimpl implements StudentmanagementBO{
    private final StudentmanagementDAO studentmanagementDAO =
        (StudentmanagementDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean addStudent(StudentmanagementDTO dto) throws Exception {
        return studentmanagementDAO.add(convertToEntity(dto));
    }

    @Override
    public boolean editStudent(StudentmanagementDTO dto) throws Exception {
        return studentmanagementDAO.edit(convertToEntity(dto));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentmanagementDAO.delete(id);
    }

    @Override
    public List<StudentmanagementDTO> getAllStudents() throws Exception {
        List<StudentmanagementDTO> dtos = new ArrayList<>();
        for (StudentmanagementEntity entity : studentmanagementDAO.getAll()) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }

    private StudentmanagementEntity convertToEntity(StudentmanagementDTO dto) {
        return new StudentmanagementEntity(dto.getId(), dto.getName(), dto.getEmail(), dto.getAddress(), dto.getCourseId());
    }

    private StudentmanagementDTO convertToDTO(StudentmanagementEntity entity) {
        return new StudentmanagementDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getAddress(), entity.getCourseId());
    }
    
}
