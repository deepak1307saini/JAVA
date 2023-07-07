package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Complexity n^2
//The eight queens puzzle is the problem of placing eight chess queens on an 8×8 chessboard so that no two queens threaten each other
public class QueensChessBoard {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int n=sc.nextInt();

        List<List<String>> allBoards= solveNQueen(n);

        printSolution(allBoards);
    }

    private static void printSolution(List<List<String>> allBoards) {
        for (int i = 0; i < allBoards.size(); i++) {
            for (int j = 0; j < allBoards.get(i).size(); j++) {
                System.out.print(allBoards.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    private static List<List<String>> solveNQueen(int n) {
        List<List<String>> allBoards=new ArrayList<>();
        char[][] board=new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }
        
        helper(0,board,allBoards);
        return allBoards;
    }

    private static void helper(int row, char[][] board, List<List<String>> allBoards) {
        if (board.length==row){
            saveBoard(board,allBoards);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if(isSafe(row,col,board)){
                board[row][col]='Q';
                helper(row+1,board,allBoards);
                board[row][col]='.';
            }
        }
    }

    private static void saveBoard(char[][] board, List<List<String>> allBoards) {
        List<String> b = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            b.add(new String(board[i]));
        }

        allBoards.add(b);
    }

    private static boolean isSafe(int row, int col, char[][] board) {
        int size=board.length;
        //horizontal
        for (int i = 0; i < size; i++) {
            if (board[row][i]=='Q') return false;
        }

        //Vertical
        for (int i = 0; i < size; i++) {
            if (board[i][col]=='Q') return false;
        }

        //Upper Left
        for (int c=col,r=row; c>=0 && r>=0 ;c--,r--){
            if (board[r][c]=='Q') return false;
        }

        //upper right
        for (int c=col,r=row; c<size && r>=0 ;c++,r--){
            if (board[r][c]=='Q') return false;
        }

        //Lower Left
        for (int c=col,r=row; c>=0 && r< size ;c--,r++){
            if (board[r][c]=='Q') return false;
        }

        //Lower Right
        for (int c=col,r=row; c< size&& r< size ;c++,r++){
            if (board[r][c]=='Q') return false;
        }

        return true;
    }
}
