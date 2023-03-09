package fr.pau.univ.meetballs.dao.interfaces;

import java.util.List;

import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Discussion;
import fr.pau.univ.meetballs.model.Message;
import fr.pau.univ.meetballs.model.User;

public interface ISimpleMsgDao {

	public Message getMesageById(int id) throws DaoException;
	public List<Message> getMessagesByDiscussion(Discussion d) throws DaoException;
	public <T> List<Message> getMessagesByUser(User<T> u) throws DaoException;
	public <T> List<Message> getMessagesByUserInDiscussion(User<T> u, Discussion d) throws DaoException;
	
	public Message createMessage(Message m, final boolean useTransac);
	public Message updateMessage(Message m, final boolean useTransac);
	public void deleteMessage(Message m, final boolean useTransac);
}
