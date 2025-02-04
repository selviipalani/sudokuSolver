# sudokuSolver
CS 245- Lab Assignment 1

The time complexity of the sudoku backtracking algorithm is O(n^m)
where n is the number of possibilities for each square in the board
and m is the number of empty squares there are in the board. This
is the case because there are n possibilities for each empty square in the
board but since we are specifically interested in the time complexity
for our partially filled (by user input) 9x9 board and since we can not
predict how many empty squares the user will leave we predict for the worst case
which is when they leave all the squares blank, thus we can simplify the above
expression to be O(n^n^2).

The space complexity is O(n^2) because we are using a 2d array because space complexity
for a 2D array goes as follows O(m * n) where m  is the number of rows and n is the number
of columns and in this case, we are creating a sudoku board which means the number of rows
and columns are the same thus we can deduce it to being O(n^2)
