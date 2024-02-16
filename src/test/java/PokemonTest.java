import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PokemonTest {

    @Test
    public void testTakeDamage() {
        Pokemon pikachu = new Pokemon("Pikachu", "Electric", 5, 35);
        pikachu.takeDamage(10);
        assertEquals(25, pikachu.getHealthPoints());
    }

    @Test
    public void testTakeDamageFaintsPokemon() {
        Pokemon bulbasaur = new Pokemon("Bulbasaur", "Grass", 5, 30);
        bulbasaur.takeDamage(35);
        assertTrue(bulbasaur.isFainted());
    }

    @Test
    public void testLevelUpIncreasesLevelByOne() {
        Pokemon charmander = new Pokemon("Charmander", "Fire", 5, 39);
        charmander.levelUp();
        assertEquals(6, charmander.getLevel());
    }

    @Test
    public void testPokemonCreationHasCorrectAttributes() {
        Pokemon squirtle = new Pokemon("Squirtle", "Water", 5, 44);
        assertEquals("Squirtle", squirtle.getName());
        assertEquals("Water", squirtle.getType());
        assertEquals(5, squirtle.getLevel());
        assertEquals(44, squirtle.getHealthPoints());
    }
}
