import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import progquestion2.ProgQuestion2;

public class Question2Test {

        private ProgQuestion2 game;
    private ProgQuestion2.GameStatistics stats;

    @Before
    public void setUp() {
        game = new ProgQuestion2();
        stats = game.new GameStatistics(); // Correct way to instantiate the inner class
    }

    @Test
    public void testChooseDifficultyEasy() {
        String input = "1\n"; // Simulate choosing "Easy" level
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        game.chooseDifficulty(scanner);

        assertEquals(10, game.range);
        assertEquals(5, game.maxAttempts);
    }

    @Test
    public void testChooseDifficultyMedium() {
        String input = "2\n"; // Simulate choosing "Medium" level
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        game.chooseDifficulty(scanner);

        assertEquals(50, game.range);
        assertEquals(7, game.maxAttempts);
    }

    @Test
    public void testChooseDifficultyHard() {
        String input = "3\n"; // Simulate choosing "Hard" level
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        game.chooseDifficulty(scanner);

        assertEquals(100, game.range);
        assertEquals(9, game.maxAttempts);
    }

    @Test
    public void testRandomNumberWithinRange() {
        game.range = 10;
        game.RandomNumber();
        assertTrue(game.randomNumber >= 1 && game.randomNumber <= 10);
    }

    @Test
    public void testPlayGameWinScenario() {
        game.range = 10;
        game.maxAttempts = 5;
        game.randomNumber = 5; // Pretend the correct number is 5
        String input = "5\n"; // Simulate correct guess on first try
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        
        game.playGame(scanner, stats);
        
        assertEquals(1, stats.getGamesWon());
        assertEquals(0, stats.getGamesLost());
    }

    @Test
    public void testPlayGameLoseScenario() {
        game.range = 10;
        game.maxAttempts = 5;
        game.randomNumber = 5; // Pretend the correct number is 5
        String input = "1\n2\n3\n4\n6\n"; // Simulate incorrect guesses
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        
        game.playGame(scanner, stats);
        
        assertEquals(0, stats.getGamesWon());
        assertEquals(1, stats.getGamesLost());
    }

    @Test
    public void testDisplayStatistics() {
        stats.incrementGamesPlayed();
        stats.incrementGamesWon();
        stats.incrementGamesLost();

        stats.displayStatistics();
        
        // No assertion here, but you can manually verify the output if needed.
    }
}