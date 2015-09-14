package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the HCENROLLEDCLASS database table.
 * 
 */
@Entity
@Table(name="Hcenrolledclass", schema="TESTDB")
@NamedQuery(name="Hcenrolledclass.findAll", query="SELECT h FROM Hcenrolledclass h")
public class Hcenrolledclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private double grade;

	private String semester;

	//bi-directional many-to-one association to Hcclass
	@ManyToOne
	@JoinColumn(name="CLASSID")
	private Hcclass hcclass;

	//bi-directional many-to-one association to Hcuser
	@ManyToOne
	@JoinColumn(name="STUDENTID")
	private Hcuser hcuser;

	public Hcenrolledclass() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getGrade() {
		return this.grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public Hcclass getHcclass() {
		return this.hcclass;
	}

	public void setHcclass(Hcclass hcclass) {
		this.hcclass = hcclass;
	}

	public Hcuser getHcuser() {
		return this.hcuser;
	}

	public void setHcuser(Hcuser hcuser) {
		this.hcuser = hcuser;
	}

}