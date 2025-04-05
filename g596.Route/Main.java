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

        // Wooden stake is 1
        // Wire is 2
        for (int i = 0; i < h; i++) {
            String[] line = scanner.nextLine().split(" ");
            int y = Integer.parseInt(line[0]);
            int x = Integer.parseInt(line[1]);
            int cmd = Integer.parseInt(line[2]);
            // Command
            if (cmd == 0) { // add
                if (map[y][x] == 2) wire -= 1;
                map[y][x] = 1;
                wood += 1;

                // wire
                // up
                if (y - 2 >= 0) {
                    for (int j = y - 1; j >= 0; j--) {
                        if (map[j][x] == 1) { // find wood
                            for (int k = y - 1; k > j; k--) {
                                if (map[k][x] == 0) {
                                    map[k][x] = 2;
                                    wire += 1;
                                }
                            }
                            break;
                        }
                    }
                }
                // down
                if (y + 2 < m) {
                    for (int j = y + 1; j < m; j++) {
                        if (map[j][x] == 1) { // find wood
                            for (int k = y + 1; k < j; k++) {
                                if (map[k][x] == 0) {
                                    map[k][x] = 2;
                                    wire += 1;
                                }
                            }
                            break;
                        }
                    }
                }
                // left
                if (x - 2 >= 0) {
                    for (int j = x - 1; j >= 0; j--) {
                        if (map[y][j] == 1) { // find wood
                            for (int k = x - 1; k > j; k--) {
                                if (map[y][k] == 0) {
                                    map[y][k] = 2;
                                    wire += 1;
                                }
                            }
                            break;
                        }
                    }
                }
                // right
                if (x + 2 < n) {
                    for (int j = x + 1; j < n; j++) {
                        if (map[y][j] == 1) { // find wood
                            for (int k = x + 1; k < j; k++) {
                                if (map[y][k] == 0) {
                                    map[y][k] = 2;
                                    wire += 1;
                                }
                            }
                            break;
                        }
                    }
                }
                System.out.println(wire);

                // caculate max val
                maxVal = maxVal > wire + wood ? maxVal : wire + wood;
            } else { // remove
                map[y][x] = 0;
                wood -= 1;

                // wire
                // up
                if (y - 2 >= 0) {
                    for (int j = y - 1; j >= 0; j--) {
                        if (map[j][x] == 1) { // find wood
                            for (int k = y - 1; k > j; k--) {
                                map[k][x] = 0;
                                wire -= 1;
                            }
                            break;
                        }
                    }
                }
                // down
                if (y + 2 < m) {
                    for (int j = y + 1; j < m; j++) {
                        if (map[j][x] == 1) { // find wood
                            for (int k = y + 1; k < j; k++) {
                                map[k][x] = 0;
                                wire -= 1;
                            }
                            break;
                        }
                    }
                }
                // left
                if (x - 2 >= 0) {
                    for (int j = x - 1; j >= 0; j--) {
                        if (map[y][j] == 1) { // find wood
                            for (int k = x - 1; k > j; k--) {
                                map[y][k] = 0;
                                wire -= 1;
                            }
                            break;
                        }
                    }
                }
                // right
                if (x + 2 < n) {
                    for (int j = x + 1; j < n; j++) {
                        if (map[y][j] == 1) { // find wood
                            for (int k = x + 1; k < j; k++) {
                                map[y][k] = 0;
                                wire -= 1;
                            }
                            break;
                        }
                    }
                }
            }
        }
    
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 || map[i][j] == 2) ans += 1;
            }
        }

        System.out.println(maxVal);
        System.out.println(ans);
        scanner.close();
    }
}