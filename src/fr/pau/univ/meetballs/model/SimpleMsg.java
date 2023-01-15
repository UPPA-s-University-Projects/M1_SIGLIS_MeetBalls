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


//@Entity
//@Table("SimpleMsg")
public class SimpleMsg {
	private int id;
	private int idUsr1;
	private int idUsr2;
	private Date msgStamp;
	private String msg;
	/**
	 * @param id
	 * @param idUsr1
	 * @param idUsr2
	 * @param msgStamp
	 * @param msg
	 */
	public SimpleMsg(int id, int idUsr1, int idUsr2, Date msgStamp, String msg) {
		super();
		this.id = id;
		this.idUsr1 = idUsr1;
		this.idUsr2 = idUsr2;
		this.msgStamp = msgStamp;
		this.msg = msg;
	}
	public SimpleMsg() {}
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
	 * @return the idUsr1
	 */
	@OneToOne(optional=false)
	@JoinColumn(name = "fk_id_usr1", referencedColumnName = "id")
	public int getIdUsr1() {
		return idUsr1;
	}
	/**
	 * @param idUsr1 the idUsr1 to set
	 */
	public void setIdUsr1(int idUsr1) {
		this.idUsr1 = idUsr1;
	}
	/**
	 * @return the idUsr2
	 */
	@OneToOne(optional=false)
	@JoinColumn(name = "fk_id_usr2", referencedColumnName = "id")
	public int getIdUsr2() {
		return idUsr2;
	}
	/**
	 * @param idUsr2 the idUsr2 to set
	 */
	public void setIdUsr2(int idUsr2) {
		this.idUsr2 = idUsr2;
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
