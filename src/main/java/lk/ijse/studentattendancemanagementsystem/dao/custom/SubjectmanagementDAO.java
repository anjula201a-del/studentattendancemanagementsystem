/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao.custom;

import java.util.List;
import lk.ijse.studentattendancemanagementsystem.dao.SuperDAO;
import lk.ijse.studentattendancemanagementsystem.entity.SubjectmanagementEntity;

/**
 *
 * @author ACER
 */
public interface SubjectmanagementDAO extends SuperDAO{
    boolean add(SubjectmanagementEntity entity) throws Exception;
    boolean edit(SubjectmanagementEntity entity) throws Exception;
    boolean delete(String id) throws Exception;
    List<SubjectmanagementEntity> getAll() throws Exception;
}
    

