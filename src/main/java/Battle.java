public class Battle {

    private Pokemon firstPokemon;
    private Pokemon secondPokemon;

    public Battle(Pokemon firstPokemon, Pokemon secondPokemon) {
        this.firstPokemon = firstPokemon;
        this.secondPokemon = secondPokemon;
    }

    public void takeTurn() {
        firstPokemon.takeDamage(secondPokemon.getLevel());
        if (firstPokemon.isFainted()) {
            return;
        }
        secondPokemon.takeDamage(firstPokemon.getLevel());
    }

    public Pokemon getWinner() {
        if (firstPokemon.isFainted()) {
            return secondPokemon;
        } else if (secondPokemon.isFainted()) {
            return firstPokemon;
        } else {
            return null;
        }
    }
}
