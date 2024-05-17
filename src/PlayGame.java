import java.util.Arrays;

public class PlayGame {

    static boolean playGame = false;
    static int gameLives = 3;

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

    public static void main(String[] args) {
        WordBank newWord = new WordBank();
        User currentPlayer = new User();


        String selectedWord = newWord.selectWord();
        Results resultsChecker = new Results(selectedWord);
        System.out.println("The selected word is " + selectedWord);
        System.out.println("The word you are guessing has " + selectedWord.length() + " characters. Good Luck!");

        setPlayGame();


        while (playGame) {

            currentPlayer.makeAGuess(currentPlayer);

            // wait for input from user //
            String[] userSavedGuess = currentPlayer.getGuessesMade();

            for (String guess : userSavedGuess) {
                resultsChecker.addUserGuess(guess);
            }

            String UserSavedGuessAsString = Arrays.toString(userSavedGuess);
            // wait for UserSavedGuessAsString to not be empty //

            GuessChecker guessChecker = new GuessChecker(UserSavedGuessAsString, selectedWord);
            boolean isGuessCorrect = guessChecker.checkGuess();

            // when correct run the results class and display the _t__e___ fields
            // results class needs to be passed selected word and saved guess to track user progress
            // once user has all correct letters and matches to selected word then playGame turned to false

            if (isGuessCorrect) {
                resultsChecker.correctUserGuess();

            } else {
                if (gameLives == 1) {
                   setEndGame();
                } else {
                    setRemoveGameLives();
                    System.out.println("WRONG!");
                    resultsChecker.displayResults();
                    // if this gets triggered it should call another class that draws the hangman! maybe it can replace
                    // the line right above (resultsChecker.displayResults()).
                }



//                    System.out.println("Nope! Try Againnn");
                    // when incorrect run the results class (diff method) and display the ASCII code or
                    // remove a life
                    // add if check for a counter. each time this loop runs it minuses 1 from a counter.
                    // when counter hits 0 then game is stopped and play game is false.
                }
            }
        }
    }
