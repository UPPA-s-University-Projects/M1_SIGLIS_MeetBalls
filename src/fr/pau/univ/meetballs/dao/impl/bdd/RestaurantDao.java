package fr.pau.univ.meetballs.dao.impl.bdd;

import fr.pau.univ.meetballs.dao.interfaces.IRestaurantDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Restaurant;
import jakarta.ws.rs.Path;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant createRestaurant(Restaurant r, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant updateRestaurant(Restaurant r, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRestaurant(Restaurant r, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		
	}


}
