/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.service;

import com.wipro.springmvc.dao.InstructorDao;
import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Instructor;
import com.wipro.springmvc.entity.InstructorDetail;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shubham
 */

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorDao instructorDao;
    
    @Override
    @Transactional
    public List<Instructor> getInstructors() {
        return instructorDao.getInstructors();
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    @Transactional
    public Instructor getInstructor(int instructorId) {
        return instructorDao.getInstructor(instructorId);
    }

    @Override
    @Transactional
    public void deleteInstructor(int instructorId) {
        instructorDao.deleteInstructor(instructorId);
    }

    @Override
    @Transactional
    public void addCourseToInstructor(Course course, int instructorId) {
        instructorDao.addCourseToInstructor(course,instructorId);
    }

    @Override
    public void saveInstructorDetail(InstructorDetail instructorDetail, int instructorId) {
        instructorDao.saveInstructorDetail(instructorDetail,instructorId);
    }
    
}
