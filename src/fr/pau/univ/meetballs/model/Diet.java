package fr.pau.univ.meetballs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table("Diet")
public class Diet {
	private int id;
	private String designation;
		
	
	/**
	 * @param id
	 * @param designation
	 */
	public Diet(int id, String designation) {
		super();
		this.id = id;
		this.designation = designation;
	}
	public Diet() {}
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
