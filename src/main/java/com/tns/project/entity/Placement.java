package com.tns.project.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Placement {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private long id;
	private String name;
	private LocalDate date;
	private String qualification;
	private int year;
	
	@ManyToOne
	@JoinColumn(name="college_id",referencedColumnName = "id")
	private College college;
	

	public Placement() {
		// TODO Auto-generated constructor stub
	}

	
	

	public Placement(long id, String name, LocalDate date, String qualification, int year, College college) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.qualification = qualification;
		this.year = year;
		this.college = college;
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


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
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
		return "Placement [id=" + id + ", name=" + name + ", date=" + date + ", qualification=" + qualification
				+ ", year=" + year + ", college=" + college + "]";
	}

	
	
	
	
}
