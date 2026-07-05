package ph.edu.dlsu.lbycpob.hangman.render;

public interface HangmanRenderer {
    // [UNDERSTAND] Displays the current structure of the hangman based on the current guess.
    void render(int guessCount);
}
