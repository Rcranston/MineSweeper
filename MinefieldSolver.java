
//	@author Ryan Cranston
//	@tag CSCD350 Minesweeper Solution
//	@Team3

import java.util.*;



public class MinefieldSolver {

	public static void main(String[] args) {
	
		int xBound = 1;
		int yBound = 1;
		String Line;
		Scanner In = new Scanner(System.in);
		
		for(int num = 1; true; num++){
			
			//Set the bounds for the mine field.
			xBound = In.nextInt();
			yBound = In.nextInt();
			
			//If the fields are empty.
			if(xBound == 0 & yBound == 0) {
				
				In.close();
				return;
			}
			
			char[][] field=new char[xBound][yBound];
			
			for(int col = 0; col < yBound; col++) {
				
				//Grab the next line of the mine field input.
				Line=In.next();
				
				for(int row = 0; row < xBound; row++) {
					
					//Copy the next line of the mine field input text to the array.
					field[row][col]=Line.charAt(row);
				}
			}
			
			field = Solver(field, xBound, yBound);
			System.out.println("Field #" + num + ":");
			PrintField(field, xBound, yBound);
		}
	}
	//This method will calculate the number of land mines surrounding a tile
	//and increment its land mine count accordingly.
	private static char[][] Solver(char[][] field,int x, int y) {
		
		//This is the count of the land mines on the particular tile.
		int sum;
		
		for(int col = 0; col < y; col++) {
			for(int row = 0; row < x; row++) {
				
				sum = 0;
				
				if(field[row][col] == '*'){
					//This tile contains a land mine; do nothing.
				}
				else {
					//If the tile in question does not contain a land mine
					// check all surrounding tiles.
					
					//Right
					if(row-1>=0){
						
						if(field[row-1][col]== '*')
							
							sum++;
					}
					//Right-down
					if(row-1 >= 0 && col - 1 >= 0){
						
						if(field[row-1][col-1] == '*')
							
							sum++;
					}
					//Down
					if(col - 1 >= 0){
						
						if(field[row][col-1] == '*')
							
							sum++;
					}
					//Left-down
					if(row + 1 <= x - 1 && col - 1 >= 0){
						
						if(field[row+1][col-1] == '*')
							
							sum++;
					}
					//Left
					if( row + 1 <= x - 1){
						
						if(field[row+1][col] == '*')
							
							sum++;
					}
					//Left-up
					if(row + 1 <= x - 1 && col + 1 <= y - 1){
						
						if(field[row+1][col+1] =='*')
							
							sum++;
					}
					//Up
					if(col + 1 <= y - 1){
						
						if(field[row][col+1] == '*')
							
							sum++;
					}
					//Right-up
					if(row-1>=0&&col+1<=y-1){
						
						if(field[row-1][col+1] == '*')
							
							sum++;
					}
					field[row][col]=((char)(sum+'0'));
				}
			}
		}
		return field;
	}
	
	private static void PrintField(char[][] field,int x,int y)
	{
		for(int col = 0; col < y; col++) {
			for(int row = 0; row < x; row++) {
				
				System.out.print(field[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
