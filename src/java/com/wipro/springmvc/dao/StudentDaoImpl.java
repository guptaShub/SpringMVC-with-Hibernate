/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.dao;

import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shubham
 */
@Repository
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Student> getStudents() {
        
        Session session=sessionFactory.getCurrentSession();
        
        Query<Student> theQuery=session.createQuery("from Student",Student.class);
        
        List<Student> list=theQuery.getResultList();
        
        return list;
    }

    @Override
    public void saveStudent(Student student) {
        
        Session session=sessionFactory.getCurrentSession();
        
        session.saveOrUpdate(student);
        
    }

    @Override
    public Student getStudent(int studentId) {
        
        Session session=sessionFactory.getCurrentSession();
        
        Student student=session.get(Student.class,studentId);
        System.out.println(student.getCourses());
        
        return student;
        
    }

    @Override
    public void deleteStudent(int studentId) {
        
        Session session=sessionFactory.getCurrentSession();
        
        Query<Student> theQuery=session.createQuery("delete from Student where id=:studentId");
        
        theQuery.setParameter("studentId",studentId);
        
        theQuery.executeUpdate();
        
    }

    @Override
    @Transactional
    public void addCourseToStudent(Course course, int studentId) {
        
        Session session=sessionFactory.getCurrentSession();
        
        Student student=session.get(Student.class,studentId);
        
        student.addCourse(course);
        
        session.save(student);
    }

    @Override
    public List<Course> getCoursesOnStudentId(int studentId) {
        
        Session session=sessionFactory.getCurrentSession();
        
        //Query<Course> theQuery=session.createQuery("from Course where ")
        return null;
    }
    
}
