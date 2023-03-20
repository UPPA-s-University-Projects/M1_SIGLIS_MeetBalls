package fr.pau.univ.meetballs.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="User")
@NamedQueries({
	//Find a user by its ID in our DB.
	@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
	//Find a user by its favorite cook type (
	@NamedQuery(name = "User.findByFavCookType", query = "SELECT u FROM User u WHERE :ctId = ANY (SELECT ct.id FROM u.favCookType ct)"),
	//Find a user by its liked user
	@NamedQuery(name = "User.findByLikedUsers", query = "SELECT u FROM User u WHERE :likedId = ANY(SELECT uLiked FROM u.likedUsers uLiked)"),
	//Find a user by its matched user.
	@NamedQuery(name = "User.findByMatched", query = "SELECT u FROM User u WHERE :matchedId = ANY(SELECT uMatched.id FROM u.matched uMatched)"),
	//Find all users by their favorite cooktype which are not already liked, disliked or matched (get all new potential likeable users)
	//This query is really important to filter as many users as possible and only return compatible user
	@NamedQuery(name = "User.findNewUserToMatch", query = "SELECT u FROM User u WHERE :ctId = ANY (SELECT ct.id FROM u.favCookType ct) AND"
			+ " :likedId = ANY(SELECT uLiked FROM u.likedUsers uLiked) AND" 
			+ " :matchedId = ANY(SELECT uMatched.id FROM u.matched uMatched) AND"
			+ " :dislikedId = ANY(SELECT uDisliked FROM u.dislikedUser uDisliked)"),
//	@NamedQuery(name = "User.findPotentialMatches", query = "SELECT DISTINCT * FROM User AS other_usr WHERE other_usr.id IN ("
//			+ "SELECT other_usr_cooktype.id_usr"
//			+ "FROM usrFavCookType AS current_usr_cooktype"
//			+ "JOIN usrFavCookType AS other_usr_cooktype ON current_usr_cooktype.id_type = other_usr_cooktype.id_type"
//			+ "WHERE current_usr_cooktype.id_usr = :uId)"
//			+ "AND NOT FIND_IN_SET(other_usr.id, (SELECT liked_users FROM Usr WHERE id = :uId))"
//			+ "AND NOT FIND_IN_SET(other_usr.id, (SELECT disliked_users FROM Usr WHERE id = :uId))"
//			+ "AND NOT FIND_IN_SET(other_usr.id, (SELECT matched_users FROM Usr WHERE id = :uId))"
//			+ "AND NOT FIND_IN_SET(:uId, (SELECT matched_users FROM Usr WHERE id = other_usr.id))"
//	    )

})
public class User<T> {
	//Nos attributs pour nos utilisateurs
	private int id;
	private String nom;
	private String prenom;
	private String pwd;
	private String pp;
	private Date dob;
	private boolean sex;
	private String bio;
	private String loc;
	private int perimetre;
	private boolean desert;
	//Nos attributs de relations
	//Un utilisateur peut faire partie de plusieurs régimes (allergies, etc.)
	private List<Diet> diets;
	//Un utilisateur a plusieurs type de cuisine favorie.
	private List<CookType> favCookType;
	
	private List<User> likedUsers, dislikedUser, matched;
	private float tauxCuisson;
	
	
	
