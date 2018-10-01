package com.hamp.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.hamp.entities.Level;
import com.hamp.entities.Qualification;

import com.hamp.entities.Teacher;
import com.hamp.service.IQualificationService;
import com.hamp.service.ITeacherService;

@Named
@ViewScoped
public class QualificationController implements Serializable {

	private static final long serialVersionUID = 1L;

	// Services
	@Inject
	private ITeacherService teacherService;

	@Inject
	private IQualificationService qualificationService;

	

	// Teacher
	private Teacher teacherSelection;
	private Teacher teacher;
	private List<Teacher> teachers;

	// Qualification
	private Qualification qualification;

	
	// Score
	private Map<Teacher, Integer> scoreTeachers;

	@PostConstruct
	public void init() {
		// Teacher
		teachers = new ArrayList<>();
		teacherSelection = new Teacher();
		teacher = new Teacher();

		// Qualification
		qualification = new Qualification();

		// Score
		scoreTeachers = new HashMap<Teacher, Integer>();

		getAllTeacher();
		getLevels();

		goListScoreTeacher();

	}

	// Action

	public Level[] getLevels() {
		return Level.values();
	}

	public void cleanQualification() {
		qualification = new Qualification();
	}

	// Controller-Service
	public void getAllTeacher() {
		try {
			teachers = teacherService.findAllTeacher();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void goListScoreTeacher() {
		try {
			scoreTeachers = qualificationService.scoreTeacher();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String saveQualificationTeacher() {
		String rpta = "";

		try {
			if (this.teacherSelection != null && this.teacherSelection.getFirstName().length() >= 0) {
				this.teacher = this.teacherSelection;
				Qualification qualificationSearch = this.qualificationService
						.isQualificationStudent(qualification.getStudentTiu());

				if (qualificationSearch == null) {

					qualification.setTeacherId(teacher);
					qualificationService.saveQualification(qualification);
					cleanQualification();
					goListScoreTeacher();
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_INFO, "Save qualification", "Save qualification"));
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Student is qualification", "Student is qualification"));
				}

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Teacher not selected", "Teacher not selected"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), e.getMessage()));
		}
		return rpta;
	}

	// GET-SET
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Teacher getTeacherSelection() {
		return teacherSelection;
	}

	public void setTeacherSelection(Teacher teacherSelection) {
		this.teacherSelection = teacherSelection;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	
	public Map<Teacher, Integer> getScoreTeachers() {
		return scoreTeachers;
	}

	public void setScoreTeachers(Map<Teacher, Integer> scoreTeachers) {
		this.scoreTeachers = scoreTeachers;
	}

}
