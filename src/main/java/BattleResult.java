public class BattleResult {

    private Pokemon winner;

    private int xpGained;

    public BattleResult(Pokemon pokemon, int xpGained) {
        this.winner = pokemon;
        this.xpGained = xpGained;
    }

    public Pokemon getWinner() {
        return winner;
    }

    public int getXpGained() {
        return xpGained;
    }
}
