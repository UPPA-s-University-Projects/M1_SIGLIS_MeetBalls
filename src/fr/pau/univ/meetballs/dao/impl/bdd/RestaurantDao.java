package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import fr.pau.univ.meetballs.dao.interfaces.IRestaurantDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Restaurant;
import jakarta.ws.rs.Path;
import fr.pau.univ.meetballs.model.User;

@Path("/restaurants")
public class RestaurantDao implements IRestaurantDao{
	
	private final DaoBddHelper bdd;
	
	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public RestaurantDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}

	@Override
	public Restaurant getRestaurantById(int id) throws DaoException {
		final TypedQuery<Restaurant> query = this.bdd.getEm().createNamedQuery("Restaurant.findById", Restaurant.class);
		query.setParameter("id", id);
		
		
		final List<Restaurant> ret = query.getResultList();
		
		
		if (ret.size() > 0) {
			return ret.get(0);
		}
		return null;
	}

	@Override
	public Restaurant createRestaurant(Restaurant r, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().persist(r);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return r;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't create the new object", e);
		}
	}

	@Override
	public Restaurant updateRestaurant(Restaurant r, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().merge(r);
			if (useTransac) {
				this.bdd.commitTransaction();
			}
			return r;
		} catch (final PersistenceException e) {
			this.bdd.rollbackTransaction();
			throw new DaoException("Can't update the object", e);
		}
	}

	@Override
	public void deleteRestaurant(Restaurant r, boolean useTransac) throws DaoException {
		try {
			if (useTransac) {
				this.bdd.beginTransaction();
			}
			this.bdd.getEm().remove(r);
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
