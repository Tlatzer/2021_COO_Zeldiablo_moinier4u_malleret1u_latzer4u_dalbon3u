package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import jeuPerso.JeuPerso;
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
		
		assertEquals("le jeu devrait créer un monstre seulement",1,res);
	}
	
	@Test
	public void testCreationMonstreDansUnMur() {
		
		//preparation des donnees
		Personnage pj = new Personnage();
		Monstre m = new Monstre(6,5);
		
		
		//methode testee
		int a = pj.getLabyrinthe().getEmplacement(6, 5);
		
		//verification
		
		assertEquals("Le monstre devrait etre cr�ait", 1, a);
		
		
	}
}
