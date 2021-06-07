package jeuPerso;
/**
 * classe modelisant un labyrinthe de 16 largeur par 16 de longueur
 */
public class Labyrinthe {

/**
 * 
 */
	private int[][]labyrinthe = {
			{0,0,0,1,1,0,1,1,1,0,1,0,1,0,0,1},
			{1,0,1,0,1,1,0,0,0,1,0,0,0,1,1,0},
			{0,0,0,1,1,0,1,1,1,0,0,0,1,0,0,1},
			{0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,0},
			{0,0,0,1,1,0,1,0,1,0,0,0,1,0,0,1},
			{0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,0},
			{0,0,0,1,1,0,1,0,1,0,0,0,0,0,0,1},
			{0,0,1,0,1,1,0,1,0,1,0,0,0,1,1,0},
			{0,0,0,1,1,0,1,0,1,0,0,0,0,0,0,1},
			{0,0,1,0,1,1,0,1,0,1,0,0,0,1,1,0},
			{0,0,0,1,1,0,0,1,1,0,1,0,0,0,0,1},
			{0,0,1,0,1,1,0,0,0,1,0,0,0,1,1,0},
			{0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,1},
			{0,0,1,0,1,0,0,0,0,1,0,0,0,1,1,0},
			{0,0,0,1,1,0,0,0,1,0,1,0,0,0,0,1},
			{0,0,1,0,1,1,0,1,0,1,0,0,0,1,1,0}
	};
	
/**
 * constructeur vide
 * 
 **/
	public Labyrinthe() {

	}
	
	/**
	 *@param x coordonnees du personnage en abscisse
	 * @param y coordonnes du personnage en ordonne
	 * @return retourne un entier qui correspond a :
	 *  - 0 libre 
	 *  - 1 mur  
	 */
	public int getEmplacement(int x, int y) {
		if(this.labyrinthe[x][y] == 0) {
			
		}
	}
	
	
	/**
	 * Getter de labyrinthe 
	 * @return retourne un tableau a deux dimension 
	 */
	
	public int[][] getLabyrinthe(){
		return this.labyrinthe;
	}
}
