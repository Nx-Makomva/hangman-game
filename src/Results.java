import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Results {
    //  when correct run the results class and display the _t__e___ fields
    //  results class needs to be passed selected word and saved guess to track user progress
    //  once user has all correct letters and matches to selected word then playGame turned to false

    private final String selectedWord;
    private List<String> userAllGuesses = new ArrayList<>();
    private List<String> correctGuesses = new ArrayList<>();



    public Results(String selectedWord) {
        this.selectedWord = selectedWord;
    }

    public void addUserGuess(String userGuess) {
        userAllGuesses.add(userGuess);
    }

    public void correctUserGuess() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < selectedWord.length(); i++) {
            char currentChar = selectedWord.charAt(i);
            if (userAllGuesses.stream().anyMatch(guess -> guess.contains(String.valueOf(currentChar)))) {
                if (!correctGuesses.contains(String.valueOf(currentChar))) {
                    correctGuesses.add(String.valueOf(currentChar));
                }
                result.append(currentChar);
                System.out.println();
                System.out.println("CORRECT!");
            } else {
                result.append("_");
            }
        }

        System.out.println("word is " + result);
        System.out.println();

        displayResults();
        System.out.println();

        String resultAsString = result.toString();

//        int gameLives = PlayGame.gameLives;
//        if (gameLives == 0) {
//            System.out.println("I was triggered");
//            endGame();
//        }

        if (!resultAsString.contains("_")) {
            System.out.println("HOORAYYY! you guessed " + selectedWord + " on time!");
            endGame();
        }
    }

    public void displayResults() {
//
//        if (correctGuesses.contains(selectedWord)) {
//            System.out.println("Whoop! Congrats on guessing " + selectedWord + " on time.");
//        }
//
//        System.out.println("correct guesses is " + correctGuesses);
//
        List<String> uniqueGuesses = userAllGuesses.stream().distinct().collect(Collectors.toList());
        System.out.println("So far, you have guessed: " + String.join(", ", uniqueGuesses));
        System.out.println("Lives remaining: " + PlayGame.getGameLives());
        System.out.println();
    }

    public void endGame() {
        System.out.println("Thanks for playing! See you next time :D");
        PlayGame.setEndGame();
    }
}











    //  System.out.println("i was triggered");
//        String combinedWord = String.join("", correctGuesses);
//
//        char[] selectedWordArray = selectedWord.toCharArray();
//        char[] combinedWordArray = combinedWord.toCharArray();
//
//        Arrays.sort(selectedWordArray);
//        Arrays.sort(combinedWordArray);
//        System.out.println("selected word array: " + Arrays.toString(selectedWordArray));
//        System.out.println("combined word array " + Arrays.toString(combinedWordArray));
//
//        boolean haveSameLetters = Arrays.equals(selectedWordArray, combinedWordArray);
//