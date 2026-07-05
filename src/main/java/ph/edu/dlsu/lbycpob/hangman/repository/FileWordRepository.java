package ph.edu.dlsu.lbycpob.hangman.repository;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileWordRepository implements WordRepository{
    private Random random;

    public FileWordRepository(Random random) {
        List<String> words = new ArrayList<>();
        // try-with-resources: the BufferedReader is closed automatically
        // when this block ends, even if readLine() throws.
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();
                if (!trimmed.isEmpty()) {
                    words.add(trimmed.toUpperCase());
                }
            }
        }
    }

    @Override
    public String getRandomWord(String randomWord) {
        return "";
    }
}
