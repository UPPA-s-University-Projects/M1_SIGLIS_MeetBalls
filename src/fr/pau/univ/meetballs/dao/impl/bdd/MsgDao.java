package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import fr.pau.univ.meetballs.dao.interfaces.IMsgDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Discussion;
import fr.pau.univ.meetballs.model.Msg;
import fr.pau.univ.meetballs.model.User;

public class MsgDao implements IMsgDao {
	
	private final DaoBddHelper bdd;

	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public MsgDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}

	@Override
	public Msg getMesageById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Msg> getMessagesByDiscussion(Discussion d) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Msg> getMessagesByUser(User<T> u) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Msg> getMessagesByUserInDiscussion(User<T> u, Discussion d) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg createMessage(Msg m, boolean useTransac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Msg updateMessage(Msg m, boolean useTransac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMessage(Msg m, boolean useTransac) {
		// TODO Auto-generated method stub
		
	}
}
