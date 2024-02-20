import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EvolveStatusTest {

    @Test
    void testGetPokemon() {
        // Arrange
        Pokemon testPokemon = new Pokemon("Charizard", 36, 1200, 1500);
        EvolveStatus evolveStatus = new EvolveStatus(testPokemon, true);

        // Act & Assert
        assertEquals(testPokemon, evolveStatus.getPokemon(), "The returned Pokemon should be the same as the one associated with EvolveStatus.");
    }

    @Test
    void testGetHasEvolvedTrue() {
        // Arrange
        Pokemon testPokemon = new Pokemon("Blastoise", 36, 1200, 1500);
        EvolveStatus evolveStatus = new EvolveStatus(testPokemon, true);

        // Act & Assert
        assertTrue(evolveStatus.getHasEvolved(), "The getHasEvolved should return true when the Pokemon has evolved.");
    }

    @Test
    void testGetHasEvolvedFalse() {
        // Arrange
        Pokemon testPokemon = new Pokemon("Venusaur", 36, 1200, 1500);
        EvolveStatus evolveStatus = new EvolveStatus(testPokemon, false);

        // Act & Assert
        assertFalse(evolveStatus.getHasEvolved(), "The getHasEvolved should return false when the Pokemon has not evolved.");
    }
}
