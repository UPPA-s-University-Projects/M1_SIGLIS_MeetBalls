package fr.pau.univ.meetballs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Discussion")
public class Discussion {

	private int id;
	private User person1, person2;
	/**
	 * @param id
	 * @param person1
	 * @param person2
	 */
	public Discussion(int id, User person1, User person2) {
		super();
		this.id = id;
		this.person1 = person1;
		this.person2 = person2;
	}
	
	public Discussion() {}
	
	/**
	 * @return the id
	 */
	@Id
	@Column(name="id")
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
	 * @return the person1
	 */
	@OneToOne(optional=false)
	@JoinColumn(name = "fk_id_user1", referencedColumnName = "id")
	public User getPerson1() {
		return person1;
	}

	/**
	 * @param person1 the person1 to set
	 */
	public void setPerson1(User person1) {
		this.person1 = person1;
	}
	/**
	 * @return the person2
	 */
	@OneToOne(optional=false)
	@JoinColumn(name = "fk_id_user2", referencedColumnName = "id")
	public User getPerson2() {
		return person2;
	}
	/**
	 * @param person2 the person2 to set
	 */
	public void setPerson2(User person2) {
		this.person2 = person2;
	}
	
	
}
