/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wipro.springmvc.dao;

import com.wipro.springmvc.entity.Course;
import com.wipro.springmvc.entity.Review;
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
public class CourseDaoImpl implements CourseDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Course> getCourses() {
       
        Session session=sessionFactory.getCurrentSession();
        
        Query<Course> theQuery=session.createQuery("from Course",Course.class);
        
        List<Course> list=theQuery.getResultList();
        
        return list;
        
    }

    @Override
    public void saveCourse(Course course) {
        
        Session session=sessionFactory.getCurrentSession();
        
        session.saveOrUpdate(course);
        
    }

    @Override
    public Course getCourse(int courseId) {
        
        Session session=sessionFactory.getCurrentSession();
        
        return session.get(Course.class,courseId);
        
    }

    @Override
    public void deleteCourse(int courseId) {
      
        Session session=sessionFactory.getCurrentSession();
        
        Query<Course> theQuery=session.createQuery("delete from Course where id=:courseId");
        
        theQuery.setParameter("courseId",courseId);
        
        theQuery.executeUpdate();
    }

    @Override
    public List<Review> getReviews(int id) {

        Session session=sessionFactory.getCurrentSession();
        
        Query<Review> theQuery=session.createQuery("from Review where course_id=:id",Review.class);
        
        theQuery.setParameter("id", id);
        
        return theQuery.getResultList();
    }

    
    @Override
    @Transactional
    public void addReviewToCourse(Review review, int courseId) {
        
        Session session=sessionFactory.getCurrentSession();
        
         Course c=session.get(Course.class,courseId);
         
         c.add(review);
         
         session.save(c);
       
    }

    @Override
    public List<Course> getFreeCourses() {
    
        Session session=sessionFactory.getCurrentSession();
        
        Query<Course> theQuery=session.createQuery("from Course where instructor_id is null",Course.class);
       
        List<Course> list=theQuery.getResultList();
        
        return list;
    }

   
    
}
