package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import jeuPerso.JeuPerso;
import jeuPerso.Monstre;
import jeuPerso.Personnage;

public class TestMonstre {

	/**
	 * Test des créations des monstres par le jeu
	 */
	@Test
	public void testCreationMonstre() {
		//on créé un jeu avec le constructeur par défaut
		JeuPerso j = new JeuPerso();

		//on prend la liste de monstre de ce jeu créé
		ArrayList<Monstre> l = j.getListeMonstre();

		//on prend le nombre de monstre qui ont été créé par ce jeu
		int res = l.size();
		
		assertEquals("le jeu devrait cre�er un monstre seulement",1,res);
	}
	/**
	 * Test la creation d'un monstre dans un mur 
	 */
	@Test
	public void testCreationMonstreDansUnMur() {
		
		//preparation des donnees

		JeuPerso jeu = new JeuPerso();
		Monstre m = new Monstre(6,5);
		jeu.getListeMonstre().add(m);
		
		
		//methode testee
		int a = jeu.getLabyrinthe().getEmplacement(6, 5);
		
		//verification
		
		assertEquals("Le monstre ne devrait pas etre cr�ait", 1, a);
		
		
	}
	
	/**
	 * Test la creation d'un monstres sur des cases vides 
	 */
	@Test
	public void testCreationMonstreDansCasesVides() {
		
		//preparation des donnees
		JeuPerso jeu = new JeuPerso();
		Monstre m = new Monstre(5,5);
		jeu.getListeMonstre().add(m);
		
		
		//methode testee
		int a = jeu.getLabyrinthe().getEmplacement(5, 5);
		
		//verification
		
		assertEquals("Le monstre ne devrait pas etre cr�ait", 0, a);
		
		
	}
	
	@Test
	public void testColisionMonstreJoueur() {
		
		//preparation des donnees
		Monstre m = new Monstre(6,7);
		JeuPerso jeu = new JeuPerso();
		
		//methode testee
		jeu.getLabyrinthe().setLabyrinthe(6, 7, 4); // 4 car c'est un monstre
		
		
		//verification
		assertEquals("le monstre ne devrait pas etre en colision avec le joueur",4, jeu.getLabyrinthe().getEmplacement(6, 7));
		
		
	}
}
