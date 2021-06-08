package jeuPerso;

/**
 * 
 * Classe modelisant un monstre
 *
 */
public class Monstre {

/**
 * Nombre de points de vie d'un monstre
 */
	private int pv;
	
/**
 * Nombre degats d'attaque d'un monstre
 */
	private int degats;

/**
* Coordonnes du monstre en x 
*/
	private int x;
	
/**
* Coordonnes du monstre en y
 */
	private int y;
	
/**
 * Construction d'un monstre 
 */
	public Monstre(int abs, int ord) {
		this.pv = 10;
		this.degats = 2;
		this.x = abs;
		this.y = ord;
	}
	
/**
 * 	methode qui retourne les degats et les pv 
 * @return le nombre de pv et de degats dans un String 
 */
	public String toString() {
		return("Points de vie "+this.pv+" Degats: "+this.degats);
	}
/**
 * Getter de pv
 * @return le nombre de pv du monstre
 */
	public int getPv() {
		return this.pv;
	}
	
/**
 * Getter de degats
 * @return le nombre de degats 
 */
	public int getDegats() {
		return this.degats;
	}
/**
 * Getteur de l'attribut x
 * @return abbscisse du monstre
 */
	public int getX() {
		return this.x;
	}

/**
 * Gutter de l'attribut y
 * @return ordonnees
 */
	public int getY() {
		return this.y;
	}
	
	
}
