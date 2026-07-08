package ph.edu.dlsu.lbycpob.hangman.render;

import java.io.IOException;

public interface HangmanRenderer {
    // [UNDERSTAND] Displays the current structure of the hangman based on the current guess.
    // Reading a text file can throw an IOException, so the interface must declare it
    void render(int guessCount) throws IOException;
}
