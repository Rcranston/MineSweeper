

//	@author Ryan Cranston
//	@tag CSCD350 Minesweeper generator
//	@Team3

import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MinefieldGenerator {
	
	public static void main(String[] args) throws IOException {

		int x, y, gen;
		String out="";
		Scanner in = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Please Enter the size of the generated minefield you would like in the (X,Y,Generation Amount 0-100%)");
			x=in.nextInt();
			y=in.nextInt();
			
			// Ending Protocol
			if(x==0&&y==0){	
				try {
				in.nextLine();
				System.out.print("Full path for output file> ");
				String url = in.nextLine();
						//url="C:\\Users\\Ryanc\\eclipse-workspace\\CSCD350Minefeild\\src";// Remove Before Flight
				url=url+"\\OutputMine.txt";
				in.close();
				Path path = Paths.get(url);
				
				out=out+"0 0";
				
				Files.writeString(path,out);
				System.out.println("Minefield Gen Successfull at>"+path);
				return;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			gen=in.nextInt();
			out=out+genMap(x,y,gen);
			
			System.out.println("To end generation please enter 0 for the X & Y (X,Y)");
		}
	}

	private static String genMap(int x, int y, int gen) {
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
