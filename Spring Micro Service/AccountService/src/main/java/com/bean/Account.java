package com.bean;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accno;
	private String name;
	private float amount;
	
	/**
		{
			"accno": 101,
			"name": "Akhil",
			"amount": 64000
		}
	*/
	
//=============================================================================================================================

	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}

}


