import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int t = Integer.valueOf(firstLine[1]);
        int score = 0;

        ArrayList<Integer> num = new ArrayList<>();
        String[] numLine = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            num.add(Integer.valueOf(numLine[i]));
        }

        boolean isOver = false;
        while (!isOver) {
            int minValue = Integer.MAX_VALUE;
            int minLoc = 0;
            boolean isSame = false;
            int maxLoc = 0;

            for (int i = 0; i < num.size(); i++) {
                if (num.get(i) == 0) break;
                maxLoc = i;
                if (isSame) break;

                if (num.get(i) < minValue) {
                    if (minLoc == 0) {
                        minValue = num.get(i);
                        minLoc = i;
                    } else {
                        isSame = true;
                        break;
                    }
                }
            }

            for (int i = minLoc; i < maxLoc; i++) {
                
            }

            if (!isSame && num.get(minLoc) < t) {
                score += num.get(minLoc);
                num.set(minLoc, 0);
            }
        }
    }
}
