/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.controller;

import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Instructor;
import com.wipro.springmvc.entity.Student;
import com.wipro.springmvc.service.CourseService;
import com.wipro.springmvc.service.StudentService;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private CourseService courseService;
    
    @GetMapping("/list")
    public String listStudents(Model theModel){
        
        theModel.addAttribute("student",studentService.getStudents());
                
        return "list-student";
    }
    
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel)
    {
        theModel.addAttribute("student",new Student());
        
        return "student-form";
    }
    
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId")int studentId,Model theModel){
        
        Student student=studentService.getStudent(studentId);
        
        theModel.addAttribute(student);
        
        return "student-form";
    }
    
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        
        studentService.saveStudent(student);
        
        return "redirect:/student/list";
        
    }
    
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId")int studentId){
        
        studentService.deleteStudent(studentId);
        
        return "redirect:/student/list";
    }
    
    @GetMapping("/view")
    public String viewStudentDetail(@RequestParam("studentId")int studentId,Model theModel)
    {
        Student student=studentService.getStudent(studentId);
        
        System.out.println(student);
        
        theModel.addAttribute("student", student);
        
        theModel.addAttribute("courses",student.getCourses());
        
        return "view-student";
    }
    
    @PostMapping("/addCourseToStudent")
    public String addCourseToStudent(@ModelAttribute("course")Course course,@RequestParam("studentId")int studentId)
    {
        studentService.addCourseToStudent(course,studentId);
        
        return "redirect:/student/list";
    }
    
    @GetMapping("/showFormForAddCourse")
    public String showFormForAddCourse(@RequestParam("studentId") int studentId,Model theModel)
    {
        Student student=studentService.getStudent(studentId);
        List<Course> c1=student.getCourses();
        
        List<Course> c2=courseService.getCourses();
        
        List<Course> c3=new ArrayList<Course>();
        for(int i=0;i<c2.size();i++)
        {
            int flag=0;
            for(int j=0;j<c1.size();j++)
            {
                if(c1.get(j).getId()==c2.get(i).getId())
                {
                    flag=1;
                }
                
            }
            if(flag!=1)
                    c3.add(c2.get(i));
        }
        theModel.addAttribute("course",new Course());
        
        theModel.addAttribute("courses",c3);
        
        theModel.addAttribute("studentId",studentId);
        
        return "add-course-student";
    }
    
    
}
