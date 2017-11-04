package com.example.tutorial07.dao;

import java.util.List;

import com.example.tutorial07.model.StudentModel;

public interface StudentDAO
{
StudentModel selectStudent (String npm);

	List<StudentModel> selectAllStudents ();
}