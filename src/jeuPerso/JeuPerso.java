package jeuPerso;

import moteurJeu.Commande;
import moteurJeu.Jeu;

/**
 * classe qui contient les donnees du jeu. Pour le moment, il ne possede qu'un
 * personnage
 *
 */
public class JeuPerso implements Jeu {

	/**
	 * le personnage du jeu
	 */
	private static Personnage pj;

	/**
	 * le labyrinthe du jeu
	 */
	private static Labyrinthe l;

	/**
	 * constructeur de jeu avec un Personnage
	 */
	public JeuPerso() {
		this.l = new Labyrinthe();
		this.pj=new Personnage();
	}

	/**
	 * surcharge toString
	 */
	public String toString() {
		return ("" + this.getPj() + "+");
	}

	/**
	 * demande a deplacer le personnage
	 *
	 * @param commande
	 *            chaine qui donne ordre
	 */
	public void evoluer(Commande commande) {
		this.getPj().deplacer(commande);

	}

	@Override
	public boolean etreFini() {
		// le jeu n'est jamais fini
		return false;
	}

	/**
	 * getter pour l'affichage
	 *
	 * @return personnage du jeu
	 */
	public static Personnage getPj() {
		return pj;
	}

	/**
	 * getter pour le labyrinthe
	 *
	 * @return le labyrinthe du jeu
	 */
	public static Labyrinthe getLabyrinthe() {
		return l;
	}

}
