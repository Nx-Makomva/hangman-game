public class GuessChecker {

    private final String selectedWord;
    private final String userGuess;

    public GuessChecker (String selectedWord, String userGuess) {
        this.userGuess = userGuess;
        this.selectedWord = selectedWord;
    }

    public boolean checkGuess() {

        for (int i = 0; i < selectedWord.length(); i++) {
            char selectedChar = selectedWord.charAt(i);
            if (userGuess.contains(String.valueOf(selectedChar))) {
                return true;
            }
        }
        return false;
    }
}
