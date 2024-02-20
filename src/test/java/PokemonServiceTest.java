import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.google.gson.JsonObject;

public class PokemonServiceTest {

    @Test
    public void testGetPokemonNames() throws Exception {
        String mockResponse = "{\"results\": [{\"name\": \"pokemon1\"}, {\"name\": \"pokemon2\"}]}";
        InputStream mockInputStream = new ByteArrayInputStream(mockResponse.getBytes(StandardCharsets.UTF_8));
        HttpWebClient mockWebClient = Mockito.mock(HttpWebClient.class);
        doReturn(mockInputStream).when(mockWebClient).getData("https://pokeapi.co/api/v2/pokemon/");

        PokemonService service = new PokemonService(mockWebClient);

        String[] names = service.getPokemonNames();

        assertNotNull(names);
        assertEquals(2, names.length);
        assertEquals("pokemon1", names[0]);
        assertEquals("pokemon2", names[1]);
    }

    @Test
    public void testGetByName() throws Exception {
        String mockResponse = "{\"name\": \"bulbasaur\", \"height\": 7, \"weight\": 69}";
        InputStream mockInputStream = new ByteArrayInputStream(mockResponse.getBytes(StandardCharsets.UTF_8));
        HttpWebClient mockWebClient = Mockito.mock(HttpWebClient.class);
        doReturn(mockInputStream).when(mockWebClient).getData("https://pokeapi.co/api/v2/pokemon/bulbasaur");

        PokemonService service = new PokemonService(mockWebClient);

        JsonObject pokemon = service.getByName("bulbasaur");

        assertNotNull(pokemon);
        assertEquals("bulbasaur", pokemon.get("name").getAsString());
    }

    @Test
    public void testCapture_ValidPokemon_NotCapturedBefore() throws Exception {
        String mockResponse = "{\"name\": \"bulbasaur\", \"height\": 7, \"weight\": 69}";
        InputStream mockInputStream = new ByteArrayInputStream(mockResponse.getBytes(StandardCharsets.UTF_8));
        HttpWebClient mockWebClient = Mockito.mock(HttpWebClient.class);
        doReturn(mockInputStream).when(mockWebClient).getData(contains("bulbasaur"));

        PokemonService service = new PokemonService(mockWebClient);

        boolean captureResult = service.capture("bulbasaur");

        assertTrue(captureResult);
    }

    @Test
    public void testCapture_ValidPokemon_CapturedBefore() throws Exception {
        String mockResponse = "{\"name\": \"bulbasaur\", \"height\": 7, \"weight\": 69}";
        InputStream mockInputStream1 = new ByteArrayInputStream(mockResponse.getBytes(StandardCharsets.UTF_8));
        InputStream mockInputStream2 = new ByteArrayInputStream(mockResponse.getBytes(StandardCharsets.UTF_8));
        HttpWebClient mockWebClient = Mockito.mock(HttpWebClient.class);
        when(mockWebClient.getData(contains("bulbasaur"))).thenReturn(mockInputStream1, mockInputStream2);

        PokemonService service = new PokemonService(mockWebClient);

        service.capture("bulbasaur");  // Capture once
        boolean captureResult = service.capture("bulbasaur");  // Try to capture again

        assertFalse(captureResult);
    }

    @Test
    public void testCapture_InvalidPokemon() throws Exception {
        HttpWebClient mockWebClient = Mockito.mock(HttpWebClient.class);
        doThrow(IOException.class).when(mockWebClient).getData(contains("invalid"));

        PokemonService service = new PokemonService(mockWebClient);

        Exception exception = assertThrows(Exception.class, () -> service.capture("invalid"));
        assertEquals("invalid is not a real Pokemon!", exception.getMessage());
    }

    @Test
    public void testGetCapturedPokemons() throws Exception {
        String mockResponse = "{\"name\": \"bulbasaur\", \"height\": 7, \"weight\": 69}";
        InputStream mockInputStream = new ByteArrayInputStream(mockResponse.getBytes(StandardCharsets.UTF_8));
        HttpWebClient mockWebClient = Mockito.mock(HttpWebClient.class);
        doReturn(mockInputStream).when(mockWebClient).getData(contains("bulbasaur"));

        PokemonService service = new PokemonService(mockWebClient);

        // capture one pokemon
        service.capture("bulbasaur");

        String[] captured = service.getCapturedPokemons();

        assertNotNull(captured);
        assertEquals(1, captured.length);
        assertEquals("bulbasaur", captured[0]);
    }

    @Test
    public void testGetRemainingPokemons() throws Exception {
        String mockAllResponse = "{\"results\": [{\"name\": \"pokemon1\"}, {\"name\": \"pokemon2\"}]}";
        InputStream mockAllInputStream = new ByteArrayInputStream(mockAllResponse.getBytes(StandardCharsets.UTF_8));
        String mockOneResponse = "{\"name\": \"pokemon1\", \"height\": 7, \"weight\": 69}";
        InputStream mockOneInputStream = new ByteArrayInputStream(mockOneResponse.getBytes(StandardCharsets.UTF_8));

        HttpWebClient mockWebClient = Mockito.mock(HttpWebClient.class);
        doReturn(mockAllInputStream).when(mockWebClient).getData("https://pokeapi.co/api/v2/pokemon/");
        doReturn(mockOneInputStream).when(mockWebClient).getData(contains("pokemon1"));

        PokemonService service = new PokemonService(mockWebClient);

        // capture one pokemon
        service.capture("pokemon1");

        String[] remaining = service.getRemainingPokemons();

        assertNotNull(remaining);
        assertEquals(1, remaining.length);
        assertEquals("pokemon2", remaining[0]);
    }
}
