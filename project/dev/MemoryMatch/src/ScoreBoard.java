import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * ScoreBoard
 * persistent scoreboard instance
 */
public class ScoreBoard implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7916214329737236852L;
    Map<String, Long> scores = new HashMap<>();
    String path = System.getProperty("user.dir");
    String data = path + "/src/scoreboard.ser";

    /**
     * default constructor if serialized instance does not already exist
     */
    public ScoreBoard() {
        this.scores.put("Easy", (long) 100000);
        this.scores.put("Medium", (long) 100000);
        this.scores.put("Hard", (long) 100000);
        this.scores.put("Impossible", (long) 100000);
    }
    
    public void replace(String key, Long score) {
        scores.replace(key, score);
    }

    public Map<String, Long> getScores() {
        return scores;
    }

    public Long getValue(String key) {
        return scores.get(key);
    }

}