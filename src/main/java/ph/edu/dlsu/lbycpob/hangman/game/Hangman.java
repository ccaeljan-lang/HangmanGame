package ph.edu.dlsu.lbycpob.hangman.game;

import ph.edu.dlsu.lbycpob.hangman.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.WordRepository;

import java.util.Random;
import java.util.Scanner;

public class Hangman implements HangmanGame{
    private Random random;
    private HangmanRenderer renderer;
    private Scanner scanner;
    private static final String LETTER_ONLY_PATTERN = "[A-Z]";
    private static final String[] DEFAULT_WORDS = {"PROGRAMMER"};
    public static final int MAX_GUESSES = 8;
    private WordRepository wordRepository;

    public Hangman()

    @Override
    public String createHint(String secretWord, String guessedLetters) {
        // Initialize string builder
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

    // OPTIONAL METHODS
    private boolean readYesNo(String guessedLetters) {
        return true;
    }

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

    @Override
    public char readGuess(String guessedLetters) {
        // [DECISION] Used a while loop to repeat process of inputting character guesses.
        // [UNDERSTAND] Inside it, asks user to input their guesses.
        // Checks if guesses are a single letter or if you have already guessed it.
        // Returns the character guess to "append" it or add it to the guesses list.
        while (true) {
            IO.readln("Your guess? ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() != 1 || input.matches(LETTER_ONLY_PATTERN)) {
                IO.println("Type a single letter from A-Z.");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.indexOf(guess) != -1) {
                IO.println("You already guessed that letter.");
                continue;
            }
            return guess;
        }
    }

    @Override
    public int playOneGame(String secretWord) {
        return 0;
    }

    @Override
    public String getRandomWord(String filename) {
        return "";
    }

    @Override
    public void displayHangman(int guessCount) {

    }
}
