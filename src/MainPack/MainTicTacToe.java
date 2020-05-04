package MainPack;

import java.util.Scanner;

public class MainTicTacToe {

    public static final String header = "Tic-Tac-Toe! 0";

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        game.initializeBoard();
        int k = 0;
        do {
            System.out.println(header + k);
            k = k + 1;
            game.printBoard();
            int row;
            int col;
            do {
                System.out.println("Player " + game.getCurrentPlayerMark() + ", please mark your sign into an empty space!");
                System.out.print("Line >>>>>");
                row = keyboard.nextInt() - 1;
                System.out.print("Column >>>");
                col = keyboard.nextInt() - 1;
                System.out.println();
            }
            while (!game.placeMark(row, col));
            game.changePlayer();
        }
        while (!game.checkForWin() && !game.isBoardFull());
        if (game.isBoardFull() && !game.checkForWin()) {
            System.out.println(header + k);
            game.printBoard();
            System.out.println("The game was a tie!");
        } else {
            System.out.println(header + k);
            game.printBoard();
            game.changePlayer();
            System.out.println("Player " + Character.toUpperCase(game.getCurrentPlayerMark()) + " wins!!");
        }
    }
}

