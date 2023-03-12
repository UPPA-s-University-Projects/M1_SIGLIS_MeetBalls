package fr.pau.univ.meetballs.dao.impl.bdd;

import fr.pau.univ.meetballs.dao.interfaces.IDietDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Diet;
import jakarta.ws.rs.Path;

@Path("/diet")
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diet createDiet(Diet d, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diet updateDiet(Diet d, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDiet(Diet d, boolean useTransac) throws DaoException {
		// TODO Auto-generated method stub
		
	}
}
