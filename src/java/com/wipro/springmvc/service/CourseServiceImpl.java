/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.service;

import com.wipro.springmvc.dao.CourseDao;
import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Review;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shubham
 */

@Service
public class CourseServiceImpl implements CourseService{
    
    @Autowired
    private CourseDao courseDao;

    @Override
    @Transactional
    public List<Course> getCourses() {
       return courseDao.getCourses();
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        courseDao.saveCourse(course);
    }

    @Override
    @Transactional
    public Course getCourse(int courseId) {
       return courseDao.getCourse(courseId);
    }

    @Override
    @Transactional
    public void deleteCourse(int courseId) {
       courseDao.deleteCourse(courseId);
    }

    @Override
    @Transactional
    public List<Review> getReviews(int courseId) {
    
        return courseDao.getReviews(courseId);
    }

    @Override
    @Transactional
    public void addReviewToCourse(Review review, int courseId) {
        
        courseDao.addReviewToCourse(review,courseId);
    }

    @Override
    @Transactional
    public List<Course> getFreeCourses() {
        return courseDao.getFreeCourses();
    }
    
    
}
