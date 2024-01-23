package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

public class Verifier {
	
	public static String verifyPath(String userPath, ArrayList<ArrayList<String>> matrix, Coordinate[] entries){
		Coordinate currentPos = entries[0];
		Coordinate endPoint = entries[1];
		Orientation direction = Orientation.RIGHT;
		String result = "Incorrect";
		for(int i=0; i<userPath.length(); i++){
			switch(direction){
				case RIGHT:
					if(userPath.charAt(i) == 'F'){
						// Check for path, then increase
						if(matrix.get(currentPos.getY()).get(currentPos.getX()+1).equals("W")){
							return result;
						}else{
							currentPos.setX(currentPos.getX()+1);
						}
					}else if(userPath.charAt(i) == 'R'){
						direction = Orientation.DOWN;
					}else if(userPath.charAt(i) == 'L'){
						direction = Orientation.UP;
					}
					break;
				case DOWN:
					if(userPath.charAt(i) == 'F'){
						// Check for path, then increase
						if(matrix.get(currentPos.getY()+1).get(currentPos.getX()).equals("W")){
							return result;
						}else{
							currentPos.setY(currentPos.getY()+1);
						}
					}else if(userPath.charAt(i) == 'R'){
						direction = Orientation.LEFT;
					}else if(userPath.charAt(i) == 'L'){
						direction = Orientation.RIGHT;
					}
					break;
				case LEFT:
					if(userPath.charAt(i) == 'F'){
						// Check for path, then increase
						if(matrix.get(currentPos.getY()).get(currentPos.getX()-1).equals("W")){
							return result;
						}else{
							currentPos.setX(currentPos.getX()-1);
						}
					}else if(userPath.charAt(i) == 'R'){
						direction = Orientation.UP;
					}else if(userPath.charAt(i) == 'L'){
						direction = Orientation.DOWN;
					}
					break;
				case UP:
					if(userPath.charAt(i) == 'F'){
						// Check for path, then increase
						if(matrix.get(currentPos.getY()-1).get(currentPos.getX()).equals("W")){
							return result;
						}else{
							currentPos.setY(currentPos.getY()-1);
						}
					}else if(userPath.charAt(i) == 'R'){
						direction = Orientation.RIGHT;
					}else if(userPath.charAt(i) == 'L'){
						direction = Orientation.LEFT;
					}
					break;
			}
			if(Coordinate.equivalentTo(currentPos,endPoint)){
				result = "Correct";
				break;
			}
		}
		return result;
	}

	public static boolean correctPath(String userPath){
		boolean correctChars = true;
		for(int i=0; i<userPath.length(); i++){
			if(userPath.charAt(i) != 'F' && userPath.charAt(i) != 'R' && userPath.charAt(i) != 'L'){
				correctChars = false;
				return correctChars;
			}
		}
		return correctChars;
	}
}
