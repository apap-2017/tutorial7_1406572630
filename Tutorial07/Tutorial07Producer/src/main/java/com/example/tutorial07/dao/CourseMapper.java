package com.example.tutorial07.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.tutorial07.model.CourseModel;
import com.example.tutorial07.model.StudentModel;

@Mapper
public interface CourseMapper {

	@Select("select id_course, name, credits from course where id_course=#{id_course}")
	@Results(value = {
		@Result(property="id_course", column="id_course"),
		@Result(property="name", column="name"),
		@Result(property="credits", column="credits"),
		@Result(property="students", column = "id_course",
			javaType = List.class,
			many = @Many(select="selectCourseById"))
	})
	CourseModel selectCourse ( @Param ("id_course") String id_course);
    
    @Select ("select studentcourse.id_course, student.name, student.npm, course.credits " +
    		"from studentcourse, student, course " +
    		"where studentcourse.id_course=#{id_course} " + 
    		"AND student.npm=studentcourse.npm AND course.id_course=studentcourse.id_course")
    List <StudentModel> selectCourseById (@Param("id_course") String id_course );
    
    @Select("SELECT course.id_course, name, credits " +
    		"FROM studentcourse join course " +
    		"ON studentcourse.id_course = course.id_course")
    List<CourseModel> selectAllCourses ();
    
}
