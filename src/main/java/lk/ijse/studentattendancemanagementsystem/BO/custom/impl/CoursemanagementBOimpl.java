/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.ijse.studentattendancemanagementsystem.BO.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.studentattendancemanagementsystem.BO.custom.CoursemanagementBO;
import lk.ijse.studentattendancemanagementsystem.dao.CrudUtil;
import lk.ijse.studentattendancemanagementsystem.dao.DAOFactory;
import lk.ijse.studentattendancemanagementsystem.dao.custom.CoursemanagementDAO;
import lk.ijse.studentattendancemanagementsystem.dao.custom.SubjectmanagementDAO;
import lk.ijse.studentattendancemanagementsystem.dto.CoursemanagementDTO;
import lk.ijse.studentattendancemanagementsystem.entity.CoursemanagementEntity;
import lk.ijse.studentattendancemanagementsystem.entity.SubjectmanagementEntity;

/**
 *
 * @author ACER
 */
public class CoursemanagementBOimpl implements CoursemanagementBO {
    private final CoursemanagementDAO coursemanagementDAO = (CoursemanagementDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COURSE);
    private final SubjectmanagementDAO subjectmanagementDAO = (SubjectmanagementDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SUBJECT);

    @Override
    public boolean addCourseWithSubject(CoursemanagementDTO dto) throws Exception {
        
        boolean isCourseSaved = coursemanagementDAO.add(new CoursemanagementEntity(dto.getCourseId(), dto.getCourseName(), dto.getDuration(), dto.getCourseFee()));
        if (isCourseSaved) {
            return subjectmanagementDAO.add(new SubjectmanagementEntity(dto.getSubId(), dto.getSubName(), dto.getCourseId()));
        }
        return false;
    }

    @Override
    public boolean editCourseWithSubject(CoursemanagementDTO dto) throws Exception {
        boolean isCourseUpdated = coursemanagementDAO.edit(new CoursemanagementEntity(dto.getCourseId(), dto.getCourseName(), dto.getDuration(), dto.getCourseFee()));
        if (isCourseUpdated) {
            return subjectmanagementDAO.edit(new SubjectmanagementEntity(dto.getSubId(), dto.getSubName(), dto.getCourseId()));
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String courseId) throws Exception {
      
        return coursemanagementDAO.delete(courseId);
    }

    @Override
    public List<CoursemanagementDTO> getAllCoursesWithSubjects() throws Exception {
        List<CoursemanagementDTO> viewList = new ArrayList<>();
        
      
        String sql = "SELECT c.course_id, c.course_name, c.duration, c.course_fee, s.subject_id, s.subject_name " +
                     "FROM course c LEFT JOIN subject s ON c.course_id = s.course_id";
        
        ResultSet rst = CrudUtil.executeQuery(sql);
        while(rst.next()) {
            viewList.add(new CoursemanagementDTO(
                rst.getString("course_id"),
                rst.getString("course_name"),
                rst.getString("duration"),
                rst.getBigDecimal("course_fee"),
                rst.getString("subject_id"),
                rst.getString("subject_name")
            ));
        }
        return viewList;
    }
    
}
