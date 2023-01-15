package fr.pau.univ.meetballs.dao.impl.bdd;

import fr.pau.univ.meetballs.dao.interfaces.ICookTypeDao;
import fr.pau.univ.meetballs.exception.DaoException;

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
}
