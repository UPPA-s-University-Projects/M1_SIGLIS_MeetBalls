package fr.pau.univ.meetballs.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table("Usr")
public class User {
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
	
	
	
	public User() {
		
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
	@JoinColumn(name = "fk_favCookType", referencedColumnName = "id")
	public List<CookType> getFavCookType() {
		return favCookType;
	}

	/**
	 * @param favCookType the favCookType to set
	 */
	public void setFavCookType(List<CookType> favCookType) {
		this.favCookType = favCookType;
	}

	
	
	
}
