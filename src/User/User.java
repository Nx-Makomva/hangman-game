package User;

import java.util.Scanner;

public class User {

    public String[] guessesMade;

    public void setGuessesMade(String[] letterGuess) {
        this.guessesMade = letterGuess;
    }

    public String[] getGuessesMade() {
        return guessesMade;
    }

    public void makeAGuess(User user) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String[] guess;

        do {
            System.out.println("Please enter a letter");
            input = scanner.nextLine().trim();

            if (input.matches("[a-zA-Z]") && !input.matches("\\d")) {
                guess = new String[]{input.toLowerCase()};
                user.setGuessesMade(guess);
                break;

            } else {
                System.out.println("Invalid input. Please enter only one letter with no numbers.");
            }

        } while (true);
    }
}
