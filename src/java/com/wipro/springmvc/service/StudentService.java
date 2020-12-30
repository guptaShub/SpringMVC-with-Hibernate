/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.service;

import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Student;
import java.util.List;

/**
 *
 * @author Shubham
 */
public interface StudentService {
    
    public List<Student> getStudents();
    
    public void saveStudent(Student student);
    
    public Student getStudent(int studentId);
    
    public void deleteStudent(int studentId);
 
    public void addCourseToStudent(Course course,int studentId);
}
