package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pau.univ.meetballs.dao.interfaces.IDietDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Diet;
import fr.pau.univ.meetballs.model.User;

public class DietDao implements IDietDao{
	
	private final DaoBddHelper bdd;

	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public DietDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}

	@Override
	public Diet getDietById(int id) throws DaoException {
		final TypedQuery<Diet> query = this.bdd.getEm().createNamedQuery("Diet.findById", Diet.class);
		query.setParameter("id", id);
		
		
		final List<Diet> ret = query.getResultList();
		
		
		if (ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public Diet createDiet(Diet d, boolean useTransac) throws DaoException {
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
	public Diet updateDiet(Diet d, boolean useTransac) throws DaoException {
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
	public void deleteDiet(Diet d, boolean useTransac) throws DaoException {
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
