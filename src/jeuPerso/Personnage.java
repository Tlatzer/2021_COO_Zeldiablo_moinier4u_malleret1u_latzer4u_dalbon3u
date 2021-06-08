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
	public int pv;

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
		this.pv = 100;
	}

	/**
	 * deplacer le personnage dans une direction
	 *
	 * @param m
	 *            la chaine permettant de deplacer le personnage (N,S, E ou O)
	 */
	public void deplacer(Commande c) {
		int type = -1;
		if (c.gauche) {
			type = lab.getEmplacement(this.x-1,this.y);
			if(type==0 || type==2 || type == 3) this.x--;
		}

		if (c.droite) {
			type = lab.getEmplacement(this.x+1,this.y);
			if(type==0 || type==2 || type == 3) this.x++;
		}

		if (c.bas) {
			type = lab.getEmplacement(this.x,this.y+1);
			if(type==0 || type==2 || type == 3) this.y++;
		}

		if (c.haut) {
			type = lab.getEmplacement(this.x,this.y-1);
			if(type==0 || type==2 || type == 3) this.y--;
		}

		if(type == 2) lab.teleportation(this);
		
		if(type == 3) {
			this.degatCase();
			System.out.println("pv : " + this.pv);
		}
	}

	public int degatCase() {
		
		this.pv -= 50;
		if (this.pv == 0 || this.pv <0) {
			this.pv = 0;
			System.out.println("vous étes mort");
		}
		return this.pv;
	}
	
	
	public String toString() {
		return ("(" + this.x+","+this.y+")");
	}

	public Labyrinthe getLabyrinthe(){
		return this.lab;
	}
}
