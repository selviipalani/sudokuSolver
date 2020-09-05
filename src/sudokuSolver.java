public interface sudokuSolver {

    boolean enterBoard();

    boolean solveBoard();

    boolean checkRow(int row, int num);

    boolean checkCol(int col, int num);

    boolean checkBox(int row, int col, int num);

    void printBoard();
}
