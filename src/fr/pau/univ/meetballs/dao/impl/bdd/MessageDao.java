package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pau.univ.meetballs.dao.interfaces.ISimpleMsgDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Discussion;
import fr.pau.univ.meetballs.model.Message;
import fr.pau.univ.meetballs.model.User;

public class MessageDao implements ISimpleMsgDao {
	
	private final DaoBddHelper bdd;

	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public MessageDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}

	@Override
	public Message getMesageById(int id) throws DaoException {
		final TypedQuery<Message> query = this.bdd.getEm().createNamedQuery("Message.findById", Message.class);
		query.setParameter("id", id);
		
		
		final List<Message> ret = query.getResultList();
		
		
		if (ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public List<Message> getMessagesByDiscussion(Discussion d) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Message> getMessagesByUser(User<T> u) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Message> getMessagesByUserInDiscussion(User<T> u, Discussion d) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message createMessage(Message m, boolean useTransac) throws DaoException {
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
	public Message updateMessage(Message m, boolean useTransac) throws DaoException {
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
	public void deleteMessage(Message m, boolean useTransac) throws DaoException {
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
