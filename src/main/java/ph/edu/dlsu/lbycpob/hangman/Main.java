package ph.edu.dlsu.lbycpob.hangman;

import ph.edu.dlsu.lbycpob.hangman.game.Hangman;
import ph.edu.dlsu.lbycpob.hangman.render.AsciiArtRenderer;
import ph.edu.dlsu.lbycpob.hangman.render.HangmanRenderer;
import ph.edu.dlsu.lbycpob.hangman.repository.ClasspathWordRepository;
import ph.edu.dlsu.lbycpob.hangman.repository.WordRepository;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final String GAME_ASSETS_BASE_PATH = "/game-assets";
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        HangmanRenderer renderer = new AsciiArtRenderer(GAME_ASSETS_BASE_PATH + "/hangman-art");
        WordRepository repository = new ClasspathWordRepository(GAME_ASSETS_BASE_PATH, random);
        Hangman game = new Hangman(random, scanner, renderer, repository);

        game.run();
    }
}
