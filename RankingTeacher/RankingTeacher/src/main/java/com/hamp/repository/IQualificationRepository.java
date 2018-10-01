package com.hamp.repository;

import java.util.List;

import com.hamp.entities.Qualification;

public interface IQualificationRepository {

	Qualification save(Qualification q) throws Exception;

	Qualification isQualificationStudent(String studentTiu) throws Exception;

	List<Qualification> findAll() throws Exception;

}
