package ph.edu.dlsu.lbycpob.hangman.render;

import java.util.Objects;

public class AsciiArtRenderer implements HangmanRenderer{
    private int MIN_GUESSES_REMAINING;
    private int MAX_GUESSES_REMAINING;
    private String resourceBasePath;

    public AsciiArtRenderer(String resourceBasePath) {
        Objects.requireNonNull(resourceBasePath, "resourceBasePath must not be null");
        if (resourceBasePath.isBlank()) {
            throw new IllegalArgumentException("resourceBasePath must not be blank");
        }
        this.resourceBasePath = resourceBasePath.endsWith("/")? resourceBasePath.substring(0, resourceBasePath.length() - 1)
                : resourceBasePath;}

    @Override
    public void render(int guessCount) {

    }
}
