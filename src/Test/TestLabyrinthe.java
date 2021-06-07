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
		Labyrinthe lab = JeuPerso.getLabyrinthe();
		
		tab = lab.getLabyrinthe();
		longueur = tab.length;
		
		assertEquals("Le labyrinthe devrait avoir une longueur de 16", 16, longueur);
		
	}
	
	
	
	

}
