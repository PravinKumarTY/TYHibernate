package com.tyss.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="Student_table")
public class Student {
	@Id
	@Column
	private int sid;
	@Column
	private String sname;
	@Column
	private String sAddress;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_cources",joinColumns=@JoinColumn(name="sid"),
	inverseJoinColumns=@JoinColumn(name="cid"))
	private List<Cources> courcesList;
	public List<Cources> getCourcesList() {
		return courcesList;
	}
	public void setCourcesList(List<Cources> courcesList) {
		this.courcesList = courcesList;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

}
