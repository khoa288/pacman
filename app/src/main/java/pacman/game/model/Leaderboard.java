import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leaderboard {
    private static final String FILE_NAME = "leaderboard.txt";
    private List<Integer> scores;

    public Leaderboard() {
        scores = new ArrayList<>();
        loadScores();
    }

    public void addScore(int score) {
        scores.add(score);
        Collections.sort(scores, Collections.reverseOrder());
        saveScores();
    }

    public List<Integer> getTopScores(int n) {
        return scores.subList(0, Math.min(n, scores.size()));
    }

    private void loadScores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                scores.add(Integer.parseInt(line));
            }
            Collections.sort(scores, Collections.reverseOrder());
        } catch (IOException e) {
            // File not found, no scores to load
        }
    }

    private void saveScores() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int score : scores) {
                writer.write(score + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}