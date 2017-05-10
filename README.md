# Sudoku
### Simple Java Sudoku solver with Swing GUI

#### How to Use:

1. Input the Sudoku puzzle by entering it in on the grid (1st tab) or paste a properly formatted puzzle on the text area (2nd tab).
2. Click solve and the numbers will be calculated and displayed in both tabs.

'.' (period) is a spot with number missing

' ' (space) is used to separate the numbers and periods

#### About the Code:

SudokuGui.java contains the GUI code, while SudokuSolve.java contains the solving code which the SudokuGui.java calls. SamplePuzzles.txt contains 5 sample Sudoku that have been formatted correctly to be used with the program.

The code recursively generates the number to be put in the next spot that is not filled in. It prunes invalid combinations every recursive call and it backtracks when the current combination is not feasible.

#### 5 Sample Sudoku Puzzles:

```
1 2 . 4 . . 3 . .
3 . . . 1 . . 5 .
. . 6 . . . 1 . .
7 . . . 9 . . . .
. 4 . 6 . 3 . . .
. . 3 . . 2 . . .
5 . . . 8 . 7 . .
. . 7 . . . . . 5
. . . . . . . 9 8

1 2 . 3 . . . . .
3 4 . . . . 1 . .
. . 5 . . . . . .
6 . 2 4 . . 5 . .
. . . . 6 . . 7 .
. . . . . 8 . . 6
. . 4 2 . . 3 . .
. . . . 7 . . . 9
. . . . . 9 . 8 .

. . . . . . . 1 2
. . . . . . . . 3
. . 2 3 . . 4 . .
. . 1 8 . . . . 5
. 6 . . 7 . 8 . .
. . . . . 9 . . .
. . 8 5 . . . . .
9 . . . 4 . 5 . .
4 7 . . . 6 . . .

. 2 . . 5 . 7 . .
4 . . 1 . . . . 6
8 . . . . 3 . . .
2 . . . . 8 . . 3
. 4 . . 2 . 5 . .
. . . 6 . . . 1 .
. . 2 . 9 . . . .
. 9 . . . . . . 5
7 . 4 . . . 9 . .

. . . . . . . . 3
. . 1 . . 5 6 . .
. 9 . . 4 . . 7 .
. . . . . 9 . 5 .
7 . . . . . . . 8
. 5 . 4 . 2 . . .
. 8 . . 2 . . 9 .
. . 3 5 . . 1 . .
6 . . . . . . . .
```
