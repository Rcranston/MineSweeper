package minesweeper;
import java.util.Scanner;
public class minesweeper {
	public static void main(String[] args) {
		String input = "4 4\n"	//currently troubleshooting why my java is out of date for cmd
				+ "*...\n"		//but not for eclipse
				+ "....\n"		//currently just hard coding a string for now.
				+ ".*..\n"
				+ "....\n"
				+ "3 5\n"
				+ "**...\n" 
				+ ".....\n" 
				+ ".*...";
		
		if(input.equals("")) {	//I actually don't know why I have this check for a string in here if I hardcoded it...
			System.out.print("Needs input!");
		}
		else {
			
			Scanner in = new Scanner(input); //reads the input string
			in.useDelimiter("");
			
			while(in.hasNextLine()) {
			
				MinefieldInitializer(in);
			}
		}
	}
	private static void MinefieldInitializer(Scanner in) {
		
		int xMax = in.nextInt();	//x bound
		in.next();
		int yMax = in.nextInt();	//y bound
		Object[][] minefield = new Object[xMax][yMax];	//gonna shove the minefield into an array
		
		int tempx;
		int tempy;	
		in.next();				//reset delimiter	
		String delimiter;		//saves the current token from the scanner
		
		for(tempx = 0; tempx <= xMax - 1; tempx++) {		//walk through the minefield but be careful!
			for(tempy = 0; tempy <= yMax - 1; tempy++) {
				
				delimiter = in.next();					//saved the delimiter to a string for bugtesting purposes
				
				if(delimiter.equals("*")) {				//if this is a land mine
					
					minefield[tempx][tempy] = "*";		//initialize * in array
					countIncrementor(minefield, tempx, tempy, xMax,yMax);	//update tiles around the land mine
				}
				else {	//not a landmine
					
					if(minefield[tempx][tempy] == null) {	//if the tile hasn't been initialized already
															//(land mines initialize the tiles around themselves)
						minefield[tempx][tempy] = 0;
					}
				}
			}
			if(in.hasNext()) {//move to next line (unless EOF)
				in.next();
			}
		}
		PrintMinefield(minefield, xMax, yMax);	//print when done.
	}
	private static void countIncrementor(Object[][] minefield, int x, int y, int xMax, int yMax) {
		//This function will increment the mine count of the tiles surrounding
		//a land mine.
		
		for(int i = x - 1; i <= x + 1; i++) {		//this nested for loop will select each of the 8 tiles
			for(int j = y - 1; j <= y + 1; j++) {	//surrounding the land mine in question
				
				if(i < 0 || j < 0 || i >= xMax || j >= yMax) {		//out of bounds (0 based indexing)
					//do nothing
				}
				else if(i == x && j == y) {		//This coordinate the land mine. We do not want to change this.
					//do nothing
				}
				else {								//if the highlighted tile is within bounds and is not a land mine
					
					if(minefield[i][j] == null) {	//if it hasn't been initialized yet
					
						minefield[i][j] = 0;
					}
					if(minefield[i][j] != null && minefield[i][j] != "*") {	//if it has been initialized and is not a neighboring land mine
																			
						minefield[i][j] = (int)minefield[i][j] + 1;			//increment the land mine count on that tile.
					}
				}
			}
		}
	}
	private static void PrintMinefield(Object[][] minefield, int xMax, int yMax) {
		
		for(int tempx = 0; tempx < xMax; tempx++) {			//nested for loop to print the array. nothing special.
			for(int tempy = 0; tempy < yMax; tempy++) {
				System.out.print(minefield[tempx][tempy]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
