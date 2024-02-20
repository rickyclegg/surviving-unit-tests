import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleResultTest {

    @Test
    void testGetPokemon() {
        Pokemon testPokemon = new Pokemon("Bulbasaur", 20, 250, 500);
        BattleResult battleResult = new BattleResult(testPokemon, 150);

        assertEquals(testPokemon, battleResult.getWinner(), "The returned Pokemon should be the same as the one in the BattleResult.");
    }

    @Test
    void testGetXpGained() {
        Pokemon testPokemon = new Pokemon("Squirtle", 15, 350, 750);
        int xpGained = 100;
        BattleResult battleResult = new BattleResult(testPokemon, xpGained);

        assertEquals(xpGained, battleResult.getXpGained(), "The returned XP gained should be the same as the one set in the BattleResult.");
    }
}
