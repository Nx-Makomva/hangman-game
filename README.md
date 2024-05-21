# Hangman

This project is a console-based Hangman game implemented in Java. Players attempt to guess a randomly selected word by suggesting letters within a limited number of guesses.

## Features

- Random word selection from a predefined list
- User input for guessing letters
- Visual representation of the hangman state
- Lives counter to track remaining guesses
- Option to play again after Game Over

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed on your machine (version 8 or higher)
- A terminal or command prompt to run the Java application

## Project Structure

The project is organized into several packages:

- `PlayGame`: Contains the main game logic and flow control.
- `WordBank`: Handles word selection from a predefined list of words.
- `User`: Manages user input and guesses.
- `CommandRunner`: Facilitates replay options and user commands.

### Key Classes

- `PlayGame`: Manages the game state, including lives and game loop.
- `WordBank`: Provides a method to select a random word from the list.
- `User`: Handles user input and stores guesses.
- `GuessChecker`: Checks if the user's guess is correct.
- `Results`: Manages and displays the game results and hangman state.
- `CommandRunner`: Offers the option to play again or quit.

## How to Play

1. The game randomly selects a word.
2. You are prompted to guess a letter.
3. If the guess is correct, the letter is revealed in the word.
4. If the guess is incorrect, you lose a life and a part of the hangman is drawn.
5. The game continues until you either guess the word correctly or run out of lives.
6. After the game ends, you have the option to play again or quit.


## Example
The word you are guessing has 5 characters. You have 7 lives. May the odds be ever in your favour.
Please enter a letter:


``` java
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
```

### How correct guesses are filtered through and displayed in the terminal
``` java
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
```
Output:
`` Please enter a letter
o
CORRECT!

word is _oo_

Your guesses: h, b, a, e, i, o
Lives remaining: 2
``
