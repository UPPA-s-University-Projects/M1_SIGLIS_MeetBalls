package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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
		final TypedQuery<Discussion> query = this.bdd.getEm().createNamedQuery("Discussion.findById", Discussion.class);
		query.setParameter("id", id);
		
		
		final List<Discussion> ret = query.getResultList();
		
		
		if (ret.size() > 0) {
			return ret.get(0);
		}
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
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().persist(d);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return d;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't create the new object", e);
		}
	}

	@Override
	public Discussion updateDiscussion(Discussion d, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().merge(d);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return d;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't update the object", e);
		}
	}

	@Override
	public void deleteDiscussion(Discussion d, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().remove(d);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
		} catch (final PersistenceException e) {
			if (useTransac) {
				this.bdd.rollbackTransaction();
			}
			throw new DaoException("Can't delete the object", e);
		}
	}

}
