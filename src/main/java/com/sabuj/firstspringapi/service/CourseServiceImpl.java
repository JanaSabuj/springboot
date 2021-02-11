package com.sabuj.firstspringapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sabuj.firstspringapi.dao.CourseDao;
import com.sabuj.firstspringapi.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {	
	
	@Autowired
	private CourseDao cdao;

	public CourseServiceImpl() {
		super();
	}

	@Override
	public List<Course> getCourses() {
		return cdao.findAll();
	}


	@Override
	public Course getCourseById(long courseId) {			
		return cdao.findById(courseId).get();
	}

	@Override
	public Course postCourse(Course course) {		 
		cdao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {		
		return cdao.save(course);
	}

	@Override
	public void deleteCourse(long courseId) {
		 cdao.delete(cdao.getOne(courseId));
	} 
}
