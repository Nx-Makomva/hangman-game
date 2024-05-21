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

package WordBank;

import java.util.Random;

public class WordBank {
    public String selectWord() {
        String[] wordList = { "building", "ocean", "nic", /* other words */ };
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.length);
        return wordList[randomIndex];
    }
}

