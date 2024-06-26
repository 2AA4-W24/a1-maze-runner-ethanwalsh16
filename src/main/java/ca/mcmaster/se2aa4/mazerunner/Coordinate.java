package ca.mcmaster.se2aa4.mazerunner;

public class Coordinate {
	// Class to handle coordinates, used for moving through mazes and finding solution path.
	int x;
	int y;

	public Coordinate(int xCoordinate, int yCoordinate){
		x = xCoordinate;
		y = yCoordinate;
	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public void setX(int new_x){
		this.x = new_x;
	}

	public void setY(int new_y){
		this.y = new_y;
	}

	// Comparator function, used to determine whether path is at end of maze.
	public static boolean equivalentTo(Coordinate c1, Coordinate c2){
		if((c2.getX() == c1.getX()) && (c2.getY() == c1.getY())){
			return true;
		}else{
			return false;
		}
	}
}
