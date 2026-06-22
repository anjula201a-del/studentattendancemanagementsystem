package lk.ijse.studentattendancemanagementsystem.BO.custom;


import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.SuperBO;
import lk.ijse.studentattendancemanagementsystem.dto.CoursemanagementDTO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author ACER
 */
public interface CoursemanagementBO extends SuperBO {
    boolean addCourseWithSubject(CoursemanagementDTO dto) throws Exception;
    boolean editCourseWithSubject(CoursemanagementDTO dto) throws Exception;
    boolean deleteCourse(String courseId) throws Exception;
    List<CoursemanagementDTO> getAllCoursesWithSubjects() throws Exception;
    
}
