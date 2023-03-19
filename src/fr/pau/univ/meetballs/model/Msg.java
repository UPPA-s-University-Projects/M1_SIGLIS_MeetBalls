package fr.pau.univ.meetballs.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Msg")
@NamedQueries({
	@NamedQuery(name = "Msg.findById", query = "SELECT m FROM Msg m WHERE m.id = :id"),
	@NamedQuery(name = "Msg.findByDiscussion", query = "SELECT m FROM Msg m WHERE :discussionId = ANY(SELECT d.id FROM m.discussion d)"),
	@NamedQuery(name = "Msg.findByUser", query = "SELECT m FROM Msg m WHERE :senderId = ANY (SELECT u.id FROM m.sender u)"),
	@NamedQuery(name = "Msg.findByUserInDiscussion", query = "SELECT m FROM Msg m WHERE :senderId = ANY (SELECT u.id FROM m.sender u) AND"
			+ " :discussionId = ANY(SELECT d.id FROM m.discussion d)")
})
public class Msg {
	
	private int id;
	private Discussion discussion;
	private User sender;
	private Date msgStamp;
	private String msg;
	
	/**
	 * @param id
	 * @param discussionId
	 * @param sender
	 * @param msgStamp
	 * @param msg
	 */
	public Msg(int id, Discussion discussion, User sender, Date msgStamp, String msg) {
		super();
		this.id = id;
		this.discussion = discussion;
		this.sender = sender;
		this.msgStamp = msgStamp;
		this.msg = msg;
	}
	
	public Msg() {}
	
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
	 * @return the discussionId
	 */
	@OneToOne(optional=false)
	@JoinColumn(name = "fk_id_discussion", referencedColumnName = "id")
	public Discussion getDiscussionId() {
		return discussion;
	}
	/**
	 * @param discussionId the discussionId to set
	 */
	public void setDiscussionId(Discussion discussionId) {
		this.discussion = discussionId;
	}
	/**
	 * @param idUsr1 the idUsr1 to set
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}
	/**
	 * @return the User object of our sender
	 */
	@OneToOne(optional=false)
	@JoinColumn(name = "fk_id_sender", referencedColumnName = "id")
	public User getSender() {
		return this.sender;
	}
	
	/**
	 * @return the msgStamp
	 */
	@Column(name = "msg_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMsgStamp() {
		return msgStamp;
	}
	/**
	 * @param msgStamp the msgStamp to set
	 */
	public void setMsgStamp(Date msgStamp) {
		this.msgStamp = msgStamp;
	}
	/**
	 * @return the msg
	 */
	@Column(name = "msg")
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
