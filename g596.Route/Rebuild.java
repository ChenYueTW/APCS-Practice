import java.util.Scanner;

public class Rebuild {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int h = Integer.parseInt(firstLine[2]);
        int[][] map = new int[m][n];

        int wood = 0;
        int wire = 0;
        int maxVal = 0;

        // 0 null
        // 1 wood
        // 2 直的線
        // 3 橫的線
        // 5 直&橫

        for (int i = 0; i < h; i++) {
            // Init value
            String[] line = scanner.nextLine().split(" ");
            int y = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);
            int movement = Integer.parseInt(line[2]); 

            if (movement == 0) { // Install wood
                if (map[y][x] == 2 || map[y][x] == 3 || map[y][x] == 5) wire -= 1;
                map[y][x] = 1;
                wood += 1;

                int[] dx = {0, -1, 0, 1};
                int[] dy = {-1, 0, 1, 0};

                for (int j = 0; j < 4; j++) {
                    boolean hasWood = false;
                    int fnx = 0, fny = 0;
                    for (int nx = x + dx[j], ny = y + dy[j]; true; nx += dx[j], ny += dy[j]) {
                        if (map[ny][nx] == 1) {
                            hasWood = true;
                            boolean val = (j % 2 == 0);
                            fnx = nx;
                            fny = ny + val ? ;
                            break;
                        }
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) break; // out range
                        // if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        //     if (map[ny][nx] == 1) break;
                        //     int val = (j % 2 == 0 ? 2 : 3);
                        //     if (val == map[ny][nx]) break;
                        //     wire += 1;
                        //     map[ny][nx] = (map[ny][nx] == 0) ? val : (map[ny][nx] == 2 ? 3 : 2); // add wire
                        // } else break;
                    }

                    for (int nx = x + dx[j], ny = y + dy[j]; nx <= fnx && ny <= fny;) {

                    }
                }
                System.out.println(wire);

                maxVal = maxVal > wood + wire ? maxVal : wood + wire;
            } else { // Remove wood
                map[y][x] = 0;
                wood -= 1;

                int[] dx = {0, 0, -1, 1};
                int[] dy = {-1, 1, 0, 0};

                for (int j = 0; j < 4; j++) {
                    for (int nx = x + dx[j], ny = y + dy[j]; true; nx += dx[j], ny += dy[j]) {
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (map[ny][nx] != 1) break;
                            int val = (j % 2 == 0 ? 2 : 3);
                            if (map[ny][nx] == 0 || map[ny][nx] == 1 || (map[ny][nx] != val && map[ny][nx] != 5)) break;
                            wire -= 1;
                            map[ny][nx] = map[ny][nx] == 5 ? map[ny][nx] - val : 0;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 || map[i][j] == 2 || map[i][j] == 3 || map[i][j] == 5) ans += 1;
            }
        }
        System.out.println(maxVal);
        System.out.println(ans);
        scanner.close();
    }
}
