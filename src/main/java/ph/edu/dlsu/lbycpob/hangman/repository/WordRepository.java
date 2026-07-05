package ph.edu.dlsu.lbycpob.hangman.repository;

public interface WordRepository {
    // [UNDERSTAND] Gets random word from the text file.
    String getRandomWord(String randomWord);
}
