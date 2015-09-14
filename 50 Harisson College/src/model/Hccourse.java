package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCCOURSE database table.
 * 
 */
@Entity
@Table(name="HCCOURSE", schema = "testdb")
@NamedQuery(name="Hccourse.findAll", query="SELECT h FROM Hccourse h")
public class Hccourse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal coursenum;

	private BigDecimal credits;

	private String descr;

	@Column(name="\"ENABLE\"")
	private int enable;

	private String name;

	private String subjectcode;

	//bi-directional many-to-one association to Hcclass
	@OneToMany(mappedBy="hccourse")
	private List<Hcclass> hcclasses;

	//bi-directional many-to-one association to Hcdept
	@ManyToOne
	@JoinColumn(name="DEPARTMENTID")
	private Hcdept hcdept;

	public Hccourse() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getCoursenum() {
		return this.coursenum;
	}

	public void setCoursenum(BigDecimal coursenum) {
		this.coursenum = coursenum;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
	}

	public String getDescr() {
		return this.descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public int getEnable() {
		return this.enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubjectcode() {
		return this.subjectcode;
	}

	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public List<Hcclass> getHcclasses() {
		return this.hcclasses;
	}

	public void setHcclasses(List<Hcclass> hcclasses) {
		this.hcclasses = hcclasses;
	}

	public Hcclass addHcclass(Hcclass hcclass) {
		getHcclasses().add(hcclass);
		hcclass.setHccourse(this);

		return hcclass;
	}

	public Hcclass removeHcclass(Hcclass hcclass) {
		getHcclasses().remove(hcclass);
		hcclass.setHccourse(null);

		return hcclass;
	}

	public Hcdept getHcdept() {
		return this.hcdept;
	}

	public void setHcdept(Hcdept hcdept) {
		this.hcdept = hcdept;
	}

}