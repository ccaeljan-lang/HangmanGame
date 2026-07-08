package ph.edu.dlsu.lbycpob.hangman.game;

import ph.edu.dlsu.lbycpob.hangman.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.WordRepository;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Hangman implements HangmanGame{
    private Random random;
    private HangmanRenderer renderer;
    private Scanner scanner;
    private static final String LETTER_ONLY_PATTERN = "[A-Z]";
    private static final String[] DEFAULT_WORDS = {"PROGRAMMER", "JAVA", "HANGMAN", "COMPUTER", "KEYBOARD", "PROGRAM", "ALGORITHM"};
    public static final int MAX_GUESSES = 8;
    private WordRepository wordRepository;

    // CREATE HINT METHOD
    @Override
    public String createHint(String secretWord, String guessedLetters) {
        // Initialize string builder.
        StringBuilder hint = new StringBuilder();

        // [UNDERSTAND] goes through each secret word letters.
        // checks if letter is in the guessed letter,
        // if it is then appends with "-" otherwise the actual letter.
        // RESULT: replaces the hint variable with the appended characters.
        for (int i = 0; i < secretWord.length(); i++) {
            char letter = secretWord.charAt(i);
            if (guessedLetters.indexOf(letter) >= 0) {
                hint.append(letter);
            }
            else {
                hint.append("-");
            }
        }
        // [UNDERSTAND] Returns the hint word.
        return hint.toString();
    }

    @Override
    public void stats(int gamesCount, int gamesWon, int best) {

    }

    @Override
    public void run() {
        playOneGame("PROGRAMMER");
    }

    // OPTIONAL METHOD
    private boolean readYesNo(String guessedLetters) {
        return true;
    }

    // INTRO DISPLAY METHOD
    @Override
    public void intro() {
        IO.println("               @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
                   "                      Welcome to Hangman!\n" +
                   "I will think of a random word while you try to guess its letters.\n" +
                   "      Every time you guess a letter that isn't in my word,\n" +
                   "          a new body part of the hanging man appears.\n" +
                   "                         Good luck!!!\n" +
                   "               @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
    }

    // READ GUESS METHOD
    @Override
    public char readGuess(String guessedLetters) {
        // [DECISION] Used a while loop to repeat process of inputting character guesses.
        // [UNDERSTAND] Inside it, asks user to input their guesses.
        // Checks if guesses are a single letter or if you have already guessed it.
        // Returns the character guess to "append" it or add it to the guesses list.
        while (true) {
            IO.readln("Your guess? ");
            String getCharacter = scanner.nextLine().trim().toUpperCase();

            if (getCharacter.length() != 1 || getCharacter.matches(LETTER_ONLY_PATTERN)) {
                IO.println("Type a single letter from A-Z.");
                continue;
            }

            char guess = getCharacter.charAt(0);

            if (guessedLetters.indexOf(guess) != -1) {
                IO.println("You already guessed that letter.");
                continue;
            }
            return guess;
        }
    }

    // PLAY GAME METHOD
    @Override
    public int playOneGame(String secretWord) {
        // [UNDERSTAND] Initializes the number of guesses and guessed letters.
        int guessesLeft = MAX_GUESSES;
        String guessedLetters = "";

        // [UNDERSTAND] While loop that repeats process
        // until guesses becomes zero or until guessed correctly
        while (guessesLeft > 0 && !createHint(secretWord, guessedLetters).equals(secretWord)) {
            displayHangman(guessesLeft);
            IO.println("Secret word: " + createHint(secretWord, guessedLetters));
            IO.println("Your guesses: " + guessedLetters);
            IO.println("Guesses left: " + guessesLeft);

            // [UNDERSTAND] Guess letters are appended on the guessed letters list if new.
            char guess = readGuess(guessedLetters);
            guessedLetters += guess;

            // [UNDERSTAND] Checks if guess letter is in the secret word.
            if (secretWord.indexOf(guess) >= 0) {
                System.out.println("Correct!");
            }
            else {
                System.out.println("Incorrect.");
                guessesLeft--;
            }

            // Reduces guess number.
            guessesLeft--;
        }

        // [UNDERSTAND] Displays output depending if hint is already equal to the secret word (if correct).
        if (createHint(secretWord, guessedLetters).equals(secretWord)) {
            System.out.println("You win! My word was \"" + secretWord + "\".");
        }
        else {
            System.out.println("You lose! My word was \"" + secretWord + "\".");
        }

        // Returns number of guesses.
        return guessesLeft;
    }

    // GET RANDOM WORD METHOD
    @Override
    public String getRandomWord(String filename) {
        // [UNDERSTAND] Checks if no filename is passed.
        Objects.requireNonNull(filename, "filename must not be null");
        if (filename.isBlank()) {
            throw new IllegalArgumentException("filename must not be blank");
        }

        // [UNDERSTAND] Gets random word from a file,
        // and if not uses the default words initialized.
        try {
            return wordRepository.getRandomWord(filename);
        } catch (IOException e) {
            // Recovery: a missing/empty/unreadable word file should not
            // crash the whole program. Tell the player clearly (using the
            // exception's own message - no custom exception type needed),
            // then fall back to a small built-in word list.
            IO.println("Could not load words from \"" + filename + "\": " + e.getMessage());
            IO.println("Using a built-in default word instead.");
            return DEFAULT_WORDS[random.nextInt(DEFAULT_WORDS.length)];
        }
    }

    // DISPLAY HANGMAN ASCII ART METHOD
    @Override
    public void displayHangman(int guessCount) {
        // [UNDERSTAND] Checks if the guess count is within the valid range.
        // Throws an exception if the guess count is invalid.
        if (guessCount < 0 || guessCount > MAX_GUESSES) {
            throw new IllegalArgumentException(
                    "guessCount must be between 0 and " + MAX_GUESSES + ", got " + guessCount);
        }

        // [UNDERSTAND] Ensures the guess count is still valid after checking.
        assert guessCount >= 0 && guessCount <= MAX_GUESSES
                : "guessCount out of range after validation - this is a bug";

        try {
            // [UNDERSTAND] Calls the renderer to display the corresponding
            // Hangman ASCII art based on the current guess count.
            renderer.render(guessCount);
        } catch (IOException e) {
            // [UNDERSTAND] Catches any error while reading the ASCII art file.
            throw new RuntimeException("Could not display the hangman picture.", e);
        }
    }
}
