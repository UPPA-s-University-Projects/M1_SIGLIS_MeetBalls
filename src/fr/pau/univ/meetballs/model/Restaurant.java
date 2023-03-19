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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Restaurant")
@NamedQueries({
	@NamedQuery(name = "Restaurant.findById", query = "SELECT r FROM Restaurant r WHERE r.id = :id"),
	@NamedQuery(name = "Restaurant.findByCookType", query = "SELECT r FROM Restaurant r WHERE :cookTypeId = ANY (SELECT ct.id FROM r.cookType ct )"),
})
public class Restaurant {
	//Attributs
	private int id;
	private String name;
	private String address;
	private CookType cookType;
	private List<Dish> dishes;
	
	
	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param cookType
	 * @param dishes
	 */
	public Restaurant(int id, String name, String address, CookType cookType, List<Dish> dishes) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cookType = cookType;
		this.dishes = dishes;
	}
	
	/**
	 * Void constructor
	 */
	public Restaurant() {}
	
	
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
	 * @return the name
	 */
	@Column(name = "name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	@Column(name = "address")
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the cookType
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_cookingType", referencedColumnName = "id")
	public CookType getCookType() {
		return cookType;
	}
	/**
	 * @param cookType the cookType to set
	 */
	public void setCookType(CookType cookType) {
		this.cookType = cookType;
	}
	/**
	 * @return the dishes
	 */
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_cookingType", referencedColumnName = "id")
	public List<Dish> getDishes() {
		return dishes;
	}
	/**
	 * @param dishes the dishes to set
	 */
	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	
	
}
