package com.perscholas.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Departments implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int did;
	private String dname;

	@OneToMany(targetEntity = Teachers.class, cascade = { CascadeType.ALL })
	private List teacherList; // Hibernate creates a department_teachers junction table that contains
	// teacherList_tid (referencing teachers.tid) and Departments_did primary key
	// (referencing departments.did) as foreign keys to represent the One to Many
	// relationship.

	public Departments(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	public Departments() {

	}

	public List getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List teacherList) {
		this.teacherList = teacherList;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}
}
