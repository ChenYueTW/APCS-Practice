import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);
        int k = Integer.valueOf(firstLine[2]);

        int[][] map = new int[n][m];
        ArrayList<int[]> demonKing = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] line = scanner.nextLine().split(" ");
            int[] arr = new int[4];
            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.valueOf(line[j]);
            }
            demonKing.add(arr);
        }

        while (true) {
            ArrayList<int[]> record = new ArrayList<>();

            // Place bomb
            for (int i = 0; i < demonKing.size(); i++) {
                int x = demonKing.get(i)[1];
                int y = demonKing.get(i)[0];
                map[y][x] += 1;
            }

            // Demon king MOVE
            for (int i = demonKing.size() - 1; i >= 0; i--) {
                int nx = demonKing.get(i)[1] + demonKing.get(i)[3];
                int ny = demonKing.get(i)[0] + demonKing.get(i)[2];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) { // In range
                    if (map[ny][nx] != 0) { // Has bomb
                        demonKing.remove(i);
                        record.add(new int[]{ny, nx});
                    } else { // Can move
                        demonKing.get(i)[1] = nx;
                        demonKing.get(i)[0] = ny;
                    }
                } else { // out range
                    demonKing.remove(i);
                }
            }
            // Remove bomb
            for (int[] pos : record) {
                map[pos[0]][pos[1]] = 0;
            }
            if (demonKing.size() == 0) break;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) ans += 1;
            }
        }
        System.out.println(ans);
        scanner.close();
    }
}