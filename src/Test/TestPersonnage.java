package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import jeuPerso.JeuPerso;
import jeuPerso.Labyrinthe;
import jeuPerso.Personnage;

public class TestPersonnage {

	@Test
	public void testCasePersonnage_1() {
		
		JeuPerso jeu = new JeuPerso();
		Personnage pers = jeu.getPj();
		Labyrinthe lab = jeu.getLabyrinthe();
		
		int res = lab.getEmplacement(2,2);
		
		assertEquals("Le Personnage devrait être sur une case libre", res, 0);
		
	}
	
	@Test
	public void testCasePersonnage_2() {
		
		JeuPerso jeu = new JeuPerso();
		Personnage pers = jeu.getPj();
		Labyrinthe lab = jeu.getLabyrinthe();
		
		int res = lab.getEmplacement(2,0);
		
		assertEquals("Le Personnage devrait ne pas être sur une case libre", res, 1);
		
	}
	
	@Test
	public void testSpawnPersonnage() {
		
		JeuPerso jeu = new JeuPerso();
		Personnage pers = jeu.getPj();
		Labyrinthe lab = jeu.getLabyrinthe();
		
		int res = lab.getEmplacement(2,0);
		
		assertEquals("Le Personnage devrait ne pas être sur une case libre", res, 1);
		
	}

	

}
