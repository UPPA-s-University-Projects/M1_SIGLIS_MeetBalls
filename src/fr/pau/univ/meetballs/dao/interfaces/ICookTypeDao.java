package fr.pau.univ.meetballs.dao.interfaces;

import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.CookType;

public interface ICookTypeDao {
	//Method to read data
	public CookType getCookTypeById(int id) throws DaoException;
	
	//Method to send data (write)
	public CookType createCookType(CookType ct, final boolean useTransac) throws DaoException;
	public CookType updateCookType(CookType ct, final boolean useTransac) throws DaoException;
	public void deleteCookType(CookType ct, final boolean useTransac) throws DaoException;
}
