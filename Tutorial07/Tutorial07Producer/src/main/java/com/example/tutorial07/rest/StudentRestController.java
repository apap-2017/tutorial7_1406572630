package com.example.tutorial07.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorial07.model.CourseModel;
import com.example.tutorial07.model.StudentModel;
import com.example.tutorial07.service.StudentService;
import com.example.tutorial07.service.CourseService;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;

	@RequestMapping("/student/view/{npm}")
	public StudentModel view(@PathVariable(value = "npm") String npm) {
		StudentModel student = studentService.selectStudent(npm);
		return student;
	}
	
	@RequestMapping ( "/student/viewall")
	public List<StudentModel> viewall () {
		List<StudentModel> students = studentService.selectAllStudents ();
        return students;
	}
	
	@RequestMapping ( "/course/view/{id}")
	public CourseModel viewCourse ( @PathVariable ( value = "id" ) String id) {
			CourseModel course = courseService.selectCourse(id);
		return course;
	}
	
	@RequestMapping ( "/course/viewall")
	public List<CourseModel> viewAllCourses() {
		List<CourseModel> courses = courseService.selectAllCourses();
        return courses;
	}
	
}
