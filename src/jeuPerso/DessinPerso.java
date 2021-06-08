package jeuPerso;
import java.util.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import moteurJeu.DessinJeu;

/**
 * un afficheur graphique associe au JeuTest fourni
 *
 * @author vthomas
 */
public class DessinPerso implements DessinJeu {

	/**
	 * constante pour gerer la taille des cases
	 */
	private static int TAILLE_CASE = 25;

	/**
	 * lien vers le jeu a afficher
	 */
	private JeuPerso jeu;

	/**
	 * appelle constructeur parent
	 *
	 * @param j
	 *            le jeutest a afficher
	 */
	public DessinPerso(JeuPerso j) {
		this.jeu = j;
	}

	/**
	 * dessiner un objet consiste a dessiner sur l'image suivante methode
	 * redefinie de Afficheur
	 */
	private void dessinerObjet(String s, int x, int y, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		switch (s) {
		case "PJ":
			crayon.setColor(Color.blue);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "MONSTRE":
			crayon.setColor(Color.RED);
			crayon.fillOval(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
			TAILLE_CASE);
			break;
		case "MUR":
			crayon.setColor(Color.gray);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "TP":
			crayon.setColor(Color.cyan);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		case "PIEGE":
			crayon.setColor(Color.red);
			crayon.fillRect(x * TAILLE_CASE, y * TAILLE_CASE, TAILLE_CASE,
					TAILLE_CASE);
			break;
		default:
			throw new AssertionError("objet inexistant");
		}
	}

	/**
	 * methode dessiner redefinie de Afficheur retourne une image du jeu
	 */
	public void dessiner(BufferedImage im) {
		Personnage pj = jeu.getPj();


		for (int i=0;i<jeu.getLabyrinthe().getTaille();i++) {

			for (int j=0;j<jeu.getLabyrinthe().getTaille();j++) {

				if (jeu.getLabyrinthe().getEmplacement(i,j)==1 ) {
					this.dessinerObjet("MUR", i, j, im);
				}

				if (jeu.getLabyrinthe().getEmplacement(i,j)==2 ) {
					this.dessinerObjet("TP", i, j, im);
				}

				if (jeu.getLabyrinthe().getEmplacement(i,j)==3 ) {
					this.dessinerObjet("PIEGE", i, j, im);
				}
			}

		}
		this.dessinerObjet("PJ", pj.x, pj.y, im);

		ArrayList<Monstre> m = jeu.getListeMonstre();

		for(int k=0;k<m.size();k++) {
			this.dessinerObjet("MONSTRE",m.get(k).getX(),m.get(k).getY(),im);
		}
	}

}
