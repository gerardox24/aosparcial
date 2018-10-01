package com.hamp.service;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import com.hamp.entities.Level;
import com.hamp.entities.Qualification;
import com.hamp.entities.Teacher;
import com.hamp.repository.IQualificationRepository;

import java.util.Map;
import java.util.stream.Collectors;

@Named
public class QualificationService implements IQualificationService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IQualificationRepository qualificationRepository;

	@Override
	public Qualification saveQualification(Qualification q) throws Exception {

		int score = scoreQualification(q.getLevel());
		q.setScore(score);

		return qualificationRepository.save(q);
	}

	@Override
	public Qualification isQualificationStudent(String studenTiu) throws Exception {

		return qualificationRepository.isQualificationStudent(studenTiu);
	}

	private int scoreQualification(Level level) {
		int score = 0;

		switch (level) {
		case LEVEL1:
			score = 5;
			break;

		case LEVEL2:
			score = 4;
			break;
		case LEVEL3:
			score = 3;
			break;
		case LEVEL4:
			score = 2;
			break;
		case LEVEL5:
			score = 1;
			break;
		default:
			break;

		}

		return score;
	}

	@Override
	public Map<Teacher, Integer> scoreTeacher() throws Exception {
		Map<Teacher, Integer> sumScoreByTeacher = qualificationRepository.findAll().stream().collect(
				Collectors.groupingBy(Qualification::getTeacherId, Collectors.summingInt(Qualification::getScore)));

		return sumScoreByTeacher;

	}

}
