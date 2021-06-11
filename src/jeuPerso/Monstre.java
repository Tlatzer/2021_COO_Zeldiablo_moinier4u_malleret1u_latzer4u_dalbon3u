package jeuPerso;

/**
 *
 * Classe modelisant un monstre
 *
 */
public abstract class  Monstre {

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
	public Monstre(int abs, int ord, int pv2) {
		this.setPv(pv2);
		this.degats = 2;
		this.x = abs;
		this.y = ord;
	}


	/**
 	 * Methode qui permet au Monstre de se deplacer aleatoirement dans le labyrinthe
	 */
	public void deplacerAleatoire(Labyrinthe lab){
		//si aucune direction n'est defini alors on lui en met une aleatoire
		int type = -1;
		int cote =(int) (Math.random()*4);
		switch(cote) {
			case 0:
					type = lab.getEmplacement(this.x,this.y-1);
					if(type==0 || type==2 || type == 3) this.y--;
				break;
			case 1:
					type = lab.getEmplacement(this.x,this.y+1);
					if(type==0 || type==2 || type == 3) this.y++;
				break;
			case 2 :
					type = lab.getEmplacement(this.x-1,this.y);
					if(type==0 || type==2 || type == 3) this.x--;
				break;
			case 3 :
					type = lab.getEmplacement(this.x+1,this.y);
					if(type==0 || type==2 || type == 3) this.x++;
				break;
			}
	}

	
	public abstract void attaquer(Personnage pers);
	
	

	/**
 	 * Methode qui permet au Monstre de se rapprocher du Joueur
	 */
	public void deplacerProcheHero(Labyrinthe l, Personnage h){
		int type = -1;
		int distXAbs, distYAbs;
		int distX = this.x - h.x;
		int distY = this.y - h.y;
		if(distX < 0) distXAbs = -distX; else distXAbs = distX;
		if(distY < 0) distYAbs = -distY; else distYAbs = distY;
		if(distXAbs>distYAbs){
			if(distX>0){
				type = l.getEmplacement(this.x-1,this.y);
				if(this.x-1!=h.x || this.y!=h.y){
					if(type==0 || type==2 || type == 3) this.x--;
				}
			}else{
				type = l.getEmplacement(this.x+1,this.y);
				if(this.x+1!=h.x || this.y!=h.y){
					if(type==0 || type==2 || type == 3) this.x++;
				}
			}
		}else{
			if(distY>0){
				type = l.getEmplacement(this.x,this.y-1);
				if(this.x!=h.x || this.y-1!=h.y){
					if(type==0 || type==2 || type == 3) this.y--;
				}
			}else{
				type = l.getEmplacement(this.x,this.y+1);
				if(this.x!=h.x || this.y+1!=h.y){
					if(type==0 || type==2 || type == 3) this.y++;
				}
			}
		}
	}

/**
 * 	methode qui retourne les degats et les pv
 * @return le nombre de pv et de degats dans un String
 */
	public String toString() {
		return("Points de vie "+this.getPv()+" Degats: "+this.degats);
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
	

	protected void setPv(int pv) {
		this.pv = pv;
	}


}