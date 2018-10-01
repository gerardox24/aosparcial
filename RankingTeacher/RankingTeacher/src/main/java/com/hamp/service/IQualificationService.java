package com.hamp.service;

import java.util.Map;

import com.hamp.entities.Qualification;
import com.hamp.entities.Teacher;

public interface IQualificationService {

	Qualification saveQualification(Qualification q) throws Exception;

	Qualification isQualificationStudent(String studenTiu) throws Exception;

	Map<Teacher, Integer> scoreTeacher() throws Exception;

}
