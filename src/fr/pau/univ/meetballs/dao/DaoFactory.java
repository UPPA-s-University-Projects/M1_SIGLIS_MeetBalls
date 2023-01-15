package fr.pau.univ.meetballs.dao;

import fr.pau.univ.meetballs.dao.impl.bdd.UserDao;
import fr.pau.univ.meetballs.dao.interfaces.IUserDao;
import fr.pau.univ.meetballs.exception.DaoException;

//Un pattern DAO permet de facilement créer un lien entre "nos classes Java et notre BDD PostegreSQL"
//Cette classe est de type Factory. Le pattern Factory permet d'avoir plusieurs classes abstraites qui auront chacune leurs 
//Spécificités. Pour faciliter la création selon le cas, nous créons un Factory (une usine) qui s'occupe de l'instanciation des classes
//selon notre besoin, tout ça depuis une seule et même classe (donc pas besoin d'avoir une référence entre toutes les classes abstraites).
//
//Vous pouvez en apprendre plus sur le pattern DAO ici : https://cyrille-herby.developpez.com/tutoriels/java/mapper-sa-base-donnees-avec-pattern-dao/
//Et sur le pattern Factory ici : https://refactoring.guru/fr/design-patterns/factory-method
//https://refactoring.guru/fr/design-patterns/abstract-factory
public class DaoFactory {

	private static DaoFactory instance = null;

	private IUserDao userDao = null;

	/**
	 * Ici, nous implémentons le côté Singleton de cette classe.
	 * S'il n'y a pas d'instance déjà créée, nous ne créons une, sinon nous
	 * retournons l'instance déjà créée.
	 * Vous pouvez en apprendre plus sur le pattern Singleton ici :
	 * https://refactoring.guru/fr/design-patterns/singleton
	 *
	 * @return instance de la classe DaoFactory
	 */
	public static DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	/**
	 * Ici, le cas est le même que précédemment en incluant une clause try-catch
	 * pour
	 * attraper de potentielles erreurs pendant l'instanciation.
	 * De plus, cette méthode s'occupe seulement de la classe UserDao
	 *
	 * @return instance de la classe SerieDAO
	 * @throws DaoException
	 */
	public IUserDao getUserDao() {
		if (this.userDao == null) {
			try {
				this.userDao = new UserDao();
			} catch (DaoException e) {
				e.printStackTrace();
			}
		}
		return this.userDao;
	}



}
