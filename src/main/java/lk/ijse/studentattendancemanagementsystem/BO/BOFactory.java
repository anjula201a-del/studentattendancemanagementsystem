/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO;

import lk.ijse.studentattendancemanagementsystem.BO.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getInstance() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        STUDENT, LECTURER, COURSE,SCHEDULE, ATTENDANCE
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case COURSE:
                return new CoursemanagementBOimpl(); 
            case STUDENT:
                return new StudentmanagementBOimpl();
            case LECTURER:
                return new LecturermanagementBOimpl();
                
            case SCHEDULE:
                return new ScheduleBOimpl(); 
                
            case ATTENDANCE:
                return new AttendanceBOimpl();     
            
            default:
                return null;
        }
    }
}