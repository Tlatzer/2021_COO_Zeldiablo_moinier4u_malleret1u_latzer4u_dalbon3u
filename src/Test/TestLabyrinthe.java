package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import jeuPerso.JeuPerso;
import jeuPerso.Labyrinthe;
import moteurJeu.Jeu;


public class TestLabyrinthe {

	
	/**
	 * Test la taille du Labyrinthe
	 */
	@Test
	public void testTailleLabyrinthe() {
		int longueur;
		int[][] tab = new int [20][20];
		
		JeuPerso jeu = new JeuPerso();
		Labyrinthe lab = jeu.getLabyrinthe();
		
		tab = lab.getLabyrinthe();
		longueur = tab.length;
		
		assertEquals("Le labyrinthe devrait avoir une longueur de 16", 16, longueur);
	}

	/**
	 * Test du bon Labyrinthe depuis le constructeur de la classe Labyrinthe
	 */
	@Test
	public void testChoixNiveau() {
		//préparation des données
		int[][] tabC = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};

		Labyrinthe lTest = new Labyrinthe("lvl 3");

		int[][] res = lTest.getLabyrinthe();

		//comparaison
		assertEquals("le jeu devrait etre le niveau 3 dans ce cas",tabC,res);
	}
	
	
}
