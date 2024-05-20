package PlayGame;

import User.User;
import WordBank.WordBank;

import java.util.List;

public abstract class PlayGame {

    static boolean playGame;
    static int gameLives = 7;

    public static void setPlayGame() {
        playGame = true;
    }

    public static void setEndGame() {
        playGame = false;
    }

    public static int getGameLives() {
        return gameLives;
    }

    public static void setRemoveGameLives() {
        gameLives -= 1;
    }

    public static void resetGame() {
        gameLives = 7;
    }

    public static void main(String[] args) {
        WordBank newWord = new WordBank();
        User currentPlayer = new User();

        String selectedWord = newWord.selectWord();
        Results resultsChecker = new Results(selectedWord);
        System.out.println("The word you are guessing has "
                + selectedWord.length() + " characters."
                + " You have " + gameLives + " lives."
                + " May the odds be ever in your favour.");

        setPlayGame();
        while (playGame) {

            currentPlayer.makeAGuess(currentPlayer);
            String[] userSavedGuess = currentPlayer.getGuessesMade();

            for (String guess : userSavedGuess) {
                resultsChecker.addUserGuess(guess);
            }

            String userSavedGuessAsString = String.join("", userSavedGuess);

            GuessChecker guessChecker = new GuessChecker(userSavedGuessAsString, selectedWord);
            boolean isGuessCorrect = guessChecker.checkGuess();
            List<String> allGuesses = resultsChecker.getUniqueGuesses();

            if (allGuesses != null) {
                if (allGuesses.contains(userSavedGuessAsString)) {
                    System.out.println("You've already guessed " + userSavedGuessAsString);
                    continue;
                }
            }
                if (isGuessCorrect) {
                    System.out.println("CORRECT!");
                    resultsChecker.userGuessFilter();
                } else {
                    setRemoveGameLives();
                    System.out.println("WRONG!");
                    resultsChecker.drawHangman(gameLives);
                    resultsChecker.userGuessFilter();
                }
            }
        }
    }

