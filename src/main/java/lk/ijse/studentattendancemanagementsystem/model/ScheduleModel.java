/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.model;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.BOFactory;
import lk.ijse.studentattendancemanagementsystem.BO.custom.impl.ScheduleBO;
import lk.ijse.studentattendancemanagementsystem.dto.ScheduleDTO;

/**
 *
 * @author ACER
 */
public class ScheduleModel {
     ScheduleBO scheduleBO =
        (ScheduleBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SCHEDULE);

    public boolean addSchedule(ScheduleDTO dto) throws Exception {
        return scheduleBO.addSchedule(dto);
    }

    public boolean editSchedule(ScheduleDTO dto) throws Exception {
        return scheduleBO.editSchedule(dto);
    }

    public boolean deleteSchedule(String id) throws Exception {
        return scheduleBO.deleteSchedule(id);
    }

    public List<ScheduleDTO> getSchedules() throws Exception {
        return scheduleBO.getAllSchedules();
    }
}
