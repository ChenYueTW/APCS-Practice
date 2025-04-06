import java.util.Scanner;

public class Main {
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

                int[] dx = {0, 0, -1, 1};
                int[] dy = {-1, 1, 0, 0};

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[ny][nx] == 1) { // find wood
                            
                            int tx = x + dx[j];
                            int ty = y + dy[j];

                            while (tx != nx || ty != ny) {
                                int val = j < 2 ? 2 : 3;

                                if (map[ty][tx] == 0) {
                                    map[ty][tx] = val;
                                    wire += 1;
                                } else if (map[ty][tx] != val && map[ty][tx] != 5) {
                                    map[ty][tx] = 5;
                                }
                                
                                tx += dx[j];
                                ty += dy[j];
                            }
                            break;
                        } else if (map[ny][nx] == 0 || map[ny][nx] == 2 || map[ny][nx] == 3 || map[ny][nx] == 5) { // next step
                            nx += dx[j];
                            ny += dy[j];
                        } else {
                            break;
                        }
                    }
                }

                maxVal = maxVal > wood + wire ? maxVal : wood + wire;
            } else { // Remove wood
                map[y][x] = 0;
                wood -= 1;

                int[] dx = {0, 0, -1, 1};
                int[] dy = {-1, 1, 0, 0};

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    while (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[ny][nx] == 1) { // find wood
                            int tx = x + dx[j];
                            int ty = y + dy[j];

                            while (tx != nx || ty != ny) {
                                int val = j < 2 ? 2 : 3;
                                if (map[ty][tx] == val) {
                                    map[ty][tx] = 0;
                                    wire -= 1;
                                }
                                else if (map[ty][tx] == 5) {
                                    map[ty][tx] -= val;
                                }
                                
                                tx += dx[j];
                                ty += dy[j];
                            }
                            break;
                        } else if (map[ny][nx] == 2 || map[ny][nx] == 3 || map[ny][nx] == 5) {
                            nx += dx[j];
                            ny += dy[j];
                        } else {
                            break;
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
