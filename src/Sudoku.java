import java.util.Arrays;
import java.util.Scanner;

public class Sudoku implements sudokuSolver {
    static int [][] board = new int[9][9];
    static int size = 9;


    @Override
    /** gets user input to set up initial sudoku board
     * @returns false if user does not input anything
     * @returns true if user fills board with at least 1 value
     */
    public boolean enterBoard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please fill out the sudoku board printed below starting from the top left box to the bottom right box");
        System.out.println("\t\t\t\t\t\t--use 0's to mark an empty box--");
        for (int [] row : board){
            System.out.println(Arrays.toString(row)); //blank board
            }
        for(int i = 0; i< size; i++){
            for(int j = 0; j < size; j++){
                System.out.println("Please enter a number from 0-9:  ");
                board[i][j] = sc.nextInt();  // loop through board one by one and ask for input from user and update board as you iterate
                for (int [] row : board){
                    System.out.println(Arrays.toString(row)); //filled board
                }
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks to see if the number we wish to place is already in that row
     * @param row
     * @param num
     * @return true if row is clear and ready to go
     */
    @Override
    public boolean checkRow(int row, int num) {
        for(int i = 0; i < size; i++){
            if(board[row][i] == num){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks to see if the number we wish to place is already in that column
     * @param col
     * @param num
     * @return true if the col is clear and ready to go
     */
    @Override
    public boolean checkCol(int col, int num) {
        for(int j = 0; j < size; j++){
            if(board[j][col] == num){
                return false;
            }
        }
        return true;
    }

    /**
     * Function that checks 3x3 grid for duplicate numbers
     * @param row
     * @param col
     * @param num
     * @return boolean indicating if box has duplicate numbers or not
     */
    @Override
    public boolean checkBox(int row, int col, int num) {
        // making sure we always start in top left corner of grids regardless of row or column position by resetting the row and col
        if(row >= 0 && row <= 2){
            row = 0;
        } else if(row >= 3 && row <= 5){
            row = 3;
        } else{
            row = 6;
        }

        if(col >= 0 && col <= 2){
            col = 0;
        } else if(col >= 3 && col <= 5){
            col = 3;
        } else{
            col = 6;
        }

        for (int i = row; i < row +3; i++) {
           for(int j = col; j < col+3;j++){
               if(board[i][j] == num){
                   return false;
               }
           }
        }
        return true;
    }


    /**
     * Function that loops through board, finds empty spots and tries numbers until it works
     * @return boolean indicating if function could solve the board or not
     */
    @Override
    public boolean solveBoard() {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        //checking to see if there's still empty spots and reassigning them to row & col variables for future manipulation
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == 0){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                } //break out of nested loop
            } if(!isEmpty){
                break;
            } //below line executes when none of the spots are empty
        } if(isEmpty){
            return true;
        }
        for(int num = 1; num <= size; num++){
            if(checkRow(row, num) && checkCol(col, num) && checkBox(row,col, num)){
                board[row][col] = num;
                if(solveBoard()){
                    return true;
                } else{
                    //reset it to equal 0 so it gets caught in the first loop again
                    board[row][col] = 0;
                }
                }
            }
        return false;
        }


    /**
     * looping through each row of the board and printing
     */
    @Override
    public void printBoard() {
        System.out.println("\t--Solved Sudoku Board--");
        for(int [] row : board){
                System.out.println(Arrays.toString(row));
        }
    }


    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.enterBoard();
        if(sudoku.solveBoard()){
            sudoku.printBoard();
        }else {
            System.out.println("No solution");
        }
    }
}
