package Minesweeper;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        String playAgain;
        
        do {
            Board board = new Board();
            System.out.println("           Minesweeper");

            board.generateGame();
            board.printBoard();

            while (true) {
                board.getCoOrdinates();
                if (board.gameLost) {
                    System.out.println("BOOM! GAME OVER");
                    break;
                } else if (board.hasWon) {
                    System.out.println("YOU WIN!");
                    break;
                }
            }
            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.nextLine();
        } while (playAgain.equalsIgnoreCase("yes"));
        
        System.out.println("Thanks for playing Minesweeper!");
    }
}
