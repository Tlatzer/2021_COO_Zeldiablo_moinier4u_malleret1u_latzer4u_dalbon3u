package jeuPerso;

import java.util.ArrayList;

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
	private Personnage pj;

	private ArrayList<Monstre> liste_monstre;

	/**
	 * constructeur de jeu avec un Personnage
	 */

	public JeuPerso() {
		this.pj=new Personnage();
		this.liste_monstre = new ArrayList<Monstre>();
		Monstre m = new Monstre(3,3);
		if(this.pj.getLabyrinthe().getEmplacement(3, 3)== 0)
			this.liste_monstre.add(new Monstre(3,3));
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
	public Personnage getPj() {
		return pj;
	}

	/**
	 * getter pour le labyrinthe
	 *
	 * @return le labyrinthe du jeu
	 */
	public Labyrinthe getLabyrinthe() {
		return pj.getLabyrinthe();
	}
	public ArrayList<Monstre> getListeMonstre() {
		return this.liste_monstre;
	}

}
