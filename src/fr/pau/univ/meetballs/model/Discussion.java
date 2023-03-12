package fr.pau.univ.meetballs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Discussion")
@NamedQueries({
	@NamedQuery(name = "Discussion.findById", query = "SELECT d FROM Discussion d WHERE d.id = :id"),
	@NamedQuery(name = "Discussion.findByMessage", query = "SELECT d FROM Discussion d WHERE d.msg IN(ANY( SELECT m FROM Message m WHERE m.id = :id))"),
	@NamedQuery(name = "Discussion.findByUser", query = "SELECT d FROM Discussion d WHERE d.person1 IN(ANY ( SELECT u FROM User u WHERE u.id = :id)) OR d.person2 IN(ANY ( SELECT u FROM User u WHERE u.id = :id))"), //TODO : Optimize this query
})
public class Discussion {

	private int id;
	private User person1, person2;
	private List<Msg> msg;
	
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

	/**
	 * @return the msg
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_messages", referencedColumnName = "id")
	public List<Msg> getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(List<Msg> msg) {
		this.msg = msg;
	}
	
	/**
	 * @param m : The message to add to the discussion
	 * @return the message added to the discussion
	 */
	public Msg addMsgToDiscussion(Msg m) {
		this.msg.add(m);
		return m;
	}
	
	/**
	 * @param m : The message to remove
	 */
	public void removeMsgFromDiscussion(Msg m ) {
		this.msg.remove(m);
	}
	
	
	
	
}
