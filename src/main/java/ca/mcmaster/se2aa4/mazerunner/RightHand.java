package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;


enum Orientation {
	UP,
	RIGHT,
	DOWN,
	LEFT
}

public class RightHand implements MazeSolver {

	@Override
	public String solveMaze(ArrayList<ArrayList<String>> maze, Coordinate entry1, Coordinate entry2) {

		String path = "";
		// To monitor current location, as well as end point (assuming end is right entry)
		Coordinate currentPosition = entry1;
		Coordinate endPosition = entry2;
		// Enum for tracking orientation within maze, as 2D array coordinates will vary
		Orientation direction = Orientation.RIGHT;
		while(!Coordinate.equivalentTo(endPosition,currentPosition)){
			switch (direction){
				case RIGHT:
					// If right turn available, do as such
					if(!maze.get(currentPosition.getY()+1).get(currentPosition.getX()).equals("W")){
						currentPosition.setY(currentPosition.getY()+1);
						path += "RF";
						direction = Orientation.DOWN;
					}
					// If no right, go straight
					else if(!maze.get(currentPosition.getY()).get(currentPosition.getX()+1).equals("W")){
						currentPosition.setX(currentPosition.getX()+1);
						path += "F";
					}
					// If no straight, go left
					else if(!maze.get(currentPosition.getY()-1).get(currentPosition.getX()).equals("W")){
						currentPosition.setY(currentPosition.getY()-1);
						path += "LF";
						direction = Orientation.UP;
					// If all else fails, go back.
					}else{
						currentPosition.setX(currentPosition.getX()-1);
						path += "RRF";
						direction = Orientation.LEFT;
					}
					break;
				// Cases UP, DOWN, and LEFT all have the same decision logic of RIGHT (go right -> go straight -> go left -> turn around).
				case UP:
					if(!maze.get(currentPosition.getY()).get(currentPosition.getX()+1).equals("W")){
						currentPosition.setX(currentPosition.getX()+1);
						path += "RF";
						direction = Orientation.RIGHT;
					}
					else if(!maze.get(currentPosition.getY()-1).get(currentPosition.getX()).equals("W")){
						currentPosition.setY(currentPosition.getY()-1);
						path += "F";
					}
					else if(!maze.get(currentPosition.getY()).get(currentPosition.getX()-1).equals("W")){
						currentPosition.setX(currentPosition.getX()-1);
						path += "LF";
						direction = Orientation.LEFT;
					}else{
						currentPosition.setY(currentPosition.getY()+1);
						path += "RRF";
						direction = Orientation.DOWN;
					}
					break;
				case DOWN:
					if(!maze.get(currentPosition.getY()).get(currentPosition.getX()-1).equals("W")){
						currentPosition.setX(currentPosition.getX()-1);
						path += "RF";
						direction = Orientation.LEFT;
					}
					else if(!maze.get(currentPosition.getY()+1).get(currentPosition.getX()).equals("W")){
						currentPosition.setY(currentPosition.getY()+1);
						path += "F";
					}
					else if(!maze.get(currentPosition.getY()).get(currentPosition.getX()+1).equals("W")){
						currentPosition.setX(currentPosition.getX()+1);
						path += "LF";
						direction = Orientation.RIGHT;
					}else{
						currentPosition.setY(currentPosition.getY()-1);
						path += "RRF";
						direction = Orientation.UP;
					}
					break;
				case LEFT:
					if(!maze.get(currentPosition.getY()-1).get(currentPosition.getX()).equals("W")){
						currentPosition.setY(currentPosition.getY()-1);
						path += "RF";
						direction = Orientation.UP;
					}
					else if(!maze.get(currentPosition.getY()).get(currentPosition.getX()-1).equals("W")){
						currentPosition.setX(currentPosition.getX()-1);
						path += "F";
					}
					else if(!maze.get(currentPosition.getY()+1).get(currentPosition.getX()).equals("W")){
						currentPosition.setY(currentPosition.getY()+1);
						path += "LF";
						direction = Orientation.DOWN;
					}else{
						currentPosition.setX(currentPosition.getX()+1);
						path += "RRF";
						direction = Orientation.RIGHT;
					}
					break;
			}
		}
		System.out.println("PATH: " + path);
		ArrayList<String> factorizedPathElements = Factorization.FactorPath(path);
		String factorizedString = "";
		for(int i=0; i<factorizedPathElements.size(); i++){
			factorizedString += factorizedPathElements.get(i) + " ";
		}
		return factorizedString;
	}
	
}
