package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pau.univ.meetballs.dao.interfaces.IMsgDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Discussion;
import fr.pau.univ.meetballs.model.Msg;
import fr.pau.univ.meetballs.model.User;

public class MsgDao implements IMsgDao {
	
	private final DaoBddHelper bdd;

	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public MsgDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}

	@Override
	public Msg getMesageById(int id) throws DaoException {
		final TypedQuery<Msg> query = this.bdd.getEm().createNamedQuery("Msg.findById", Msg.class);
		query.setParameter("id", id);
		
		
		final List<Msg> ret = query.getResultList();
		
		
		if (ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public List<Msg> getMessagesByDiscussion(Discussion d) throws DaoException {
		final TypedQuery<Msg> query = this.bdd.getEm().createNamedQuery("Msg.findById", Msg.class);
		query.setParameter(":discussionId", d.getId());
		
		
		final List<Msg> ret = query.getResultList();
		
		return ret;
	}

	@Override
	public <T> List<Msg> getMessagesByUser(User<T> u) throws DaoException {
		final TypedQuery<Msg> query = this.bdd.getEm().createNamedQuery("Msg.findById", Msg.class);
		query.setParameter(":senderId", u.getId());
		
		
		final List<Msg> ret = query.getResultList();
		
		return ret;
	}
	
	@Override
	public <T> Msg getMessagesByUserInDiscussion(User<T> u, Discussion d) throws DaoException {
		final TypedQuery<Msg> query = this.bdd.getEm().createNamedQuery("Msg.findByUserInDiscussion", Msg.class);
		query.setParameter("senderId", u.getId());
		query.setParameter("discussionId", d.getId());
		
		final List<Msg> ret = query.getResultList();
		
		
		if (ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public Msg createMessage(Msg m, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().persist(m);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return m;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't create the new object", e);
		}
	}

	@Override
	public Msg updateMessage(Msg m, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().merge(m);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return m;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't update the object", e);
		}
	}

	@Override
	public void deleteMessage(Msg m, boolean useTransac)  throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().remove(m);
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
