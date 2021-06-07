package jeuPerso;

import moteurJeu.Commande;

/**
 * la classe correspondant au Personnage
 */
public class Personnage {

	/**
	 * position en X et y
	 */
	public int x;
	public int y;

	public Labyrinthe lab;

	/**
	 * taille de l'environnement
	 */
	final static int LIMIT_X = 15;
	final static int LIMIT_Y = 15;

	/**
	 * constructeur vide
	 */
	public Personnage() {
		this.x = LIMIT_X / 2;
		this.y = LIMIT_Y / 2;
		this.lab = new Labyrinthe();
	}

	/**
	 * deplacer le personnage dans une direction
	 *
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 */
	public void deplacer(Commande c) {

		if (c.gauche) {
			if(lab.getEmplacement(this.x-1,this.y)==0) this.x--;
			if (this.x < 0) {
				this.x = 0;
			}
		}

		if (c.droite) {
			if(lab.getEmplacement(this.x+1,this.y)==0) this.x++;
			if (this.x >LIMIT_X) {
				this.x = LIMIT_X;
			}

		}

		if (c.bas) {
			if(lab.getEmplacement(this.x,this.y+1)==0) this.y++;
			if (this.y >LIMIT_Y) {
				this.y = LIMIT_Y;
			}
		}

		if (c.haut) {
			if(lab.getEmplacement(this.x,this.y-1)==0) this.y--;
			if (this.y < 0) {
				this.y = 0;
			}
		}
	}

	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

	public Labyrinthe getLabyrinthe(){
		return this.lab;
	}
}
