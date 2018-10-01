package com.hamp.service;

import java.util.List;

import com.hamp.entities.Teacher;

public interface ITeacherService {
	List<Teacher> findAllTeacher() throws Exception;

}
