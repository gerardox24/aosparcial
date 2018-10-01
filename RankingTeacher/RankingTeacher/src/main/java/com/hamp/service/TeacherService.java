package com.hamp.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.hamp.entities.Teacher;
import com.hamp.repository.ITeacherRepository;

@Named
public class TeacherService implements ITeacherService,Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITeacherRepository teacherRepository;

	@Override
	public List<Teacher> findAllTeacher() throws Exception {
		return teacherRepository.findAll();
	}
}
