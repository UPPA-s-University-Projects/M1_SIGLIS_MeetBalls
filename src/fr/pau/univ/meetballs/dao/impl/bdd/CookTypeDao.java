package fr.pau.univ.meetballs.dao.impl.bdd;

import fr.pau.univ.meetballs.dao.interfaces.ICookTypeDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.CookType;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CookType createCookType(CookType ct, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CookType updateCookType(CookType ct, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCookType(CookType ct, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	
	 
}
