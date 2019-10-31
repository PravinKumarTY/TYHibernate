package com.tyss.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	@Column
	private String address;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="vid")
	private VoterIdCard voterId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public VoterIdCard getVoterId() {
		return voterId;
	}
	public void setVoterId(VoterIdCard voterId) {
		this.voterId = voterId;
	}
	
}
