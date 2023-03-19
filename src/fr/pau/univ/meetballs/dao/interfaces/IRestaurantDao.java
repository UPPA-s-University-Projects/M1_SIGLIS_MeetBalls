package fr.pau.univ.meetballs.dao.interfaces;

import java.util.List;

import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.CookType;
import fr.pau.univ.meetballs.model.Restaurant;

public interface IRestaurantDao {
	public Restaurant getRestaurantById(int id) throws DaoException;
	public List<Restaurant> getRestaurantByCookType(CookType ct) throws DaoException;
	//public List<Restaurant> getRestaurantsByProximity(float perimeter, double lon, double lat) throws DaoException;
	
	public Restaurant createRestaurant(Restaurant r, final boolean useTransac) throws DaoException;
	public Restaurant updateRestaurant(Restaurant r, final boolean useTransac) throws DaoException;
	public void deleteRestaurant(Restaurant r, final boolean useTransac) throws DaoException;
}
