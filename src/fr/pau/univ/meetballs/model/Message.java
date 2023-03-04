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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="SimpleMsg")
public class Message {
	
	private int id;
	private Discussion discussionId;
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
	public Message(int id, Discussion discussionId, User sender, Date msgStamp, String msg) {
		super();
		this.id = id;
		this.discussionId = discussionId;
		this.sender = sender;
		this.msgStamp = msgStamp;
		this.msg = msg;
	}
	
	public Message() {}
	
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
		return discussionId;
	}
	/**
	 * @param discussionId the discussionId to set
	 */
	public void setDiscussionId(Discussion discussionId) {
		this.discussionId = discussionId;
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
