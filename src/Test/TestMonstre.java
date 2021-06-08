package Test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMonstre {

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

}
