package ph.edu.dlsu.lbycpob.hangman.game;
/**
 * The required public contract for a Hangman game session. Method names,
 * parameters, and return types should match the assignment specification exactly.
 */
public interface HangmanGame {
    /** Runs the full program: intro, one or more games, then final statistics. */
    void run();
    /** Prints the introductory banner explaining the rules to the player. */
    void intro();
    /**
     * Plays one complete round of Hangman against {@code secretWord}.
     * @param secretWord the word to guess; must contain only letters A-Z
     * @return the number of guesses remaining when the game ended, or
     *         {@code 0} if the player lost
     */
    int playOneGame(String secretWord);
    /**
     * Displays the hangman drawing that corresponds to {@code guessCount}
     * guesses remaining (0 = fully drawn / game lost, 8 = empty gallows).
     */
    void displayHangman(int guessCount);
    /**
     * Builds the player-visible hint string: revealed letters in their
     * correct positions, {@code '-'} everywhere else.
     */
    String createHint(String secretWord, String guessedLetters);
    /**
     * Prompts the player until they supply a single, not-yet-guessed
     * letter A-Z, then returns it (upper-cased).
     */
    char readGuess(String guessedLetters);
    /** Selects and returns a random upper-cased word from {@code filename}. */
    String getRandomWord(String filename);
    /** Prints the final summary statistics for the session. */
    void stats(int gamesCount, int gamesWon, int best);
}
