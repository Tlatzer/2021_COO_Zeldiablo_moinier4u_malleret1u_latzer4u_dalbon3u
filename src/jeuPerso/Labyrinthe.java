package jeuPerso;
/**
 * classe modelisant un labyrinthe de 16 largeur par 16 de longueur
 */
public class Labyrinthe {

/**
 * attributs de Labyrinthe qui represente un tableau 2d de type entier
 */
	private int[][]labyrinthe = {
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,2,0,0,0,0,0,0,1,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
			{1,1,1,1,1,1,0,0,0,0,0,0,0,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,1,1,1,1,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1},
			{1,0,0,2,0,0,1,0,0,0,1,1,0,0,0,1},
			{1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
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
	 *  - 2 case de teleportation
	 */
	public int getEmplacement(int x, int y) {
		int res = 0;
		if(this.labyrinthe[x][y] == 0)
			res= 0;

		if(this.labyrinthe[x][y] == 1)
			res = 1;

		if(this.labyrinthe[x][y] == 2)
			res = 2;
		return res;
	}


	/**
	 * Methode permettant au joueur de se teleporter en 13 - 13
	 */
	public void teleportation(Personnage p){
		p.x = 13;
		p.y = 13;
	}

	/**
	 * Getter de labyrinthe
	 * @return retourne un tableau a deux dimension
	 */

	public int[][] getLabyrinthe(){
		return this.labyrinthe;
	}


	/**
	 * Getter de Labyrinthe
	 * @return retourne la taille du labyrinthe
	 */
	public int getTaille(){
		return this.labyrinthe.length;
	}
}
