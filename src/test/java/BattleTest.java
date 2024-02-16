import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BattleTest {

    @Test
    public void testBattleUntilSomeoneFaints() {
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", 5, 35);
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass", 5, 30);

        Battle battle = new Battle(pikachu, bulbasaur);

        while (battle.getWinner() == null) {
            battle.takeTurn();
        }

        assertTrue(pikachu.isFainted() || bulbasaur.isFainted());
    }

    @Test
    public void testCorrectWinnerIsReturned() {
        Pokemon charmander = new Pokemon("Charmander", "Fire", 5, 39);
        Pokemon squirtle = new Pokemon("Squirtle", "Water", 50, 50);

        Battle battle = new Battle(charmander, squirtle);

        while (battle.getWinner() == null) {
            battle.takeTurn();
        }

        assertEquals(squirtle, battle.getWinner());
    }
}
