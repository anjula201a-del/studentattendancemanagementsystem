/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.dao.SuperDAO;
import lk.ijse.studentattendancemanagementsystem.entity.ScheduleEntity;

/**
 *
 * @author ACER
 */
public interface ScheduleDAO extends SuperDAO {
    boolean add(ScheduleEntity entity) throws Exception;
    boolean edit(ScheduleEntity entity) throws Exception;
    boolean delete(String id) throws Exception;
    List<ScheduleEntity> getAll() throws Exception;
}
