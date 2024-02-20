public class Pokemon {

    private String name;

    private int level;

    private int xp;

    private int xpToEvolve;

    public Pokemon(String name, int level, int xp, int xpThreshold) {
        this.name = name;
        this.level = level;
        this.xp = xp;
        this.xpToEvolve = xpThreshold;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getXP() {
        return xp;
    }

    public int getXpToEvolve() {
        return xpToEvolve;
    }
}
