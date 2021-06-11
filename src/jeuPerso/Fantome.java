package jeuPerso;
import java.util.Random;

public class Fantome extends Monstre {

	private int x;
	private int y;
	
	public Fantome(int abs, int ord) {
		super(abs, ord);
	}
		
	/**
 	 * Methode qui permet au Monstre de se deplacer aleatoirement dans le labyrinthe
	 */
	public void deplacerAleatoire(Labyrinthe lab){
		Random random = new Random();
		//si aucune direction n'est defini alors on lui en met une aleatoire
		int type = -1;
		int cote = random.nextInt(4);
		switch(cote) {
			case 0:
					type = lab.getEmplacement(this.x,this.y-1);
					if(type==0 || type==2 || type == 3 || type == 1) this.y--;
				break;
			case 1:
					type = lab.getEmplacement(this.x,this.y+1);
					if(type==0 || type==2 || type == 3 || type == 1) this.y++;
				break;
			case 2 :
					type = lab.getEmplacement(this.x-1,this.y);
					if(type==0 || type==2 || type == 3 || type == 1) this.x--;
				break;
			case 3 :
					type = lab.getEmplacement(this.x+1,this.y);
					if(type==0 || type==2 || type == 3 || type == 1) this.x++;
				break;
			}
	}
		
		public void attaquer(Personnage pj) {
			pj.pv -= 15;
		}
}
