/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.SuperBO;
import lk.ijse.studentattendancemanagementsystem.dao.DAOFactory;
import lk.ijse.studentattendancemanagementsystem.dao.custom.ScheduleDAO;
import lk.ijse.studentattendancemanagementsystem.dto.ScheduleDTO;
import lk.ijse.studentattendancemanagementsystem.entity.ScheduleEntity;

/**
 *
 * @author ACER
 */
public class ScheduleBOimpl implements ScheduleBO {
    private final ScheduleDAO scheduleDAO =
        (ScheduleDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SCHEDULE);

    @Override
    public boolean addSchedule(ScheduleDTO dto) throws Exception {
        return scheduleDAO.add(convertToEntity(dto));
    }

    @Override
    public boolean editSchedule(ScheduleDTO dto) throws Exception {
        return scheduleDAO.edit(convertToEntity(dto));
    }

    @Override
    public boolean deleteSchedule(String id) throws Exception {
        return scheduleDAO.delete(id);
    }

    @Override
    public List<ScheduleDTO> getAllSchedules() throws Exception {
        List<ScheduleDTO> dtos = new ArrayList<>();
        for (ScheduleEntity entity : scheduleDAO.getAll()) {
            dtos.add(convertToDTO(entity));
        }
        return dtos;
    }

    private ScheduleEntity convertToEntity(ScheduleDTO dto) {
        return new ScheduleEntity(dto.getClassId(), dto.getCourseId(), dto.getSubjectId(),
            dto.getLecturerId(), dto.getClassDate(), dto.getTimeSlot());
    }

    private ScheduleDTO convertToDTO(ScheduleEntity entity) {
        return new ScheduleDTO(entity.getClassId(), entity.getCourseId(), entity.getSubjectId(),
            entity.getLecturerId(), entity.getClassDate(), entity.getTimeSlot());
    }
}
