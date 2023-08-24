package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int sId;
	
	@Column(name = "student_name")
	private String name;
	
	@Column(name = "student_email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)      
	@JoinColumn(name = "S_A_id", referencedColumnName="aId")  //  "aId" is PK of Address.class
	private Address address;
	
	/**
	 *  1. (cascade = CascadeType.ALL) if we use this then accordingly 
	 *     all the mapped date will be effected. Like on Delete operation 
	 *     the data will delete from mapped table. 
	 *  2. The PK of Address table becomes FK i.e S_A_id of Student table.
	 *  3. "S_A_id" column will be created in Student table.
	 */
	
	public int getId() {
		return sId;
	}
	public void setId(int sId) {
		this.sId = sId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + sId + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	
	

}
