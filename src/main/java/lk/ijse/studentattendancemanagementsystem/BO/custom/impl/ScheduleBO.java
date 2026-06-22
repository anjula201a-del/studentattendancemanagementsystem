/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom.impl;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.SuperBO;
import lk.ijse.studentattendancemanagementsystem.dto.ScheduleDTO;

/**
 *
 * @author ACER
 */
public interface ScheduleBO  extends SuperBO{
    boolean addSchedule(ScheduleDTO dto) throws Exception;
    boolean editSchedule(ScheduleDTO dto) throws Exception;
    boolean deleteSchedule(String id) throws Exception;
    List<ScheduleDTO> getAllSchedules() throws Exception;
}
