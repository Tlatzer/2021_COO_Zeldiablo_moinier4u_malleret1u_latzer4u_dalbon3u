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

	private Labyrinthe labyrinthe;

	/**
	 * constructeur de jeu avec un Personnage
	 */
	public JeuPerso() {
		this.pj=new Personnage();
		this.liste_monstre = new ArrayList<Monstre>();
		Monstre m = new Monstre(5,3);
		this.labyrinthe = new Labyrinthe();
		if(( this.labyrinthe.getEmplacement(m.getX(), m.getY()))== 0)
			this.labyrinthe.setLabyrinthe(5, 3, 4);
			this.liste_monstre.add(m);
	}

	/**
	 * constructeur
	 */
	public JeuPerso(String lvl) {
		this.pj=new Personnage(lvl);
		this.liste_monstre = new ArrayList<Monstre>();
		Monstre m = new Monstre(5,3);
		this.labyrinthe = new Labyrinthe();
		if(( this.labyrinthe.getEmplacement(m.getX(), m.getY()))== 0)
			this.liste_monstre.add(m);
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
		this.getPj().deplacer(commande, this.labyrinthe);
		
		for (int i = 0; i < liste_monstre.size(); i++) {
			this.liste_monstre.get(i).deplacerAleatoire(this.labyrinthe);
		}

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
		return this.labyrinthe;
	}

	public ArrayList<Monstre> getListeMonstre() {
		return this.liste_monstre;
	}

}
