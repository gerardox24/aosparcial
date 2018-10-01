package com.hamp.repository;

import java.util.List;

import com.hamp.entities.Teacher;

public interface ITeacherRepository {

	List<Teacher> findAll() throws Exception;

}
