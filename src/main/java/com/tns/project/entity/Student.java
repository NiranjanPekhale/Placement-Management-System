package com.tns.project.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private long id;
	private String name;
	private long role;
	private String qualification;
	private String course;
	private int year;
	private long hallTicketNo;
	
	@ManyToOne	
	@JoinColumn(name="college_id",referencedColumnName = "id")
	private College college;
	
	
	@OneToOne
	@JoinColumn(name="certificate_id",referencedColumnName = "id")
	private Certificate certificate;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	


	public Student(long id, String name, long role, String qualification, String course, int year, long hallTicketNo,
			College college, Certificate certificate) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.qualification = qualification;
		this.course = course;
		this.year = year;
		this.hallTicketNo = hallTicketNo;
		this.college = college;
		this.certificate = certificate;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getRole() {
		return role;
	}


	public void setRole(long role) {
		this.role = role;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public long getHallTicketNo() {
		return hallTicketNo;
	}


	public void setHallTicketNo(long hallTicketNo) {
		this.hallTicketNo = hallTicketNo;
	}


	public College getCollege() {
		return college;
	}


	public void setCollege(College college) {
		this.college = college;
	}


	public Certificate getCertificate() {
		return certificate;
	}


	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", role=" + role + ", qualification=" + qualification
				+ ", course=" + course + ", year=" + year + ", hallTicketNo=" + hallTicketNo + ", college=" + college
				+ ", certificate=" + certificate + "]";
	}
	
	
	

}
