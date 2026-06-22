/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.custom.LecturermanagementBO;
import lk.ijse.studentattendancemanagementsystem.dao.DAOFactory;
import lk.ijse.studentattendancemanagementsystem.dao.custom.LecturermanagementDAO;
import lk.ijse.studentattendancemanagementsystem.dto.LecturermanagementDTO;
import lk.ijse.studentattendancemanagementsystem.entity.LecturermanagementEntity;


/**
 *
 * @author ACER
 */
public class LecturermanagementBOimpl implements LecturermanagementBO {
    
    private final LecturermanagementDAO lecturermanagementDAO =
        (LecturermanagementDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LECTURER);

    @Override
    public boolean addLecturer(LecturermanagementDTO dto) throws Exception {
        return lecturermanagementDAO.add(convertToEntity(dto));
    }

    @Override
    public boolean editLecturer(LecturermanagementDTO dto) throws Exception {
        return lecturermanagementDAO.edit(convertToEntity(dto));
    }

    @Override
    public boolean deleteLecturer(String id) throws Exception {
        return lecturermanagementDAO.delete(id);
    }

    @Override
    public List<LecturermanagementDTO> getAllLecturers() throws Exception {
        List<LecturermanagementDTO> dtos = new ArrayList<>();
        for (LecturermanagementEntity entity : lecturermanagementDAO.getAll()) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }

    private LecturermanagementEntity convertToEntity(LecturermanagementDTO dto) {
        return new LecturermanagementEntity(dto.getId(), dto.getName(), dto.getEmail(), dto.getAddress(), dto.getSubjectId());
    }

    private LecturermanagementDTO convertToDTO(LecturermanagementEntity entity) {
        return new LecturermanagementDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getAddress(), entity.getSubjectId());
    }
}
