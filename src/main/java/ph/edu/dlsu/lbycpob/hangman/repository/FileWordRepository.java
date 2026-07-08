package ph.edu.dlsu.lbycpob.hangman.repository;

import ph.edu.dlsu.lbycpob.hangman.game.Hangman;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
/**
 * Reads one word per non-blank line from a real file on the user's
 * filesystem and picks one at random.
 * <p>Uses {@code java.nio.file.Path}/{@code Files} (the modern, recommended
 * way to do file I/O in Java) instead of the older {@code java.io.File}
 * class, and reads the file inside a try-with-resources block so the
 * {@link BufferedReader} is always closed automatically, even if something
 * goes wrong while reading.
 */
public class FileWordRepository implements WordRepository{
    private final Random random;

    public FileWordRepository(Random random) {
        this.random = Objects.requireNonNull(random, "random must not be null");
    }

    @Override
    public String getRandomWord(String randomWord) {
        return "";
    }
}
