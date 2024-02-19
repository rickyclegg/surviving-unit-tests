import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokedexTest {

    @Test
    void testGetByNameExists() {
        Pokemon bulbasaur = Pokedex.getByName("Bulbasaur");
        assertNotNull(bulbasaur);
        assertEquals("Bulbasaur", bulbasaur.getName());
        assertEquals("Grass/Poison", bulbasaur.getType());
        assertEquals(1, bulbasaur.getLevel());
        assertEquals(45, bulbasaur.getHealthPoints());
    }

    @Test
    void testGetByNameNotExists() {
        Pokemon unknown = Pokedex.getByName("Unknown");
        assertNull(unknown);
    }

    @Test
    void testGetByNameCaseInsensitive() {
        Pokemon bulbasaur = Pokedex.getByName("BULBASAUR");
        assertNotNull(bulbasaur);
        assertEquals("Bulbasaur", bulbasaur.getName());
    }
}
