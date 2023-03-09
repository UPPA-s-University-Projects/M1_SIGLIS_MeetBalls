package fr.pau.univ.meetballs.dao.impl.bdd;

import java.util.List;

import fr.pau.univ.meetballs.dao.interfaces.ISimpleMsgDao;
import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.Discussion;
import fr.pau.univ.meetballs.model.Message;
import fr.pau.univ.meetballs.model.User;

public class MessageDao implements ISimpleMsgDao {
	
	private final DaoBddHelper bdd;

	/**
	 * Le constructeur de notre classe.
	 * Essaye de récupérer une instance de la classe DaoBddHelper.
	 * 
	 * @throws DaoException
	 */
	public MessageDao() throws DaoException {
		this.bdd = DaoBddHelper.getInstance();
	}

	@Override
	public Message getMesageById(int id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessagesByDiscussion(Discussion d) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Message> getMessagesByUser(User<T> u) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<Message> getMessagesByUserInDiscussion(User<T> u, Discussion d) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message createMessage(Message m, boolean useTransac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message updateMessage(Message m, boolean useTransac) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMessage(Message m, boolean useTransac) {
		// TODO Auto-generated method stub
		
	}
}
