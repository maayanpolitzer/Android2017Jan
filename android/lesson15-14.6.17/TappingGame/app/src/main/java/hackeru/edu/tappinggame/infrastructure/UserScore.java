package hackeru.edu.tappinggame.infrastructure;

/**
 * Created by hackeru on 11/06/2017.
 */

public class UserScore {

    private String name;
    private double score;

    public UserScore(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " -> " + score;
    }
}