	public User() {}
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param pwd
	 * @param pp
	 * @param dob
	 * @param sex
	 * @param bio
	 * @param loc
	 * @param perimetre
	 * @param desert
	 */
	public User(int id, String nom, String prenom, String pwd, String pp, Date dob, boolean sex, String bio,
			String loc, int perimetre, boolean desert) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.pp = pp;
		this.dob = dob;
		this.sex = sex;
		this.bio = bio;
		this.loc = loc;
		this.perimetre = perimetre;
		this.desert = desert;
	}
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param pwd
	 * @param pp
	 * @param dob
	 * @param sex
	 * @param bio
	 * @param loc
	 * @param perimetre
	 * @param desert
	 * @param diets
	 * @param favCookType
	 * @param likedUsers
	 * @param dislikedUser
	 * @param toMatch
	 */
	public User(int id, String nom, String prenom, String pwd, String pp, Date dob, boolean sex, String bio, String loc,
			int perimetre, boolean desert, List<Diet> diets, List<CookType> favCookType, List<User> likedUsers,
			List<User> dislikedUser) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.pwd = pwd;
		this.pp = pp;
		this.dob = dob;
		this.sex = sex;
		this.bio = bio;
		this.loc = loc;
		this.perimetre = perimetre;
		this.desert = desert;
		this.diets = diets;
		this.favCookType = favCookType;
		this.likedUsers = likedUsers;
		this.dislikedUser = dislikedUser;
	}
	
	
	
	public User(boolean desert, List<Diet> diets, List<CookType> favCookType,
			List<User> likedUsers, List<User> dislikedUser, float tauxCuisson) {
		super();
		this.desert = desert;
		this.diets = diets;
		this.favCookType = favCookType;
		this.likedUsers = likedUsers;
		this.dislikedUser = dislikedUser;
		this.tauxCuisson = tauxCuisson;
	}

	/*=====================================================================================================================================
	 *
	 * STATE MACHINE - MATCHING ALGORITHM
	 * 
	 =====================================================================================================================================*/
	public List<User> itsCookingTime(List<User> users){
		
		//We create the return list which will contain all of our matching candidates
		List<User> matchingCandidates = null;
		//We create an iterator to go through our list of users 
		ListIterator<User> iu = users.listIterator();
		
		//Scoring variable
		float tc;
		short isDesert;
		ArrayList<CookType> comonCookTypeScore = new ArrayList<CookType>(favCookType);		
		
		//We go through the list of users
		while(iu.hasNext()) {
			//We retrieve the user at the index 
			User u = iu.next();
			
			//We get our scoring values for the final result
			//Do we have a user who wants desert?
			//Simple inline condition
			isDesert = (short) (u.isDesert() ? 1 : 0);
			//We retrieve the similarities between our two users favorite cooking type
			//The more similarities we can find between the two lists, the more items we are going to have in this list
			//And so we will get a better score.
			comonCookTypeScore.retainAll(u.getFavCookType());
			
			//We calculate our TAUX DE CUISSON(tm)
			tc = (float) ((isDesert * 0.3)+(comonCookTypeScore.size() * 0.23));
			
			//If our TAUX DE CUISSON(tm) is high enough, we can add our user to our list and set its/her TAUX DE CUISSON for later use.
			if(tc > 0.23) {
				u.setTauxCuisson(tc);
				matchingCandidates.add(u);
			}
			
			//Next user
			iu.next();
		}
		
		
		
		return matchingCandidates;
	}


	@SuppressWarnings("unchecked")
	public void likedUser(User lU) {
		//Nous ajoutons notre utilisateur à notre liste des utilisateurs liker
		addObjectToList((List<T>) likedUsers, lU);
		
		//Si l'autre utilisateur nous a liker, nous lions les deux utilisateurs avec la table macthed.
		if(lU.getLikedUsers().contains(this)) {
			addObjectToList((List<T>) matched, lU);
			addObjectToList(lU.getMatched(), this);
		}
	}
	
	
	/*=====================================================================================================================================
	 *
	 * CRUDE 
	 * 
	 =====================================================================================================================================*/
	public void addObjectToList(List<T> l, Object o ) {
		l.add((T) o);
	}
	
	public void removeObjectFromList(List<T> l, Object o) {
		l.remove(o);
	}
	
	
	
	/*=====================================================================================================================================
	 *
	 * GETTERS & SETTERS
	 * 
	 =====================================================================================================================================*/	
	/**
	 * @return the id
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	@Column(name = "nom")
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	@Column(name = "prenom")
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the pwd
	 */
	@Column(name = "pwd")
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the pp
	 */
	@Column(name = "pp")
	public String getPp() {
		return pp;
	}

	/**
	 * @param pp the pp to set
	 */
	public void setPp(String pp) {
		this.pp = pp;
	}

	/**
	 * @return the dob
	 */
	@Column(name = "dob")
	@Temporal(TemporalType.DATE)
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the sex
	 */
	@Column(name = "sex")
	public boolean isSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(boolean sex) {
		this.sex = sex;
	}

	/**
	 * @return the bio
	 */
	@Column(name = "bio")
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * @return the loc
	 */
	@Column(name = "loc")
	public String getLoc() {
		return loc;
	}

	/**
	 * @param loc the loc to set
	 */
	public void setLoc(String loc) {
		this.loc = loc;
	}

	/**
	 * @return the perimetre
	 */
	@Column(name = "perimetre")
	public int getPerimetre() {
		return perimetre;
	}

	/**
	 * @param perimetre the perimetre to set
	 */
	public void setPerimetre(int perimetre) {
		this.perimetre = perimetre;
	}

	/**
	 * @return the desert
	 */
	@Column(name = "desert")
	public boolean isDesert() {
		return desert;
	}

	/**
	 * @param desert the desert to set
	 */
	public void setDesert(boolean desert) {
		this.desert = desert;
	}

	/**
	 * @return the diets
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_diets", referencedColumnName = "id")
	public List<Diet> getDiets() {
		return diets;
	}

	/**
	 * @param diets the diets to set
	 */
	public void setDiets(List<Diet> diets) {
		this.diets = diets;
	}

	/**
	 * @return the favCookType
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_fav_cook_type", referencedColumnName = "id")
	public List<CookType> getFavCookType() {
		return favCookType;
	}

	/**
	 * @param favCookType the favCookType to set
	 */
	public void setFavCookType(List<CookType> favCookType) {
		this.favCookType = favCookType;
	}

	/**
	 * @return the likedUsers
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_liked_users", referencedColumnName = "id")
	public List<User> getLikedUsers() {
		return likedUsers;
	}

	/**
	 * @param likedUsers the likedUsers to set
	 */
	public void setLikedUsers(List<User> likedUsers) {
		this.likedUsers = likedUsers;
	}

	/**
	 * @return the dislikedUser
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_disliked_users", referencedColumnName = "id")
	public List<User> getDislikedUser() {
		return dislikedUser;
	}

	/**
	 * @param dislikedUser the dislikedUser to set
	 */
	public void setDislikedUser(List<User> dislikedUser) {
		this.dislikedUser = dislikedUser;
	}

	
	//CRUDE Methods for our lists
	public void addUserToList(List<User> list, User user) {
		list.add(user);
	}
	public void deleteUserToList(List<User> list, User user) {
		list.remove(user);
	}

	/**
	 * @return the tauxCuisson
	 */
	@Transient
	public float getTauxCuisson() {
		return tauxCuisson;
	}

	/**
	 * @param tauxCuisson the tauxCuisson to set
	 */
	public void setTauxCuisson(float tauxCuisson) {
		this.tauxCuisson = tauxCuisson;
	}

	public List<User> getMatched() {
		return matched;
	}

	public void setMatched(List<User> matched) {
		this.matched = matched;
	}
	
	
	
	
}
