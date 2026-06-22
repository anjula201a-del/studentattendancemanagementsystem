/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.dao;

import lk.ijse.studentattendancemanagementsystem.dao.custom.impl.AttendanceDAOimpl;
import lk.ijse.studentattendancemanagementsystem.dao.custom.impl.CoursemanagementDAOimpl;
import lk.ijse.studentattendancemanagementsystem.dao.custom.impl.LecturermanagementDAOimpl;
import lk.ijse.studentattendancemanagementsystem.dao.custom.impl.ScheduleDAOimpl;
import lk.ijse.studentattendancemanagementsystem.dao.custom.impl.StudentmanagementDAOimpl;
import lk.ijse.studentattendancemanagementsystem.dao.custom.impl.SubjectmanagementDAOimpl;

/**
 * @author ACER
 */
public class DAOFactory {
    private static DAOFactory df;
    
    private DAOFactory() {
    }
    
    public static enum DAOTypes {
       STUDENT, LECTURER , COURSE ,SUBJECT, SCHEDULE,ATTENDANCE
    }
    
    public static DAOFactory getInstance() {
        return (df == null) ? df = new DAOFactory() : df;
    }
    
    public SuperDAO getDAO(DAOTypes type) {
        switch(type) {
           
            case STUDENT:
                return new StudentmanagementDAOimpl();
                
            
            case LECTURER:  
                return new LecturermanagementDAOimpl();
                
            case COURSE:  
                return new CoursemanagementDAOimpl();
                
            case SUBJECT:  
                return new SubjectmanagementDAOimpl();
                
                                
            case SCHEDULE:  
                return new ScheduleDAOimpl();
                
             case ATTENDANCE:  
                return new AttendanceDAOimpl();    
                
           
            default:
                return null;
        }
    }
}