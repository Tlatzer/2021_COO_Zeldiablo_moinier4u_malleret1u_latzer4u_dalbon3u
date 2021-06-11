package jeuPerso;

import java.util.*;
/**
 * classe modelisant un labyrinthe de 16 largeur par 16 de longueur
 */
public class Labyrinthe {

/**
 * attributs de Labyrinthe qui represente un tableau 2d de type entier
 */


private final static int taille = 16;

private int dimensionX, dimensionY; 
private int[][] grid; 
private Cell[][] cells;
private Random random = new Random();


public Labyrinthe() {
	this(taille, taille);
}
// constructeur
public Labyrinthe(int xDimension, int yDimension) {
	dimensionX = taille;
	dimensionY = taille;
	grid = new int[dimensionX][dimensionY];
	init();
	generateMaze();
	updateGrid();
}

private void init() {
	// create cells
	cells = new Cell[dimensionX][dimensionY];
	for (int x = 0; x < dimensionX; x++) {
		for (int y = 0; y < dimensionY; y++) {
			cells[x][y] = new Cell(x, y, false); // create cell (see Cell constructor)
		}
	}
}






// ----------------------inner class to represent a cell-----------------------------
private class Cell {
  int x, y; // coordinates

  ArrayList<Cell> neighbors = new ArrayList<>();

  boolean visited = false;

  boolean wall = true;

  boolean open = true;
  // construct Cell at x, y
  Cell(int x, int y) {
	  this(x, y, true);
  }
  
  Cell(int x, int y, boolean isWall) {
	  this.x = x;
	  this.y = y;
	  this.wall = isWall;
  }
  /*
  *ajoute d'un nouveau voisin dans la liste
  */
  void addNeighbor(Cell other) {
	  if (!this.neighbors.contains(other)) { // evite les doublons
		  this.neighbors.add(other);
	  }
	  if (!other.neighbors.contains(this)) { // evite les doublons
		  other.neighbors.add(this);
	  }
  }

  /**
   *  utilisé dans UpdateGrip 
   */
  boolean isCellBelowNeighbor() {
	  if (this.y==taille-1)
		  return false;
	  else
	  return this.neighbors.contains(new Cell(this.x, this.y + 1));
  }

  /**
   *  utilisé dans UpdateGrip 
   */
  boolean isCellRightNeighbor() {
	  if (this.x==taille-1)
		  return false;
	  else 
		  return this.neighbors.contains(new Cell(this.x + 1, this.y));
  }

  @Override
  public String toString() {
	  return String.format("Cell(%s, %s)", x, y);
  }

