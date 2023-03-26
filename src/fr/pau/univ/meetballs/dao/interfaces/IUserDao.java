package fr.pau.univ.meetballs.dao.interfaces;

import java.util.List;

import fr.pau.univ.meetballs.exception.DaoException;
import fr.pau.univ.meetballs.model.CookType;
import fr.pau.univ.meetballs.model.User;

public interface IUserDao<T> {
	//Methods to retrieve data
	public List<T> getAllUsers() throws DaoException;
	public User<T> getUserById(int id) throws DaoException;
	public List<User<T>> getUsersByFavCookType(List<CookType> ct) throws DaoException;
	public List<User<T>> getUsersByMatchedUser(User<T> u) throws DaoException;
	public List<User<T>> getUsersByLikedUsers(User<T> u) throws DaoException;
	public List<User<T>> getToMatchUser(User u) throws DaoException;
	public User<T> getLoginUser(String email, String pwd) throws DaoException;
	//public List<User<T>> getUsersByIdentity(String identity) throws DaoException;
	
	//Methods to send data
	User<T> createUser(User<T> u, final boolean useTransac) throws DaoException;
	User<T> updateUser(User<T> u, final boolean useTransac) throws DaoException;
	void deleteUser(User<T> u, final boolean useTransac) throws DaoException;
}
