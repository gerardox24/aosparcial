package com.hamp.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rankings")
public class Qualification implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "score", nullable = false)
	private Integer score;

	@Column(name = "level", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Level level;

	@Column(name = "student_tiu", nullable = false, length = 10)
	private String studentTiu;

	@ManyToOne
	@JoinColumn(name = "teacher_id", nullable = false)
	private Teacher teacherId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Teacher getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Teacher teacherId) {
		this.teacherId = teacherId;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getStudentTiu() {
		return studentTiu;
	}

	public void setStudentTiu(String studentTiu) {
		this.studentTiu = studentTiu;
	}
	
	

}