  @Override
  public boolean equals(Object other) {
	  if (!(other instanceof Cell)) return false;
	  Cell otherCell = (Cell) other;
	  return (this.x == otherCell.x && this.y == otherCell.y);
  }

}

private void generateMaze() {
	generateMaze(0, 0);
}

private void generateMaze(int x, int y) {
	generateMaze(getCell(x, y)); 
}
private void generateMaze(Cell startAt) {

  if (startAt == null) return;
  startAt.open = false; 
  ArrayList<Cell> cells = new ArrayList<>();
  cells.add(startAt);

  while (!cells.isEmpty()) {
	  Cell cell;
	  if (random.nextInt(10)==0)
		  cell = cells.remove(random.nextInt(cells.size()));
	  else cell = cells.remove(cells.size() - 1);

	  ArrayList<Cell> neighbors = new ArrayList<>();

	  Cell[] potentialNeighbors = new Cell[]{
		  getCell(cell.x + 1, cell.y),
		  getCell(cell.x, cell.y + 1),
		  getCell(cell.x - 1, cell.y),
		  getCell(cell.x, cell.y - 1)
	  };
	  for (Cell other : potentialNeighbors) {
		  if (other==null || other.wall || !other.open) continue;
		  neighbors.add(other);
	  }
	  if (neighbors.isEmpty()) continue;

	  Cell selected = neighbors.get(random.nextInt(neighbors.size()));
	  selected.open = false; 
	  cell.addNeighbor(selected);
	  cells.add(cell);
	  cells.add(selected);
  }
}
public Cell getCell(int x, int y) {
	try {
		return cells[x][y];
	} catch (ArrayIndexOutOfBoundsException e) {
		return null;
	}

}

/**
 * créer le tableau en lui meme 
 */
public void updateGrid() {
	
	// fill background
    for (int x = 0; x < dimensionX; x++) {
	  	for (int y = 0; y < dimensionY; y++) {
			grid[x][y] = 1;
	  	}
    }


  for (int x=0;x<dimensionX;x++){
	  for (int y=0;y<dimensionY;y++) {
		  Cell current = getCell(x,y);

		  if (current.isCellBelowNeighbor()) {
			  if(y<taille-1) {
				  if (getCell(x,y+1).wall){
					grid[x + 1][y] = 1;
				  }else {
					  grid[x][y + 1] = 0;
				  }
				  
			  }
	  }
	  if (current.isCellRightNeighbor()) {
		  if(x<taille-1) {
			  if(getCell(x+1,y).wall) {
				grid[x+1][y] = 1;
			  }else {
				grid[x + 1][y] = 0;
			  }
		  }
		  
	  }

  }
}

  grid[6][7] = 0;
  grid[7][7] = 0;
  grid[7][8] = 0;

  for (int i=0;i<taille;i++){
	  for(int j=0;j<taille;j++) {
		  
			int r = random.nextInt(24);
			
			if (r==0 && grid[i][j]==1 && i!=0 && j!=0 && j!=taille-1 && i!=taille-1) {
				grid[i][j] = 2;
			}else if(r==1 && grid[i][j]==0 && i!=0 && j!=0 && j!=taille-1 && i!=taille-1) {
				grid[i][j] = 3;
			}

		  grid[j][0] = 1;
		  grid [j][taille-1] = 1;
	  }
	  grid[0][i] = 1;
	  grid[taille-1][i] = 1;
  }
  System.out.println("yooo");

}

	/**
	 *@param x coordonnees du personnage en abscisse
	 * @param y coordonnes du personnage en ordonne
	 * @return retourne un entier qui correspond a :
	 *  - 0 libre
	 *  - 1 mur
	 *  - 2 case de teleportation
	 *  - 3 case de degats
	 */
	public int getEmplacement(int x, int y) {
		int res = 0;
		if(this.grid[x][y] == 0)
			res= 0;

		if(this.grid[x][y] == 1)
			res = 1;

		if(this.grid[x][y] == 2)
			res = 2;

		if(this.grid[x][y] == 3)
			res = 3;
		
		if(this.grid[x][y] == 4)
			res = 4;

		return res;
	}


	/**
	 * Methode permettant au joueur de se teleporter en 13 - 13
	 */
	public void teleportation(Personnage p){
		int r = random.nextInt(taille-2);
		r = r+2;
		teleportation(p,r,r);
	}
	
	/**
	 * Methode permettant au joueur de se teleporter dans la case dans laquel on veut
	 */
	public void teleportation(Personnage p,int x,int y){
		if (grid[x][y]==0) {
			p.x = x;
			p.y = y;
		}else {
			ArrayList<Integer> l = new ArrayList<>();
			for (int i=1;i<taille-1;i++){
				if (grid[i][y]==0) {
					l.add(i);
				}
			}
			int r = random.nextInt(l.size()-1);

			p.x = r;
			p.y = y;
		}
	}


	/**
	 * Getter de labyrinthe
	 * @return retourne un tableau a deux dimension
	 */

	public int[][] getLabyrinthe(){
		return this.grid;
	}


	/**
	 * Getter de Labyrinthe
	 * @return retourne la taille du labyrinthe
	 */
	public int getTaille(){
		return this.taille;
	}
	/**
	 * 
	 */
	public void setLabyrinthe(int x, int y, int num) {
		this.grid[x][y] = num;
	}

}