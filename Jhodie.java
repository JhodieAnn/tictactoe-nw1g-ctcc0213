import java.util.Scanner;

class Jhodie {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Get the players name
        System.out.print("Player 1, What's your name? ");
        String p1 = in.nextLine();
        System.out.print("Player 2, What's your name? ");
        String p2 = in.nextLine();

        // 3x3 Board
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        // Keep track of whose turn
        boolean isPlayer1 = true;

        // Kepp track if the game ended
        boolean gameEnded = false;

        while (!gameEnded) {
            // Draw the board
            drawBoard(board);

            // Keep track of what symbol we are using
            char symbol = ' ';
            if (isPlayer1) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }

            // Print out the players turn
            if (isPlayer1) {
                System.out.println(p1 + " 's turn (x): ");
            } else {
                System.out.println(p2 + " 's turn (o): ");
            }

            // row and col variables
            int row = 0;
            int col = 0;

            while (true) {
                // Get players row and col
                System.out.print("Enter a row - 0, 1 or 2:  ");
                row = in.nextInt();
                System.out.print("Enter a col - 0, 1 or 2:  ");
                col = in.nextInt();

                // Checking if the row and col are valid
                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    // row and col are invalid
                    System.out.println(" Your row and col are invalid! ");
                } else if (board[row][col] != '-') {
                    // board position already have an x or o
                    System.out.println(" Someone already made a move there! ");
                } else {
                    // row and col are valid
                    break;
                }
            }

            board[row][col] = symbol;

            // Check if a player has won
            if (hasWon(board) == 'x') {
                // P1 WON
                System.out.println(p1 + " WON! :] ");
                gameEnded = true;
            } else if (hasWon(board) == 'o') {
                // P2 WON
                System.out.println(p2 + " WON! ;} ");
                gameEnded = true;
            } else {
                // NOBODY WON
                if (hasTied(board)) {
                    // TIED
                    System.out.println(" It's a tie :> ");
                    gameEnded = true;
                } else {
                    // TO CONTINUE THE GAME
                    isPlayer1 = !isPlayer1;
                }

            }

        }
        // print out final statement of the board
        drawBoard(board);
    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    // Check if player won
    public static char hasWon(char[][] board) {
        // ROW
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return board[i][0];
            }
        }

        // COL
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return board[0][j];
            }
        }

        // Diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return board[0][0];
        }
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '-') {
            return board[2][0];
        }

        // NOBODY WON
        return '-';
    }

    // Check if the board is full
    public static boolean hasTied(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;

    }
}
