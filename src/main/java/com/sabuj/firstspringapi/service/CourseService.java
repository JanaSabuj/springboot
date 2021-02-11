package com.sabuj.firstspringapi.service;

import java.util.List;


import com.sabuj.firstspringapi.entity.Course;

public interface CourseService {
	public List<Course> getCourses(); 
	public Course getCourseById(long courseId);
	public Course postCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long courseId);
}
