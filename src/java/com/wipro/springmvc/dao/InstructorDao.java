/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.dao;

import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Instructor;
import com.wipro.springmvc.entity.InstructorDetail;
import java.util.List;

/**
 *
 * @author Shubham
 */
public interface InstructorDao {
    
    public List<Instructor> getInstructors();
    
    public void saveInstructor(Instructor instructor);
    
    public Instructor getInstructor(int instructorId);
    
    public void deleteInstructor(int instructorId);
    
    public void addCourseToInstructor(Course course,int instructorId);
    
    public void saveInstructorDetail(InstructorDetail instructorDetail, int instructorId);
}
