package com.tns.project.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Certificate {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private long id;
	private int year;
	
	
	
	@ManyToOne
	@JoinColumn(name="college_id",referencedColumnName = "id")
	private College college;
	
//	@OneToOne(mappedBy="certificate")
//	private Student student;

	public Certificate() {
		// TODO Auto-generated constructor stub
	}
	
	

	

	public Certificate(long id, int year, College college) {
	super();
	this.id = id;
	this.year = year;
	this.college = college;
}





	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}





	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + ", college=" + college + "]";
	}
	
	
	
	
	
	
	

//	public Student getStudent() {
//		return student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Certificate [id=" + id + ", year=" + year + ", college=" + college + ", student=" + student + "]";
//	}
	
	
	
	

}
