package ph.edu.dlsu.lbycpob.hangman.render;

import ph.edu.dlsu.lbycpob.hangman.utils.ClasspathResources;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class AsciiArtRenderer implements HangmanRenderer{
    // [UNDERSTAND] Initializes constants and starter path of text files.
    private static final int MIN_GUESSES_REMAINING = 0;
    private static final int MAX_GUESSES_REMAINING = 8;
    private String resourceBasePath;

    // [UNDERSTAND] Constructor for the ASCII Art.
    // Has a validity checker to check if a path entered is null.
    public AsciiArtRenderer(String resourceBasePath) {
        Objects.requireNonNull(resourceBasePath, "resourceBasePath must not be null");
        if (resourceBasePath.isBlank()) {
            throw new IllegalArgumentException("resourceBasePath must not be blank");
        }
        this.resourceBasePath = resourceBasePath.endsWith("/")? resourceBasePath.substring(0, resourceBasePath.length() - 1)
                : resourceBasePath;}

    // [DECISION] Implements HangmanRender interface so overridden its abstract method.
    // [UNDERSTAND] To display the right ASCII art, validates if guess count is still within the range.
    // Finally, displays the ASCII art in the text line per line.
    @Override
    public void render(int guessesRemaining) throws IOException {
        if (guessesRemaining < MIN_GUESSES_REMAINING || guessesRemaining > MAX_GUESSES_REMAINING) {
            throw new IllegalArgumentException(
                    "guessesRemaining must be between " + MIN_GUESSES_REMAINING
                            + " and " + MAX_GUESSES_REMAINING + ", got " + guessesRemaining);
        }

        String resourcePath = resourceBasePath + "/display" + guessesRemaining + ".txt";
        List<String> lines = ClasspathResources.readLines(resourcePath);
        for (String line : lines) {
            IO.println(line);
        }
    }
}
