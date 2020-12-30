/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.service;

import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Review;
import java.util.List;

/**
 *
 * @author Shubham
 */
public interface CourseService {
  
    public List<Course> getCourses();
    
    public void saveCourse(Course course);
    
    public Course getCourse(int courseId);
    
    public void deleteCourse(int courseId);
    
     public List<Review> getReviews(int courseId);
     
     public void addReviewToCourse(Review review,int courseId);
     
     public List<Course> getFreeCourses();
     
     
}
