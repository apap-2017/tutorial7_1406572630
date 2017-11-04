package com.example.tutorial07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorial07.dao.CourseMapper;
import com.example.tutorial07.model.CourseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CourseService {
	
	@Autowired
    private CourseMapper courseMapper;
	
	public CourseModel selectCourse (String id_course) {
    	log.info ("select course by ID {}", id_course);
        return courseMapper.selectCourse (id_course);
    }
	
	public List<CourseModel> selectAllCourses ()
    {
        log.info ("select all courses");
        return courseMapper.selectAllCourses();
    }
}
