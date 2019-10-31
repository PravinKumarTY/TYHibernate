package com.tyss.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="pencil_box")
public class PencilBox {
	@Id
	@Column
	private int boxId;
	@Column
	private String boxName;
	@OneToMany(mappedBy="box",cascade=CascadeType.ALL)
	@JoinColumn(name="boxId")
	private List<Pencil> listOfPencils;
	public int getBoxId() {
		return boxId;
	}
	public void setBoxId(int boxId) {
		this.boxId = boxId;
	}
	public String getBoxName() {
		return boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public List<Pencil> getListOfPencils() {
		return listOfPencils;
	}
	public void setListOfPencils(List<Pencil> listOfPencils) {
		this.listOfPencils = listOfPencils;
	}
}
