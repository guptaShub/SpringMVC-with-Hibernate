/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.controller;

import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Instructor;
import com.wipro.springmvc.entity.InstructorDetail;
import com.wipro.springmvc.service.CourseService;
import com.wipro.springmvc.service.InstructorService;
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
@RequestMapping("/instructor")
public class InstructorController {
    
    @Autowired
    private InstructorService instructorService;
    
    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String listInstructors(Model theModel){
        
      //  theModel.addAttribute("message","Shubham");
        theModel.addAttribute("instructor",instructorService.getInstructors());
        
        return "list-instructor";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        theModel.addAttribute("instructor",new Instructor());
        
        return "instructor-form";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("instructorId")int instructorId,Model theModel){
        
        Instructor instructor=instructorService.getInstructor(instructorId);
        
        theModel.addAttribute(instructor);
        
        return "instructor-form";
    }
    
    @PostMapping("/saveInstructor")
    public String saveInstructor(@ModelAttribute("instructor")Instructor instructor){
        
        instructorService.saveInstructor(instructor);
        
        return "redirect:/instructor/list";
        
    }
    
    @GetMapping("/deleteInstructor")
    public String deleteInstructor(@RequestParam("instructorId")int instructorId){
        
        instructorService.deleteInstructor(instructorId);
        
        return "redirect:/instructor/list";
    }
    
    @GetMapping("/view")
    public String viewInstructorDetails(@RequestParam("instructorId")int instructorId,Model theModel){
        
        Instructor instructor=instructorService.getInstructor(instructorId);
        
        theModel.addAttribute("instructor",instructor);
        
        theModel.addAttribute("instructorDetail",instructor.getInstructorDetail());
        
        theModel.addAttribute("courses",instructor.getCourses());
        
        return "view-instructor";
        
    }
    
    @PostMapping("/addCourseToInstructor")
    public String addCourseToInstructor(@ModelAttribute("course")Course course,@RequestParam("instructorId")int instructorId){
        
        Course c1=courseService.getCourse(course.getId());
        
        instructorService.addCourseToInstructor(c1,instructorId);
        
        return "redirect:/instructor/list";
    }
    
    @GetMapping("/showFormForAddCourse")
    public String showFormForAddCourse(@RequestParam("instructorId") int instructorId,Model theModel)
    {
        
       theModel.addAttribute("course",new Course());
        
        theModel.addAttribute("courses",courseService.getFreeCourses());
        
        theModel.addAttribute("instructorId",instructorId);
        
        return "add-course-instructor";
    }
    
    @GetMapping("/showFormForUpdateInstructorDetail")
    public String showFormForUpdateInstructorDetail(@RequestParam("instructorId")int instructorId,Model theModel)
    {
        Instructor instructor=instructorService.getInstructor(instructorId);
        
        if(instructor.getInstructorDetail()!=null)
        theModel.addAttribute("instructorDetail",instructor.getInstructorDetail());
        else
            theModel.addAttribute("instructorDetail",new InstructorDetail());
        
        theModel.addAttribute("instructorId",instructorId);
        
        return "instructor-detail-form";
    }
    
   @PostMapping("/saveInstructorDetail")
    public String saveInstructor(@ModelAttribute("instructorDetail")InstructorDetail instructorDetail,@RequestParam("instructorId")int instructorId){
        
        instructorService.saveInstructorDetail(instructorDetail,instructorId);
        
        return "redirect:/instructor/list";
        
    }
    
    
}
