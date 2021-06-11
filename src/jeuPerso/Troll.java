package jeuPerso;

import moteurJeu.Commande;

public class Troll extends Monstre{

	
	// Constucteur
	public Troll(int x, int y) {
		super(x,y, 3);
	}
	
	@Override
	/**
	 * M�thode qui enl�ve 20 points de vie au Personnage
	 * @param pers
	 */
	public int attaquer(Personnage pers) {
		pers.pv -= 20;
		return pers.pv;
	}


	/**
	 * Ajoute un point de vie au Troll 
	 */
	public void regeneration() {
		int dep = 0;
		for (int i = 0; i < 5; i++) {
			dep += 1;
		}
		
		if(dep>=5) {
			setPv(getPv() + 1);
			System.out.println(this.getPv());
			dep=0;
		}
		
		if(this.getPv() == 3 || this.getPv() >= 3) {
			this.setPv(3);
		}
		
		if(this.getPv() == 0) {
			System.out.println("Le troll est mort");
		}	
	}
}
