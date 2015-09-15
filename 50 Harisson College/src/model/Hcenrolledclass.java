package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the HCENROLLEDCLASS database table.
 * 
 */
@Entity
@NamedQuery(name="Hcenrolledclass.findAll", query="SELECT h FROM Hcenrolledclass h")
public class Hcenrolledclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal grade;

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

	public BigDecimal getGrade() {
		return this.grade;
	}

	public void setGrade(BigDecimal grade) {
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