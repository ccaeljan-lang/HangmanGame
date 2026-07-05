package ph.edu.dlsu.lbycpob.hangman.statistics;
import java.util.Locale;
/**
 * Holds the running statistics for one program session: games played,
 * games won, and the best (highest) number of guesses remaining at the end
 * of any single game.
 *
 * <p>A {@code record} is Java's built-in way to write a simple, immutable
 * data class: all fields are {@code final}, there are no setters, and
 * {@code equals}/{@code hashCode}/{@code toString} are generated
 * automatically. The only way to "change" a {@code GameStatistics} is to
 * make a brand new one with {@link #withGame}; this instance never changes.
 * That immutability is what prevents one part of the program from
 * accidentally corrupting statistics another part is relying on.
 */
public record GameStatistics(int gamesPlayed, int gamesWon, int bestGuessesRemaining) {

}
