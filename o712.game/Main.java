import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        int m = Integer.valueOf(firstLine[0]);
        int n = Integer.valueOf(firstLine[1]);
        int k = Integer.valueOf(firstLine[2]);
        int r = Integer.valueOf(firstLine[3]);
        int c = Integer.valueOf(firstLine[4]);
        int[][] map = new int[m][n];
        int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int x = r, y = c, movement = 3, total = 0, ans = 0;

        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.valueOf(line[j]);
            }
        }

        while (true) {
            // Get score
            ans += 1;
            total += map[x][y];
            map[x][y] -= 1;

            // Detect k
            if (total % k == 0) {
                movement = turnRight(movement);
            }

            // Detect next step
            while (true) {
                int nextX = x + moves[movement][0];
                int nextY = y + moves[movement][1];
                
                if (nextX >= m || nextX < 0 || nextY >= n || nextY < 0) {
                    movement = turnRight(movement);
                    continue;
                } else if (map[nextX][nextY] == -1) {
                    movement = turnRight(movement);
                    continue;
                }
                break;
            }

            x += moves[movement][0];
            y += moves[movement][1];

            if (map[x][y] == 0) break;
        }

        System.out.println(ans);
    }

    public static int turnRight(int movement) {
        return movement == 0 ? 3 : movement - 1;
    }
}
