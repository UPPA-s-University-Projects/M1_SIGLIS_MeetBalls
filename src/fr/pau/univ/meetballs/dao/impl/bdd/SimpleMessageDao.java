package fr.pau.univ.meetballs.dao.impl.bdd;

import fr.pau.univ.meetballs.dao.interfaces.ISimpleMsgDao;
import fr.pau.univ.meetballs.exception.DaoException;

public class SimpleMessageDao implements ISimpleMsgDao {
	private final DaoBddHelper bdd;

	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public SimpleMessageDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}
}
