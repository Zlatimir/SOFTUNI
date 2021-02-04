package guild;

/**
 * Created by Zlatimir Ivanov on 4.2.2021 г..
 */

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz){
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    @Override
    public String toString() {
        return String.format("Player %s: %s%nRank: %s%nDescription: %s", this.name, this.clazz, this.rank, this.description);
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return this.rank;
    }

    public String getClazz() {
        return this.clazz;
    }
}
