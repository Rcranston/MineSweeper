//Christopher Davisson
//Team 3
//Team Coding
import java.util.*;

public class MinefieldSolver {

    public static void main(String[] args) {

        int RowCount=1, ColumnCount=1;
        String Line;
        Scanner kb = new Scanner(System.in);

        //Handles map input. First two entries are the dimensions.
        //After it expects the map data, one Row at a time
        for(int MapNumber=1;true;MapNumber++){
            RowCount=kb.nextInt();
            ColumnCount=kb.nextInt();

            if(RowCount==0&ColumnCount==0) {
                kb.close();
                return;
            }
            char[][] field=new char[RowCount][ColumnCount];
            for(int col=0;col<ColumnCount;col++) {
                Line=kb.next();
                for(int row=0;row<RowCount;row++) {
                    field[row][col]=Line.charAt(row);
                }
            }
            field=Solver(field,RowCount,ColumnCount);
            System.out.println("Field #"+MapNumber+":");
            Print(field,RowCount,ColumnCount);
        }
    }

    //For Each position it checks for an asterisk, if it's not then it adds a number
    private static char[][] Solver(char[][] MineField,int RowCount, int ColumnCount) {
        for(int Column=0;Column<ColumnCount;Column++) {
            for(int Row=0;Row<RowCount;Row++) {
                MineField[Row][Column] = (MineField[Row][Column]=='*') ? '*' : AddNumber(MineField , Row , Column , RowCount , ColumnCount);
            }
        }
        return MineField;
    }

    //Handles the Numbers and returns it as a char
    private static char AddNumber(char[][] MineField , int Row , int Column , int RowCount , int ColumnCount){
        int SquareValue = 0;
        //Right
        if(Row-1>=0){
            if(MineField[Row-1][Column]=='*')
                SquareValue++;
        }
        //Right-down
        if(Row-1>=0&&Column-1>=0){
            if(MineField[Row-1][Column-1]=='*')
                SquareValue++;
        }
        //Down
        if(Column-1>=0){
            if(MineField[Row][Column-1]=='*')
                SquareValue++;
        }
        //Left-down
        if(Row+1<=RowCount-1&&Column-1>=0){
            if(MineField[Row+1][Column-1]=='*')
                SquareValue++;
        }
        //Left
        if(Row+1<=RowCount-1){
            if(MineField[Row+1][Column]=='*')
                SquareValue++;
        }
        //Left-up
        if(Row+1<=RowCount-1&&Column+1<=ColumnCount-1){
            if(MineField[Row+1][Column+1]=='*')
                SquareValue++;
        }
        //Up
        if(Column+1<=ColumnCount-1){
            if(MineField[Row][Column+1]=='*')
                SquareValue++;
        }
        //Right-up
        if(Row-1>=0&&Column+1<=ColumnCount-1){
            if(MineField[Row-1][Column+1]=='*')
                SquareValue++;
        }
        return ((char)(SquareValue+'0'));
    }

    private static void Print(char[][] MineField, int RowCount, int ColumnCount)
    {
        for(int Column=0;Column<ColumnCount;Column++) {
            for(int Row=0;Row<RowCount;Row++) {
                System.out.print(MineField[Row][Column]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
