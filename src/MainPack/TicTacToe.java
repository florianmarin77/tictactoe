package MainPack;

public class TicTacToe {

    private char[][] board; // matricea tablei de joc (contine caractere)
    private char currentPlayerMark; // semnul jucatorului curent (X sau O)

    // constructorul clasei
    public TicTacToe() {
        board = new char[3][3]; // construieste tabla
        currentPlayerMark = 'X'; // primul jucator este X
        initializeBoard(); //initializarea tablei de joc
    }

    // asignarea jucatorului curent dupa semnul acestuia
    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    // initializarea tablei de joc (matricea de semne)
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // afisarea tablei de joc (grila indexata)
    public void printBoard() {
        System.out.println("---1---2---3---"); //prima linie este implicit indexata
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + "| "); // tabulatorii externi sunt indexati
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " |"); // afisarea semnelor din matrice
                if (j == 2) {
                    System.out.print(i + 1); // pe ultimul tabulator avem indexul liniei
                } else {
                    System.out.print(" "); // tabulatorii interni nu sunt indexati
                }
            }
            if (i == 2) {
                System.out.println();
                System.out.println("---1---2---3---"); // ultima linie este implicit indexata
            } else {
                System.out.println();
                System.out.println("---------------"); // liniile interne nu sunt indexate
            }
        }
    }

    // verificarea tablei (daca este goala sau este plina)
    public boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }

    // verificam daca avem castigator prin verificarea semnelor (linii + coloane + diagonale)
    public boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    // verificarea liniilor
    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    // verificarea coloanelor
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    // verificarea diagonalelor
    private boolean checkDiagonalsForWin() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2])) || (checkRowCol(board[0][2], board[1][1], board[2][0])));
    }

    // verificarea daca sunt trei semne identice
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
    }

    // schimbarea jucatorilor prin schimbarea semnelor
    public void changePlayer() {
        if (currentPlayerMark == 'X') {
            currentPlayerMark = 'O';
        } else {
            currentPlayerMark = 'X';
        }
    }

    // introducerea semnelor doar daca se respecta limitele tablei
    public boolean placeMark(int row, int col) {
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayerMark;
                    return true;
                }
            }
        }
        return false;
    }
}