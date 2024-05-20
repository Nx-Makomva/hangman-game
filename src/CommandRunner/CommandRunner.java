package CommandRunner;

import PlayGame.PlayGame;

import java.util.Scanner;

public class CommandRunner {

    private final Scanner SCANNER = new Scanner(System.in);
    String input;

    public void playAgain() {
        System.out.println("Would you like to Play Again?");
        System.out.println("1: Play Again");
        System.out.println("2: Quit");
        input = SCANNER.nextLine().trim();
        System.out.println();
        System.out.println();

        if (input.matches("[1-2]")) {
            if (input.equals("1")) {
                PlayGame.resetGame();
                PlayGame.setPlayGame();
                PlayGame.main(null);
            } else if (input.equals("2")) {
                System.out.println("Thanks for playing! See you next time :D");
                PlayGame.setEndGame();
            }
        } else {
            System.out.println("Invalid input. Please enter either number 1 or number 2.");
            playAgain();
        }
    }
}

