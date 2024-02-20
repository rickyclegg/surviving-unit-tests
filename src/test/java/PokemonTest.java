import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {

    @Test
    public void testNameGetter() {
        Pokemon pikachu = new Pokemon("Pikachu", 5, 150, 300);
        assertEquals("Pikachu", pikachu.getName(), "The name should be Pikachu.");
    }

    @Test
    public void testLevelGetter() {
        Pokemon pikachu = new Pokemon("Pikachu", 5, 150, 300);
        assertEquals(5, pikachu.getLevel(), "The level should be 5.");
    }

    @Test
    public void testXpGetter() {
        Pokemon pikachu = new Pokemon("Pikachu", 5, 150, 300);
        assertEquals(150, pikachu.getXP(), "The XP should be 150.");
    }

    @Test
    public void testXpThresholdGetter() {
        Pokemon pikachu = new Pokemon("Pikachu", 5, 150, 300);
        assertEquals(300, pikachu.getXpToEvolve(), "The XP threshold should be 300.");
    }
}
