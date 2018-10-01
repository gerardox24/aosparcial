package com.hamp.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.hamp.entities.Qualification;


@Named
public class QualificationRepository implements IQualificationRepository, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "VisorPU")
	private EntityManager em;

	@Transactional
	@Override
	public Qualification save(Qualification q) throws Exception {
		em.persist(q);
		return q;
	}

	@Override
	public Qualification isQualificationStudent(String studentTiu) throws Exception {
		List<Qualification> qualifications = new ArrayList<>();

		Qualification qualification = null;

		TypedQuery<Qualification> query = em.createQuery("SELECT q FROM Qualification q WHERE q.studentTiu=?1",
				Qualification.class);
		query.setParameter(1, studentTiu);
		qualifications = query.getResultList();

		if (qualifications != null && !qualifications.isEmpty()) {
			qualification = qualifications.get(0);
		}
		return qualification;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Qualification> findAll() throws Exception {
		List<Qualification> qualifications = new ArrayList<>();

		Query query = em.createQuery("SELECT q FROM Qualification q");
		qualifications = (List<Qualification>) query.getResultList();

		return qualifications;
	}

}
