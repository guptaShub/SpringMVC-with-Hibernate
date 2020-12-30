/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.service;

import com.wipro.springmvc.dao.StudentDao;
import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shubham
 */

@Service
public class StudentServiceImpl implements StudentService{
    
    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentDao.saveStudent(student);
    }

    @Override
    @Transactional
    public Student getStudent(int studentId) {
        return studentDao.getStudent(studentId);
    }

    @Override
    @Transactional
    public void deleteStudent(int studentId) {
        studentDao.deleteStudent(studentId);
    }

    @Override
    public void addCourseToStudent(Course course, int studentId) {
        studentDao.addCourseToStudent(course,studentId);
    }

    
}
