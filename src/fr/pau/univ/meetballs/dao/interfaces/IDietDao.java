package fr.pau.univ.meetballs.dao.interfaces;

import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Diet;

public interface IDietDao {

	public Diet getDietById(int id) throws DaoException;
	
	public Diet createDiet(Diet d, final boolean useTransac) throws DaoException;
	public Diet updateDiet(Diet d, final boolean useTransac) throws DaoException;
	public void deleteDiet(Diet d, final boolean useTransac) throws DaoException;
}
