package fr.pau.univ.meetballs.dao.interfaces;

import java.util.List;

import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Discussion;
import fr.pau.univ.meetballs.model.Msg;
import fr.pau.univ.meetballs.model.User;

public interface IMsgDao {

	public Msg getMesageById(int id) throws DaoException;
	public List<Msg> getMessagesByDiscussion(Discussion d) throws DaoException;
	public <T> List<Msg> getMessagesByUser(User<T> u) throws DaoException;
	public <T> List<Msg> getMessagesByUserInDiscussion(User<T> u, Discussion d) throws DaoException;
	
	public Msg createMessage(Msg m, final boolean useTransac) throws DaoException;
	public Msg updateMessage(Msg m, final boolean useTransac) throws DaoException;
	public void deleteMessage(Msg m, final boolean useTransac) throws DaoException;
}
