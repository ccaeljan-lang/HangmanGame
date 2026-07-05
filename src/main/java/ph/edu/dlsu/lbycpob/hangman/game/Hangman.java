package ph.edu.dlsu.lbycpob.hangman.game;

import java.util.Random;
import java.util.Scanner;

public class Hangman implements HangmanGame{
    Random random;
    HangmanRenderer renderer;
    Scanner scanner;
    String LETTER_ONLY_PATTERN;
    String[] DEFAULT_WORDS;
    int MAX_GUESSES;
    WordRepository wordRepository;

    @Override
    public String createHint(String secretWord, String guessedLetters) {
        return "";
    }

    @Override
    public void stats(int gamesCount, int gamesWon, int best) {

    }

    @Override
    public void run() {

    }

    public boolean readYesNo(String guessedLetters) {
        return true;
    }

    @Override
    public void intro() {

    }

    @Override
    public char readGuess(String guessedLetters) {
        return '\0';
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
