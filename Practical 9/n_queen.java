import java.util.Arrays;
import java.util.Scanner;
public class n_queen{
    static int queen;   // no. of queens
    static int[][] board;
    public static boolean isValid(int row,int col){
        for (int i = 0; i < col; i++)   // checking left column
            if (board[row][i] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)   // checking upper left diagonal
                return false;
        for (int i = row, j = col; j >= 0 && i < queen; i++, j--)
            if (board[i][j] == 1)   // checking lower left diagonal
                return false;
        return true;
    }
    public static boolean solveNQueen(int col){
        if (col >= queen)   // base case: all queens are placed
            return true;
        for (int i = 0; i < queen; i++) {   //place 1 queen in each row
            if (isValid(i, col)) {  // check valid board position
                board[i][col] = 1;  // place queen
                if (solveNQueen(col + 1))
                    return true;    // check next queens
                board[i][col] = 0; // remove queen if no further solution
            }
        }
        return false;   // queen cannot be placed
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number of Queens: ");
        queen = sc.nextInt();
        board = new int[queen][queen];
        for (int i = 0; i < queen; i++)
            Arrays.fill(board[i], 0);
        if(solveNQueen(0)) {
            System.out.println("Solution on board: ");
            for (int i = 0; i < queen; i++) {
                for (int j = 0; j < queen; j++) {
                    if(board[i][j]==0)
                        System.out.print("□ ");
                    else
                        System.out.print("♕ ");
                }
                System.out.println();
            }
        }
        else
            System.out.println("No Solution");
    }
}