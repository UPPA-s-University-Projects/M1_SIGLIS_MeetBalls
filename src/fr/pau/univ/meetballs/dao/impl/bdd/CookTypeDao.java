package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pau.univ.meetballs.dao.interfaces.ICookTypeDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.CookType;
import jakarta.ws.rs.Path;
import fr.pau.univ.meetballs.model.User;

@Path("/cookType")
public class CookTypeDao implements ICookTypeDao{
	
	private final DaoBddHelper bdd;

	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public CookTypeDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}

	@Override
	public CookType getCookTypeById(int id) throws DaoException {
		final TypedQuery<CookType> query = this.bdd.getEm().createNamedQuery("CookType.findById", CookType.class);
		query.setParameter("id", id);
		
		
		final List<CookType> ret = query.getResultList();
		
		
		if (ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}
	
	@Override
	public List<CookType> getAllCookTypes() throws DaoException {
		final TypedQuery<CookType> query = this.bdd.getEm().createNamedQuery("CookType.findAll", CookType.class);
		
		final List<CookType> ret = query.getResultList();
		
		return ret;
	}

	@Override
	public CookType createCookType(CookType ct, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().persist(ct);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return ct;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't create the new object", e);
		}
	}

	@Override
	public CookType updateCookType(CookType ct, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().merge(ct);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return ct;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't update the object", e);
		}
	}

	@Override
	public void deleteCookType(CookType ct, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().remove(ct);
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
