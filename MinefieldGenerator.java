

//	@author Ryan Cranston, Chris Davisson, Morgan Combs
//	@tag CSCD350 Minesweeper generator
//	@Team3

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MinefieldGenerator {
	
	public static void main(String[] args) throws IOException {

		int xBound, yBound, Gen;
		String Output ="";
		Scanner Input = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Please Enter the size of the generated minefield you would like in the (X,Y,Generation Amount 0-100%)");
			xBound = Input.nextInt();
			yBound = Input.nextInt();
			
			//If the user enters 0 for x bound and y bound
			//this protocol will save the file and close.
			if(xBound == 0 && yBound == 0){	
				try {
				
					Input.nextLine();
					System.out.print("Full path for output file> ");
					String url = Input.nextLine();
					url = url + "\\OutputMine.txt";
					
					Input.close();
					Path path = Paths.get(url);
					Output = Output + "0 0";
				
					Files.writeString(path, Output);
					System.out.println("Minefield Gen Successful at> " + path);
					return;
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			//If the user input non-zero numbers, then this code will run.
			Gen = Input.nextInt();
			Output = Output + GenMap(xBound, yBound, Gen);
			
			System.out.println("To end generation please enter 0 for the X & Y (X,Y)");
		}
	}
	//This method will randomly distribute land mines in the mine field
	//using the bounds given by the user.
	private static String GenMap(int x, int y, int gen) {
		
		String STgen=x+" "+y+"\n";
		
		for(int Col=0;Col<y;Col++) {
			for(int Row=0;Row<x;Row++) {
				
				if(((int)(Math.random()*100)<gen))
				
					STgen=STgen+'*';
				else
					
					STgen=STgen+'.';
			}
			STgen=STgen+"\n";
		}
		return STgen;
	}
}
