package com.tns.project.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class College {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private long id;
	private String collegeName;
	private String location;
	
	
	
	
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName = "id")
	private User user;
	
	
//	@OneToMany(mappedBy="college")
//	private List<Student> student;
//	
//	
//	
//	@OneToMany(mappedBy="college")
//	private List<Placement> placement;
//	
//	
//	@OneToMany(mappedBy="college")
//	private List<Certificate> certificate;
//	
//	
	
	public College() {
		// TODO Auto-generated constructor stub
	}



	


public College(long id, String collegeName, String location, User user) {
	super();
	this.id = id;
	this.collegeName = collegeName;
	this.location = location;
	this.user = user;
}






//	public College(long id, String collegeName, String location, User user, List<Student> student,
//			List<Placement> placement, List<Certificate> certificate) {
//		super();
//		this.id = id;
//		this.collegeName = collegeName;
//		this.location = location;
//		this.user = user;
//		this.student = student;
//		this.placement = placement;
//		this.certificate = certificate;
//	}
//





	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getCollegeName() {
		return collegeName;
	}



	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}






	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", location=" + location + ", user=" + user + "]";
	}



//	public List<Student> getStudent() {
//		return student;
//	}
//
//
//
//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}
//
//
//
//	public List<Placement> getPlacement() {
//		return placement;
//	}
//
//
//
//	public void setPlacement(List<Placement> placement) {
//		this.placement = placement;
//	}
//
//
//
//	public List<Certificate> getCertificate() {
//		return certificate;
//	}
//
//
//
//	public void setCertificate(List<Certificate> certificate) {
//		this.certificate = certificate;
//	}



//	@Override
//	public String toString() {
//		return "College [id=" + id + ", collegeName=" + collegeName + ", location=" + location + ", user=" + user
//				+ ", student=" + student + ", placement=" + placement + ", certificate=" + certificate + "]";
//	}
//	
	
	

}
