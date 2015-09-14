package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCDEPT database table.
 * 
 */
@Entity
@Table(name="HCDEPT", schema = "testdb")
@NamedQuery(name="Hcdept.findAll", query="SELECT h FROM Hcdept h")
public class Hcdept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="\"ENABLE\"")
	private BigDecimal enable;

	private String name;

	//bi-directional many-to-one association to Hccourse
	@OneToMany(mappedBy="hcdept")
	private List<Hccourse> hccourses;

	//bi-directional many-to-one association to Hcmojor
	@OneToMany(mappedBy="hcdept")
	private List<Hcmojor> hcmojors;

	//bi-directional many-to-one association to Hcuser
	@OneToMany(mappedBy="hcdept")
	private List<Hcuser> hcusers;

	public Hcdept() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getEnable() {
		return this.enable;
	}

	public void setEnable(BigDecimal enable) {
		this.enable = enable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hccourse> getHccourses() {
		return this.hccourses;
	}

	public void setHccourses(List<Hccourse> hccourses) {
		this.hccourses = hccourses;
	}

	public Hccourse addHccours(Hccourse hccours) {
		getHccourses().add(hccours);
		hccours.setHcdept(this);

		return hccours;
	}

	public Hccourse removeHccours(Hccourse hccours) {
		getHccourses().remove(hccours);
		hccours.setHcdept(null);

		return hccours;
	}

	public List<Hcmojor> getHcmojors() {
		return this.hcmojors;
	}

	public void setHcmojors(List<Hcmojor> hcmojors) {
		this.hcmojors = hcmojors;
	}

	public Hcmojor addHcmojor(Hcmojor hcmojor) {
		getHcmojors().add(hcmojor);
		hcmojor.setHcdept(this);

		return hcmojor;
	}

	public Hcmojor removeHcmojor(Hcmojor hcmojor) {
		getHcmojors().remove(hcmojor);
		hcmojor.setHcdept(null);

		return hcmojor;
	}

	public List<Hcuser> getHcusers() {
		return this.hcusers;
	}

	public void setHcusers(List<Hcuser> hcusers) {
		this.hcusers = hcusers;
	}

	public Hcuser addHcuser(Hcuser hcuser) {
		getHcusers().add(hcuser);
		hcuser.setHcdept(this);

		return hcuser;
	}

	public Hcuser removeHcuser(Hcuser hcuser) {
		getHcusers().remove(hcuser);
		hcuser.setHcdept(null);

		return hcuser;
	}

}