package com.example.tutorial07.dao;

import java.util.List;

import com.example.tutorial07.model.CourseModel;


public interface CourseDAO {
	
	
	CourseModel selectCourse (String id);
	List <CourseModel> selectAllCourses();
}
