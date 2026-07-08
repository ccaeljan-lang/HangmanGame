package ph.edu.dlsu.lbycpob.hangman.repository;

import java.io.IOException;

public interface WordRepository {
    // [UNDERSTAND] Gets random word from the text file.
    // Reading from a file so it needs IOException.
    String getRandomWord(String randomWord) throws IOException;
}
