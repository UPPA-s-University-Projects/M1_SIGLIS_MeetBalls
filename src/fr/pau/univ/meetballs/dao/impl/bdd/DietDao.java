package fr.pau.univ.meetballs.dao.impl.bdd;

import fr.pau.univ.meetballs.dao.interfaces.IDietDao;
import fr.pau.univ.meetballs.exception.DaoException;

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
}
