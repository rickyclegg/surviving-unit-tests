public class Pokemon {

    private String name;
    private String type;
    private int level;
    private int healthPoints;

    public Pokemon(String name, String type, int level, int healthPoints) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    public boolean isFainted() {
        return this.healthPoints <= 0;
    }

    // Level up increases Pokemon's level by 1
    public void levelUp() {
        this.level += 1;
    }
}
