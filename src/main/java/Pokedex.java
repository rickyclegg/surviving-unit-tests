import java.util.*;

public class Pokedex {

    private static List<Pokemon> pokemonList = new ArrayList<>();

    static {
        pokemonList.add(new Pokemon("Bulbasaur", "Grass/Poison", 1, 45));
        pokemonList.add(new Pokemon("Ivysaur", "Grass/Poison", 16, 60));
        pokemonList.add(new Pokemon("Venusaur", "Grass/Poison", 32, 80));
        pokemonList.add(new Pokemon("Charmander", "Fire", 1, 39));
        pokemonList.add(new Pokemon("Charmeleon", "Fire", 16, 58));
        pokemonList.add(new Pokemon("Charizard", "Fire/Flying", 36, 78));
        pokemonList.add(new Pokemon("Squirtle", "Water", 1, 44));
        pokemonList.add(new Pokemon("Wartortle", "Water", 16, 59));
        pokemonList.add(new Pokemon("Blastoise", "Water", 36, 79));
        pokemonList.add(new Pokemon("Caterpie", "Bug", 1, 45));
        pokemonList.add(new Pokemon("Metapod", "Bug", 7, 50));
        pokemonList.add(new Pokemon("Butterfree", "Bug/Flying", 10, 60));
        pokemonList.add(new Pokemon("Weedle", "Bug/Poison", 1, 40));
        pokemonList.add(new Pokemon("Kakuna", "Bug/Poison", 7, 45));
        pokemonList.add(new Pokemon("Beedrill", "Bug/Poison", 10, 65));
        pokemonList.add(new Pokemon("Pidgey", "Normal/Flying", 1, 40));
        pokemonList.add(new Pokemon("Pidgeotto", "Normal/Flying", 18, 63));
        pokemonList.add(new Pokemon("Pidgeot", "Normal/Flying", 36, 83));
        pokemonList.add(new Pokemon("Rattata", "Normal", 1, 30));
        pokemonList.add(new Pokemon("Raticate", "Normal", 20, 55));
    }

    public static Pokemon getByName(String id) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getName().equalsIgnoreCase(id)) {
                return pokemon;
            }
        }
        return null;
    }
}
