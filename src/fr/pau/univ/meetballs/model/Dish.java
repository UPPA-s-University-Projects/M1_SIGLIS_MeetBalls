package fr.pau.univ.meetballs.model;

import java.util.List;

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

@Entity
@Table(name="Dish")
@NamedQueries({
	@NamedQuery(name = "Dish.findById", query = "SELECT d FROM Dish d WHERE d.id = :id"),
	@NamedQuery(name = "Dish.findByCookType", query = "SELECT d FROM Dish d WHERE d.typeOfDish IN(ANY(SELECT ct FROM CookType ct WHERE ct.id = :id))"),
})
public class Dish {
	private int id;
	private String nom;
	private String img;
	private List<Diet> partOfDiets;
	private List<CookType> typeOfDish;
	
	/**
	 * @param id
	 * @param nom
	 * @param img
	 */
	public Dish(int id, String nom, String img) {
		super();
		this.id = id;
		this.nom = nom;
		this.img = img;
	}
	public Dish() {}
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
	 * @return the img
	 */
	@Column(name = "img")
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the partOfDiets
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_diets", referencedColumnName = "id")
	public List<Diet> getPartOfDiets() {
		return partOfDiets;
	}
	/**
	 * @param partOfDiets the partOfDiets to set
	 */
	public void setPartOfDiets(List<Diet> partOfDiets) {
		this.partOfDiets = partOfDiets;
	}
	/**
	 * @return the typeOfDish
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_dish", referencedColumnName = "id")
	public List<CookType> getTypeOfDish() {
		return typeOfDish;
	}
	/**
	 * @param typeOfDish the typeOfDish to set
	 */
	public void setTypeOfDish(List<CookType> typeOfDish) {
		this.typeOfDish = typeOfDish;
	}
	
	
	
}
