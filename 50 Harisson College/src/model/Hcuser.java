package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the HCUSERS database table.
 * 
 */
@Entity
@Table(name="HCUSERS")
@NamedQuery(name="Hcuser.findAll", query="SELECT h FROM Hcuser h")
public class Hcuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long userid;

	private String entrydate;

	private String name;

	private BigDecimal officenum;

	private String password;

	@Column(name="\"TYPE\"")
	private BigDecimal type;

	//bi-directional many-to-one association to Hcclass
	@OneToMany(mappedBy="hcuser")
	private List<Hcclass> hcclasses;

	//bi-directional many-to-one association to Hcenrolledclass
	@OneToMany(mappedBy="hcuser")
	private List<Hcenrolledclass> hcenrolledclasses;

	//bi-directional many-to-one association to Hcdept
	@ManyToOne
	@JoinColumn(name="DEPTID")
	private Hcdept hcdept;

	//bi-directional many-to-one association to Hcmojor
	@ManyToOne
	@JoinColumn(name="MAJORID")
	private Hcmojor hcmojor;

	public Hcuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getEntrydate() {
		return this.entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getOfficenum() {
		return this.officenum;
	}

	public void setOfficenum(BigDecimal officenum) {
		this.officenum = officenum;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getType() {
		return this.type;
	}

	public void setType(BigDecimal type) {
		this.type = type;
	}

	public List<Hcclass> getHcclasses() {
		return this.hcclasses;
	}

	public void setHcclasses(List<Hcclass> hcclasses) {
		this.hcclasses = hcclasses;
	}

	public Hcclass addHcclass(Hcclass hcclass) {
		getHcclasses().add(hcclass);
		hcclass.setHcuser(this);

		return hcclass;
	}

	public Hcclass removeHcclass(Hcclass hcclass) {
		getHcclasses().remove(hcclass);
		hcclass.setHcuser(null);

		return hcclass;
	}

	public List<Hcenrolledclass> getHcenrolledclasses() {
		return this.hcenrolledclasses;
	}

	public void setHcenrolledclasses(List<Hcenrolledclass> hcenrolledclasses) {
		this.hcenrolledclasses = hcenrolledclasses;
	}

	public Hcenrolledclass addHcenrolledclass(Hcenrolledclass hcenrolledclass) {
		getHcenrolledclasses().add(hcenrolledclass);
		hcenrolledclass.setHcuser(this);

		return hcenrolledclass;
	}

	public Hcenrolledclass removeHcenrolledclass(Hcenrolledclass hcenrolledclass) {
		getHcenrolledclasses().remove(hcenrolledclass);
		hcenrolledclass.setHcuser(null);

		return hcenrolledclass;
	}

	public Hcdept getHcdept() {
		return this.hcdept;
	}

	public void setHcdept(Hcdept hcdept) {
		this.hcdept = hcdept;
	}

	public Hcmojor getHcmojor() {
		return this.hcmojor;
	}

	public void setHcmojor(Hcmojor hcmojor) {
		this.hcmojor = hcmojor;
	}

}