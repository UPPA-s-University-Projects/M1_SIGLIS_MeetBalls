package fr.pau.univ.meetballs.tests;


import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.pau.univ.meetballs.model.CookType;
import fr.pau.univ.meetballs.model.User;

public class UserTests {
	
	//Attributs
    //Ils vont nous permettre de calculer le temps d'exécution des tests
    //En faisant la différence entre le temps de début et le temps de fin
	private static long startTime;
	private long testStartTime;
	
	private static User u1, u2, u3, u4, u5;
	private static CookType c1, c2, c3, c4;
	
	private static List<CookType> ct;
	
	@BeforeAll
	static void loadData() {
		System.out.println("==================================================================");
		System.out.println("Chargement des données en cours...");
		
		System.out.println(" > Chargement des données types de cuisines...");
		
		c1 = new CookType(1, "Thaï");
		c2 = new CookType(2, "Japonais");
		c3 = new CookType(3, "TexMex");
		c4 = new CookType(4, "Italien");
		
		
		System.out.println(" > Chargement des données users...");
		
		ct = Arrays.asList(c1, c3, c4);
//		u1 = new User(true, null, ct, null, null, null, 0);
//		
//		ct = Arrays.asList(c1, c4);
//		u2 = new User(false, null, ct, null, null, null, 0);
//		
//		ct = Arrays.asList(c2, c3);
//		u3 = new User(true, null, ct, null, null, null, 0);
//		
//		ct = Arrays.asList(c1, c4);
//		u4 = new User(true, null, ct, null, null, null, 0);
//		
//		ct = Arrays.asList(c1, c3, c4);
//		u5 = new User(false, null, ct, null, null, null, 0);
	
		System.out.println("Fin de chargement des données!");
		System.out.println("==================================================================");
		
	}
	
	@Test
	static void testItsCookingTime() {
		List<User> uList = Arrays.asList(u2,u3,u4,u5);
		
		uList = u1.itsCookingTime(uList);
		
		//Nous testons nos utilisateurs
//		assertEquals(0.46d, uList.get(0).getTauxCuisson(),0d);
//		assertEquals(0.53d, uList.get(2).getTauxCuisson(),0d);
//		assertEquals(0.76d, uList.get(3).getTauxCuisson(),0d);
//		assertThat(uList, hasItems(u5)); //Le résultat du dernier utilisateur < 23%, donc il n'est pas ajouté à la liste
	}
	
	@Test
	static void testMatch() {
		u2.addObjectToList(u2.getLikedUsers(), u1);
		u1.addObjectToList(u1.getLikedUsers(), u2);
		
		assertNull(u1.getLikedUsers());
	}
	
	
	
	/*
     * Nous allons utiliser les méthodes @BeforeAll et @AfterAll pour afficher le temps d'exécution total des tests
     * Nous allons utiliser les méthodes @BeforeEach et @AfterEach pour afficher le temps d'exécution de chaque test
     * 
     * Les méthodes @BeforeAll et @AfterAll sont exécutées une seule fois avant et après tous les tests
     * Les méthodes @BeforeEach et @AfterEach sont exécutées avant et après chaque test
     * 
     * Pour chaque test, on affiche le temps d'exécution du test
     */
	@BeforeAll
    static void setUpAll() {
        startTime = System.currentTimeMillis();
        System.out.println("Démarrage des tests...");
    }

    @BeforeEach
    void setUp() {
        testStartTime = System.currentTimeMillis();
        System.out.println("Démarrage d\'un test...");
    }
    
    
    @AfterEach
    void afterTest() {
        long testEndTime = System.currentTimeMillis();
        long testDuration = testEndTime - testStartTime;
        System.out.println("Test fini en " + testDuration + "ms");
    }

    @AfterAll
    static void afterAllTest() {
        long endTime = System.currentTimeMillis();
        long totalDuration = endTime - startTime;
        System.out.println("Tous les tests finis en " + totalDuration + "ms");
}
}