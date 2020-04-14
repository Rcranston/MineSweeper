
//	@author Ryan Cranston
//	@tag CSCD350 Minesweeper Solution
//	@Team3

import java.util.*;



public class MinefieldSolver {

	public static void main(String[] args) {
	
		int x=1, y=1;
		String line;
		Scanner in = new Scanner(System.in);
		
		for(int num=1;true;num++){
			x=in.nextInt();
			y=in.nextInt();
			
			if(x==0&y==0) {
				in.close();
				return;
			}
			char[][] field=new char[x][y];
			for(int col=0;col<y;col++) {
				line=in.next();
				for(int row=0;row<x;row++) {
					field[row][col]=line.charAt(row);
				}
			}
			field=Solver(field,x,y);
			System.out.println("Field #"+num+":");
			PrintField(field,x,y);
		}
	}

	private static char[][] Solver(char[][] field,int x, int y) {
		int sum;
		
		for(int col=0;col<y;col++) {
			for(int row=0;row<x;row++) {
				sum=0;
				if(field[row][col]=='*'){
				}
				else {
					//Right
					if(row-1>=0){
						if(field[row-1][col]=='*')
							sum++;
					}
					//Right-down
					if(row-1>=0&&col-1>=0){
						if(field[row-1][col-1]=='*')
							sum++;
					}
					//Down
					if(col-1>=0){
						if(field[row][col-1]=='*')
							sum++;
					}
					//Left-down
					if(row+1<=x-1&&col-1>=0){
						if(field[row+1][col-1]=='*')
							sum++;
					}
					//Left
					if(row+1<=x-1){
						if(field[row+1][col]=='*')
							sum++;
					}
					//Left-up
					if(row+1<=x-1&&col+1<=y-1){
						if(field[row+1][col+1]=='*')
							sum++;
					}
					//Up
					if(col+1<=y-1){
						if(field[row][col+1]=='*')
							sum++;
					}
					//Right-up
					if(row-1>=0&&col+1<=y-1){
						if(field[row-1][col+1]=='*')
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
		for(int col=0;col<y;col++) {
			for(int row=0;row<x;row++) {
				System.out.print(field[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
