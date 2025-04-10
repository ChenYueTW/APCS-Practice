import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int[][] map = new int[n][m];
        int[][] condition = new int[n][m];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        while (true) {
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            boolean hasElement = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int num = map[i][j];
                    int x = -1;
                    int y = -1;
                    boolean hasNum = false;

                    for (int k = 0; k < 4; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            if (map[ny][nx] == num && condition[ny][nx] == 0) {
                                // System.out.println(ny + " " + nx);
                                if (nx == j) {
                                    for (int c = Math.max(ny, i) - 1; c > Math.min(ny, i); c--) {
                                        if (condition[c][nx] == 0) {
                                            hasNum = true;
                                            break;
                                        }
                                    }
                                } else {
                                    for (int c = Math.max(nx, j) - 1; c > Math.min(nx, j); c--) {
                                        if (condition[ny][c] == 0) {
                                            hasNum = true;
                                            break;
                                        }
                                    }
                                }
                                if (hasNum) break;
                                x = nx;
                                y = ny;
                            }
                            nx += dx[k];
                            ny += dy[k];
                        }
                        
                    }
                    if (x == -1 && y == -1) continue;
                    condition[y][x] = 1;
                    condition[i][j] = 1;
                    ans += map[i][j];
                    hasElement = true;
                }
            }
            if (!hasElement) break;
        }
        System.out.println(ans);
        scanner.close();
    }
}