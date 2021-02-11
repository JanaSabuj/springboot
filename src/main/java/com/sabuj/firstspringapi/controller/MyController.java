package com.sabuj.firstspringapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sabuj.firstspringapi.entity.Course;
import com.sabuj.firstspringapi.service.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService cse;
	
	// test endpoint
	@GetMapping("/home")
	public String home() {
		return "This is my home - test endpoint";
	}
	
	//get all courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.cse.getCourses();
	}
	
	//get course by id
	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable String courseId) {
		return this.cse.getCourseById(Long.parseLong(courseId));
	}
	
	//post courses
	@PostMapping(path = "/courses", consumes = "application/json")
	public Course postCourse(@RequestBody Course course) {
		return this.cse.postCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.cse.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.cse.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
