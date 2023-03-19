package fr.pau.univ.meetballs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CookType")
@NamedQueries({
	@NamedQuery(name = "CookType.findById", query = "SELECT ct FROM CookType ct WHERE ct.id = :id"),
	@NamedQuery(name = "CookType.findAll", query="SELECT ct FROM CookType ct")
})
public class CookType {
	private int id;
	private String designation;
	/**
	 * @param id
	 * @param designation
	 */
	public CookType(int id, String designation) {
		this.id = id;
		this.designation = designation;
	}
	public CookType() {}
	/**
	 * @return the id
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the designation
	 */

	@Column(name = "designation")
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}
