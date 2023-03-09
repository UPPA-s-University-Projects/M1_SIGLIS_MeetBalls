package fr.pau.univ.meetballs.dao.interfaces;

import java.util.List;

import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Discussion;
import fr.pau.univ.meetballs.model.Message;
import fr.pau.univ.meetballs.model.User;

public interface IDiscussionDao {
	
	public Discussion getDiscussionById(int id) throws DaoException;
	public <T> List<Discussion> getDiscussionsByUser(User<T> u) throws DaoException;
	public Discussion getDiscussionByMessage(Message m) throws DaoException;
	
	public Discussion createDiscussion(Discussion d, final boolean useTransac) throws DaoException;
	public Discussion updateDiscussion(Discussion d, final boolean useTransac) throws DaoException;
	public void deleteDiscussion(Discussion d, final boolean useTransac) throws DaoException;
}
