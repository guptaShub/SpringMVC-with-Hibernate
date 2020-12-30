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
public class InstructorDaoImpl implements InstructorDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Instructor> getInstructors() {
       
        Session session=sessionFactory.getCurrentSession();
        
        Query<Instructor> theQuery=session.createQuery("from Instructor order by lastName",Instructor.class);
        
        List<Instructor> list=theQuery.getResultList();
        
        return list;
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        
        Session session=sessionFactory.getCurrentSession();
        
        session.saveOrUpdate(instructor);
        
    }

    @Override
    public Instructor getInstructor(int instructorId) {
    
        Session session=sessionFactory.getCurrentSession();
        
        return session.get(Instructor.class,instructorId);
        
    }

    @Override
    public void deleteInstructor(int instructorId) {
    
        Session session=sessionFactory.getCurrentSession();
        
        Query<Instructor> theQuery=session.createQuery("delete from Instructor where id=:instructorId");
        
        theQuery.setParameter("instructorId",instructorId);
        
        theQuery.executeUpdate();
    }

    @Override
    @Transactional
    public void addCourseToInstructor(Course course, int instructorId) {
    
        Session session=sessionFactory.getCurrentSession();
        
        Instructor instructor=session.get(Instructor.class,instructorId);
        
        course.setInstructor(instructor);
        
        System.out.println(course);
        
        instructor.add(course);
        
        session.saveOrUpdate(course);
    }

    @Override
    @Transactional
    public void saveInstructorDetail(InstructorDetail instructorDetail, int instructorId) {
        
        
        System.out.println(instructorDetail);
        
        Session session=sessionFactory.getCurrentSession();
        
        Instructor instructor=session.get(Instructor.class,instructorId);
        
        instructor.setInstructorDetail(instructorDetail);
        
        session.save(instructorDetail);
        
    }
    
}
