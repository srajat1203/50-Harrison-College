package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCCLASSROOM database table.
 * 
 */
@Entity
@Table(name="Hcclassroom", schema="TESTDB")
@NamedQuery(name="Hcclassroom.findAll", query="SELECT h FROM Hcclassroom h")
public class Hcclassroom implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String bldgname;

	private int maxcap;

	private int room;

	//bi-directional many-to-one association to Hcclass
	@OneToMany(mappedBy="hcclassroom")
	private List<Hcclass> hcclasses;

	public Hcclassroom() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBldgname() {
		return this.bldgname;
	}

	public void setBldgname(String bldgname) {
		this.bldgname = bldgname;
	}

	public int getMaxcap() {
		return this.maxcap;
	}

	public void setMaxcap(int maxcap) {
		this.maxcap = maxcap;
	}

	public int getRoom() {
		return this.room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public List<Hcclass> getHcclasses() {
		return this.hcclasses;
	}

	public void setHcclasses(List<Hcclass> hcclasses) {
		this.hcclasses = hcclasses;
	}

	public Hcclass addHcclass(Hcclass hcclass) {
		getHcclasses().add(hcclass);
		hcclass.setHcclassroom(this);

		return hcclass;
	}

	public Hcclass removeHcclass(Hcclass hcclass) {
		getHcclasses().remove(hcclass);
		hcclass.setHcclassroom(null);

		return hcclass;
	}

}