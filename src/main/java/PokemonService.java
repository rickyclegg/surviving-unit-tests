import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PokemonService {
    private static final String ENDPOINT = "https://pokeapi.co/api/v2/pokemon/";
    private HttpWebClient webClient;
    private HashSet<String> capturedPokemons = new HashSet<>();

    public PokemonService(HttpWebClient webClient) {
        this.webClient = webClient;
    }

    public String[] getPokemonNames() throws IOException {
        InputStream response = webClient.getData(ENDPOINT);
        JsonArray results = JsonParser.parseReader(new InputStreamReader(response))
                .getAsJsonObject()
                .getAsJsonArray("results");
        String[] names = new String[results.size()];
        for (int i = 0; i < results.size(); i++) {
            names[i] = results.get(i).getAsJsonObject().get("name").getAsString();
        }
        return names;
    }

    public JsonObject getByName(String pokemonName) throws IOException {
        String url = ENDPOINT + pokemonName;
        InputStream response = webClient.getData(url);
        return JsonParser.parseReader(new InputStreamReader(response)).getAsJsonObject();
    }

    public boolean capture(String pokemonName) throws Exception {
        try {
            getByName(pokemonName);
        } catch (Exception e) {
            throw new Exception(pokemonName + " is not a real Pokemon!");
        }

        if (capturedPokemons.contains(pokemonName)) {
            return false;
        }
        capturedPokemons.add(pokemonName);
        return true;
    }

    public String[] getCapturedPokemons() {
        return capturedPokemons.toArray(new String[0]);
    }

    public String[] getRemainingPokemons() throws IOException {
        String[] allPokemon = getPokemonNames();
        List<String> remainingPokemon = new ArrayList<>(Arrays.asList(allPokemon));
        remainingPokemon.removeAll(capturedPokemons);
        return remainingPokemon.toArray(new String[0]);
    }
}
