package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pau.univ.meetballs.dao.interfaces.IUserDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.User;

public class UserDao implements IUserDao {
	private final DaoBddHelper bdd;

	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public UserDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}

	@Override
	public User getUserById(int id) throws DaoException {
		final TypedQuery<User> query = this.bdd.getEm().createNamedQuery("User.findById", User.class);
		query.setParameter("id", id);
		
		
		final List<User> ret = query.getResultList();
		
		
		if (ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public List getUsersByFavCookType(List ct) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getUsersByMatchedUser(User u) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getUsersByMatchedUsers(User u) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User u, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().persist(u);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return u;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't create the new object", e);
		}
	}

	@Override
	public User updateUser(User u, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().merge(u);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return u;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't update the object", e);
		}
	}

	@Override
	public void deleteUser(User u, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().remove(u);
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
