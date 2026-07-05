package ph.edu.dlsu.lbycpob.hangman.game;

import ph.edu.dlsu.lbycpob.hangman.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.WordRepository;

import java.util.Random;
import java.util.Scanner;

public class Hangman implements HangmanGame{
    private Random random;
    private HangmanRenderer renderer;
    private Scanner scanner;
    private String LETTER_ONLY_PATTERN;
    private String[] DEFAULT_WORDS;
    public int MAX_GUESSES;
    private WordRepository wordRepository;

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

    // OPTIONAL METHODS
    private boolean readYesNo(String guessedLetters) {
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
