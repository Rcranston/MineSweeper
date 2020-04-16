import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        int rowCount , colCount , minePercent;
        char[][] mineField;
        PrintStream output = new PrintStream(new File("mines.txt"));

        System.out.print("Row #: ");
        rowCount = numInput(kb);
        System.out.print("Coloum #: ");
        colCount = numInput(kb);
        System.out.print("Percent of mines (0 - 100): ");
        minePercent = numInput(kb);

        while(rowCount > 0 && colCount > 0) {
            mineField = new char[rowCount][colCount];

            output.println(rowCount + "  " + colCount);
            for (int row = 0; row < rowCount; row++){
                for(int col = 0; col < colCount; col++){
                    char ch;
                    if((int)(Math.random() * 100) < minePercent){
                        mineField[row][col] = '*';
                    }
                    else{
                        mineField[row][col] = '.';
                    }
                }
            }
            print(mineField , rowCount , colCount);
            printToFile(mineField , rowCount , colCount , output);
            System.out.print("Row #: ");
            rowCount = kb.nextInt();
            System.out.print("Coloum #: ");
            colCount = kb.nextInt();
            System.out.print("Percent of mines (0 - 100): ");
            minePercent = kb.nextInt();
        }
        output.close();
    }
    public static void print(char[][] arg , int row , int col){
        for(int i = 0; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                System.out.print(arg[i][j]);
            }
            System.out.println();
        }
    }
    public static void printToFile(char[][] arg , int row , int col , PrintStream output){
        for(int i = 0; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                output.print(arg[i][j]);
            }
            output.println();
        }
    }
    //no upper bounds, 0 is lower bounds
    public static int numInput(Scanner kb){
        int res = -1;
        String holder;
        while(res < 0){
            holder = kb.nextLine();
            try{
                res = Integer.parseInt(holder);
            }catch (Exception e){
                System.out.println("Invalid");
            }

            if(res < 0)
                System.out.println("Invalid");
        }
        return res;
    } // end numInput
}
