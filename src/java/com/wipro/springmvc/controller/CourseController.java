/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.controller;

import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Review;
import com.wipro.springmvc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Shubham
 */

@Controller
@RequestMapping("/course")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String listCourses(Model theModel){
        
        theModel.addAttribute("course",courseService.getCourses());
        
        return "list-course";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        theModel.addAttribute("course",new Course());
        
        return "course-form";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId")int courseId,Model theModel){
        
        Course course=courseService.getCourse(courseId);
        
        theModel.addAttribute(course);
        
        return "course-form";
    }
    
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course")Course course){
        
        courseService.saveCourse(course);
        
        return "redirect:/course/list";
        
    }
    
    @GetMapping("/deleteCourse")
    public String deleteCourse(@RequestParam("courseId")int courseId){
        
        courseService.deleteCourse(courseId);
        
        return "redirect:/course/list";
    }
    
    @GetMapping("/view")
    public String viewCourseDetails(@RequestParam("courseId")int courseId,Model theModel)
    {
      Course course=courseService.getCourse(courseId);
      
      theModel.addAttribute("course",course);
      
      theModel.addAttribute("instructor",course.getInstructor());
      
      theModel.addAttribute("review",courseService.getReviews(courseId));
      
    //  theModel.addAttribute("students",course.getStudents());
      
      return "view-course";
    }
    
    @PostMapping("/addReview")
    public String addReview(@ModelAttribute("review")Review review)
    {
        int id=review.getId();
        review.setId(0);
        courseService.addReviewToCourse(review,id);
        
        return "redirect:/course/list";
    }
    
    @GetMapping("/showFormForReview")
    public String showFormForReview(@RequestParam("courseId")int courseId,Model theModel)
    {
        Review review=new Review();
        
        review.setId(courseId);
        
        theModel.addAttribute("review",review);
        
        return "add-review";
    }
    
}
