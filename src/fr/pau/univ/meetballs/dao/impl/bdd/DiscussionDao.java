package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import fr.pau.univ.meetballs.dao.interfaces.IDiscussionDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Discussion;
import fr.pau.univ.meetballs.model.Message;
import fr.pau.univ.meetballs.model.User;

public class DiscussionDao implements IDiscussionDao{

	private final DaoBddHelper bdd;
	
	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public DiscussionDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}
	
	@Override
	public Discussion getDiscussionById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Discussion> getDiscussionsByUser(User<T> u) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion getDiscussionByMessage(Message m) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion createDiscussion(Discussion d, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Discussion updateDiscussion(Discussion d, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDiscussion(Discussion d, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
