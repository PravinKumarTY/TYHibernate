package com.tyss.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pencil")
public class Pencil {
	@Id
	@Column
	private int pid;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Column
	private String pencilBrand;
	@Column
	private String pencilColor;
	@Column
	private String pencilType;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="boxId")
	private PencilBox box;
	
	public String getPencilBrand() {
		return pencilBrand;
	}
	public void setPencilBrand(String pencilBrand) {
		this.pencilBrand = pencilBrand;
	}
	public String getPencilColor() {
		return pencilColor;
	}
	public void setPencilColor(String pencilColor) {
		this.pencilColor = pencilColor;
	}
	public String getPencilType() {
		return pencilType;
	}
	public void setPencilType(String pencilType) {
		this.pencilType = pencilType;
	}
}
