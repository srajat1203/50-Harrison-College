package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the HCCLASS database table.
 * 
 */
@Entity
@Table(name="Hcclass", schema="TESTDB")
@NamedQuery(name="Hcclass.findAll", query="SELECT h FROM Hcclass h")
public class Hcclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long crn;

	private String daytime;

	@Column(name="\"ENABLE\"")
	private int enable;

	private String semester;

	//bi-directional many-to-one association to Hcclassroom
	@ManyToOne
	@JoinColumn(name="CLASSROOMNUM")
	private Hcclassroom hcclassroom;

	//bi-directional many-to-one association to Hccourse
	@ManyToOne
	@JoinColumn(name="COURSENUM")
	private Hccourse hccourse;

	//bi-directional many-to-one association to Hcuser
	@ManyToOne
	@JoinColumn(name="INSTRUCTORID")
	private Hcuser hcuser;

	//bi-directional many-to-one association to Hcenrolledclass
	@OneToMany(mappedBy="hcclass")
	private List<Hcenrolledclass> hcenrolledclasses;

	public Hcclass() {
	}

	public long getCrn() {
		return this.crn;
	}

	public void setCrn(long crn) {
		this.crn = crn;
	}

	public String getDaytime() {
		return this.daytime;
	}

	public void setDaytime(String daytime) {
		this.daytime = daytime;
	}

	public int getEnable() {
		return this.enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Hcclassroom getHcclassroom() {
		return this.hcclassroom;
	}

	public void setHcclassroom(Hcclassroom hcclassroom) {
		this.hcclassroom = hcclassroom;
	}

	public Hccourse getHccourse() {
		return this.hccourse;
	}

	public void setHccourse(Hccourse hccourse) {
		this.hccourse = hccourse;
	}

	public Hcuser getHcuser() {
		return this.hcuser;
	}

	public void setHcuser(Hcuser hcuser) {
		this.hcuser = hcuser;
	}

	public List<Hcenrolledclass> getHcenrolledclasses() {
		return this.hcenrolledclasses;
	}

	public void setHcenrolledclasses(List<Hcenrolledclass> hcenrolledclasses) {
		this.hcenrolledclasses = hcenrolledclasses;
	}

	public Hcenrolledclass addHcenrolledclass(Hcenrolledclass hcenrolledclass) {
		getHcenrolledclasses().add(hcenrolledclass);
		hcenrolledclass.setHcclass(this);

		return hcenrolledclass;
	}

	public Hcenrolledclass removeHcenrolledclass(Hcenrolledclass hcenrolledclass) {
		getHcenrolledclasses().remove(hcenrolledclass);
		hcenrolledclass.setHcclass(null);

		return hcenrolledclass;
	}

}