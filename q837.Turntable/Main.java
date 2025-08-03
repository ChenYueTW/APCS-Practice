import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int m = Integer.valueOf(firstLine[0]);
        int n = Integer.valueOf(firstLine[1]);
        int k = Integer.valueOf(firstLine[2]);
        int score = 0;

        ArrayList<String[]> strArray = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            strArray.add(reader.readLine().split(""));
        }

        ArrayList<String[]> round = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] line = reader.readLine().split(" ");
            round.add(line);
        }

        for (int i = 0; i < k; i++) { // Round
            // turn table
            for (int j = 0; j < m; j++) {
                int movement = Integer.valueOf(round.get(i)[j]);
                boolean reverse = (int) Math.signum(movement) == 1 ? true : false;

                for (int l = 0; l < Math.abs(movement); l++) {
                    String[] newStrArray = turnString(strArray.get(j), reverse);
                    strArray.set(j, newStrArray);
                }
            }

            // score
            for (int j = 0; j < n; j++) {
                HashMap<String, Integer> map = new HashMap<>();
                ArrayList<String> hashStr = new ArrayList<>();

                for (int l = 0; l < m; l++) {
                    String str = strArray.get(l)[j];
                    if (map.getOrDefault(str, 0) == 0) {
                        map.put(str, 1);
                        hashStr.add(str);
                    } else {
                        map.put(str, map.get(str) + 1);
                    }
                }

                int cache = 0;
                for (String s : hashStr) {
                    int frequency = map.get(s);
                    cache = frequency > cache ? frequency : cache;
                }

                score += cache;
            }
        }

        System.out.println(score);
    }

    public static String[] turnString(String[] str, boolean reverse) {
        if (reverse) { // Right
            String temp = str[str.length - 1];
            for (int i = str.length - 2; i >= 0; i--) {
                str[i + 1] = str[i];
            }
            str[0] = temp;
        } else { // Left
            String temp = str[0];
            for (int i = 0; i < str.length - 1; i++) {
                str[i] = str[i + 1];
            }
            str[str.length - 1] = temp;
        }
        return str;
    }
}