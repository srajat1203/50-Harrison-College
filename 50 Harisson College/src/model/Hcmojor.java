package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the HCMOJOR database table.
 * 
 */
@Entity

@Table(name="Hcmojor", schema="TESTDB")
@NamedQuery(name="Hcmojor.findAll", query="SELECT h FROM Hcmojor h")
public class Hcmojor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Column(name="\"ENABLE\"")
	private int enable;

	private String name;

	//bi-directional many-to-one association to Hcdept
	@ManyToOne
	@JoinColumn(name="DEPTID")
	private Hcdept hcdept;

	//bi-directional many-to-one association to Hcuser
	@OneToMany(mappedBy="hcmojor")
	private List<Hcuser> hcusers;

	public Hcmojor() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Hcdept getHcdept() {
		return this.hcdept;
	}

	public void setHcdept(Hcdept hcdept) {
		this.hcdept = hcdept;
	}

	public List<Hcuser> getHcusers() {
		return this.hcusers;
	}

	public void setHcusers(List<Hcuser> hcusers) {
		this.hcusers = hcusers;
	}

	public Hcuser addHcuser(Hcuser hcuser) {
		getHcusers().add(hcuser);
		hcuser.setHcmojor(this);

		return hcuser;
	}

	public Hcuser removeHcuser(Hcuser hcuser) {
		getHcusers().remove(hcuser);
		hcuser.setHcmojor(null);

		return hcuser;
	}

}