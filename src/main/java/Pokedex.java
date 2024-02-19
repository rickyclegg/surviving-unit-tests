import java.util.*;

public class Pokedex {
    private static Map<String, Pokemon> pokemonMap = new HashMap<>();

    static {
        pokemonMap.put("bulbasaur", new Pokemon("Bulbasaur", "Grass/Poison", 1, 45));
        pokemonMap.put("ivysaur", new Pokemon("Ivysaur", "Grass/Poison", 16, 60));
        pokemonMap.put("venusaur", new Pokemon("Venusaur", "Grass/Poison", 32, 80));
        pokemonMap.put("charmander", new Pokemon("Charmander", "Fire", 1, 39));
        pokemonMap.put("charmeleon", new Pokemon("Charmeleon", "Fire", 16, 58));
        pokemonMap.put("charizard", new Pokemon("Charizard", "Fire/Flying", 36, 78));
        pokemonMap.put("squirtle", new Pokemon("Squirtle", "Water", 1, 44));
        pokemonMap.put("wartortle", new Pokemon("Wartortle", "Water", 16, 59));
        pokemonMap.put("blastoise", new Pokemon("Blastoise", "Water", 36, 79));
        pokemonMap.put("caterpie", new Pokemon("Caterpie", "Bug", 1, 45));
        pokemonMap.put("metapod", new Pokemon("Metapod", "Bug", 7, 50));
        pokemonMap.put("butterfree", new Pokemon("Butterfree", "Bug/Flying", 10, 60));
        pokemonMap.put("weedle", new Pokemon("Weedle", "Bug/Poison", 1, 40));
        pokemonMap.put("kakuna", new Pokemon("Kakuna", "Bug/Poison", 7, 45));
        pokemonMap.put("beedrill", new Pokemon("Beedrill", "Bug/Poison", 10, 65));
        pokemonMap.put("pidgey", new Pokemon("Pidgey", "Normal/Flying", 1, 40));
        pokemonMap.put("pidgeotto", new Pokemon("Pidgeotto", "Normal/Flying", 18, 63));
        pokemonMap.put("pidgeot", new Pokemon("Pidgeot", "Normal/Flying", 36, 83));
        pokemonMap.put("rattata", new Pokemon("Rattata", "Normal", 1, 30));
        pokemonMap.put("raticate", new Pokemon("Raticate", "Normal", 20, 55));
    }

    public static Pokemon getByName(String name) {
        return pokemonMap.get(name.toLowerCase());
    }
}
