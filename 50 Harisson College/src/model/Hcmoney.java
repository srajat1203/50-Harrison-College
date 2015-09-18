package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the HCMONEY database table.
 * 
 */
@Entity
@Table(name="Hcmoney",schema="TESTDB")
@NamedQuery(name="Hcmoney.findAll", query="SELECT h FROM Hcmoney h")
public class Hcmoney implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private double price;

	private String semester;

	public Hcmoney() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

}