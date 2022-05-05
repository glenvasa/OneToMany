package com.perscholas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Students implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private int courseLoad;
	private String studentName;

	@ManyToOne
	private Schools Schools; // Hibernate by default uses Schools_did as column name to store foreign key.

	public Students(int sid, int courseLoad, String studentName) {
		this.sid = sid;
		this.courseLoad = courseLoad;
		this.studentName = studentName;
	}

	public Students() {
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCourseLoad() {
		return courseLoad;
	}

	public void setCourseLoad(int courseLoad) {
		this.courseLoad = courseLoad;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Schools getSchools() {
		return Schools;
	}

	public void setSchools(Schools schools) {
		Schools = schools;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
