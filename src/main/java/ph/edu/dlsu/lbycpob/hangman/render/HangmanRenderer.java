package ph.edu.dlsu.lbycpob.hangman.render;

import ph.edu.dlsu.lbycpob.hangman.game.Hangman;
import java.io.IOException;
/**
 * Something that can draw the hangman picture for a given number of
 * guesses remaining. Kept separate from {@link Hangman} so the drawing
 * style (plain text today; maybe a graphical window someday) can change
 * independently of the game rules - Single Responsibility and Open/Closed.
 */
public interface HangmanRenderer {
    /**
     * Draws the hangman art for {@code guessesRemaining} (0-8).
     *
     * @throws IOException if the art cannot be located or read
     */
    // [UNDERSTAND] Displays the current structure of the hangman based on the current guess.
    // Reading a text file can throw an IOException, so the interface must declare it
    void render(int guessesCount) throws IOException;
}
