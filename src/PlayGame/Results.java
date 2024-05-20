package PlayGame;

import CommandRunner.CommandRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Results {
    private final String selectedWord;
    private List<String> userAllGuesses = new ArrayList<>();
    private List<String> uniqueGuesses;
    CommandRunner replay = new CommandRunner();

    public List<String> getUniqueGuesses() {
        return uniqueGuesses;
    }

    public Results(String selectedWord) {
        this.selectedWord = selectedWord;
    }

    public void addUserGuess(String userGuess) {
        userAllGuesses.add(userGuess);
    }

    public void displayResults() {
        uniqueGuesses = userAllGuesses.stream().distinct().collect(Collectors.toList());
        System.out.println("So far, you have guessed: " + String.join(", ", uniqueGuesses));
        System.out.println("Lives remaining: " + PlayGame.getGameLives());
        System.out.println();
    }

    public void userGuessFilter() {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < selectedWord.length(); i++) {
            char currentChar = selectedWord.charAt(i);
            if (userAllGuesses.stream().anyMatch(guess -> guess.contains(String.valueOf(currentChar)))) {
                result.append(currentChar);
            } else {
                result.append("_");
            }
        }

        System.out.println();
        System.out.println("word is " + result);
        System.out.println();

        displayResults();
        System.out.println();

        String resultAsString = result.toString();

        if (!resultAsString.contains("_")) {
            System.out.println("YOU WIN! you guessed " + selectedWord + " and escaped a hanging!");
            endGame();
        }
    }

    public void drawHangman(int gameLife) {
        if (gameLife == 7) {
            System.out.println("_______");
        } else if (gameLife == 6) {
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        } else if (gameLife == 5) {
            System.out.println("   _______");
            System.out.println("   |/     |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
            System.out.println();
        } else if (gameLife == 4) {
            System.out.println("   _______");
            System.out.println("   |/     |");
            System.out.println("   |     (_)");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        } else if (gameLife == 3) {
            System.out.println("   _______");
            System.out.println("   |/     |");
            System.out.println("   |     (_)");
            System.out.println("   |     \\|");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        } else if (gameLife == 2) {
            System.out.println("   _______");
            System.out.println("   |/     |");
            System.out.println("   |     (_)");
            System.out.println("   |     \\|/");
            System.out.println("   |      |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        } else if (gameLife == 1) {
            System.out.println("   _______");
            System.out.println("   |/     |");
            System.out.println("   |     (_)");
            System.out.println("   |     \\|/");
            System.out.println("   |      |");
            System.out.println("   |     / \\");
            System.out.println("   |");
            System.out.println("___|___");
        } else {
            System.out.println("   _______");
            System.out.println("   |/     |");
            System.out.println("   |       ");
            System.out.println("   |    ");
            System.out.println("   |      \\|/");
            System.out.println("   |       |");
            System.out.println("   |       |");
            System.out.println("___|___   / \\ (_) ");
            System.out.println();
            System.out.println("GAME OVER! You have been hanged. Unfortunate turn of events");
            System.out.println("The word you needed was: " + selectedWord);
            endGame();
        }
    }


    public void endGame() {
        PlayGame.playGame = false;
        System.out.println();
        replay.playAgain();
    }
}