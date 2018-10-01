package com.hamp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.hamp.entities.Teacher;

@Named
public class TeacherRepository implements Serializable, ITeacherRepository {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "VisorPU")
	private EntityManager em;

	@Override
	public List<Teacher> findAll() throws Exception {
		List<Teacher> teachers = new ArrayList<>();

		TypedQuery<Teacher> query = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
		teachers = query.getResultList();

		return teachers;
	}

}
