public class EvolveStatus {
    private Pokemon pokemon;

    private boolean hasEvolved;

    public EvolveStatus(Pokemon pokemon, boolean hasEvolved) {
        this.pokemon = pokemon;
        this.hasEvolved = hasEvolved;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public boolean getHasEvolved() {
        return hasEvolved;
    }
}
