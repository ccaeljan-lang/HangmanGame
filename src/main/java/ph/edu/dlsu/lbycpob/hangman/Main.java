package ph.edu.dlsu.lbycpob.hangman;

import ph.edu.dlsu.lbycpob.hangman.game.Hangman;
import ph.edu.dlsu.lbycpob.hangman.render.AsciiArtRenderer;
import ph.edu.dlsu.lbycpob.hangman.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.ClasspathWordRepository;
import ph.edu.dlsu.lbycpob.hangman.repository.WordRepository;
import ph.edu.dlsu.lbycpob.hangman.utils.ClasspathResources;

import java.util.Random;
import java.util.Scanner;

public class Main {
    // [UNDERSTAND] Initialized base file path for hangman art and word text files.
    private static final String GAME_ASSETS_BASE_PATH = "/game-assets";
    public static void main(String[] args) {
        // [UNDERSTAND] Initializes objects.
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // [UNDERSTAND] Initializes objects that uses file paths.
        HangmanRenderer renderer = new AsciiArtRenderer(GAME_ASSETS_BASE_PATH + "/hangman-art/");
        WordRepository repository = new ClasspathWordRepository(GAME_ASSETS_BASE_PATH + "/words/", random);
        // [UNDERSTAND] Initializes constructor for hangman using initialized objects.
        Hangman game = new Hangman(random, scanner, renderer, repository);

        // Runs the game.
        game.run();
    }
}
