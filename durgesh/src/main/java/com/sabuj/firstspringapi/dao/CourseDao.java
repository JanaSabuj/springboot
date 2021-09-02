package com.sabuj.firstspringapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabuj.firstspringapi.entity.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {

}
