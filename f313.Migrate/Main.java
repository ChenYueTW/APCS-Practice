import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int r = Integer.valueOf(firstLine[0]);
        int c = Integer.valueOf(firstLine[1]);
        int k = Integer.valueOf(firstLine[2]);
        int m = Integer.valueOf(firstLine[3]);
        int[][] map = new int[r][c];

        for (int i = 0; i < r; i++) {
            String[] coordinate = scanner.nextLine().split(" ");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.valueOf(coordinate[j]);
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        for (int i = 0; i < m; i++) {
            // Fresh map
            int[][] newMap = new int[r][c];
            for (int mI = 0; mI < r; mI++) {
                for (int mJ = 0; mJ < c; mJ++) {
                    newMap[mI][mJ] = map[mI][mJ];
                }
            }

            for (int h = 0; h < r; h++) { // y
                for (int j = 0; j < c; j++) { // x
                    if (map[h][j] == -1) continue;
                    int move = map[h][j] / k;
                    int totalMoved = 0;

                    for (int l = 0; l < 4; l++) {
                        int mx = j + dx[l];
                        int my = h + dy[l];

                        if (mx >= 0 && my >= 0 && mx < c && my < r) {
                            if (map[my][mx] != -1) {
                                newMap[my][mx] += move;
                                totalMoved += move;
                            }
                            
                        }
                    }
                    newMap[h][j] -= totalMoved;
                }
            }
            map = newMap;
        }

        // Get Max and Min
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int val = map[i][j];
                if (val != -1) {
                    maxVal = val > maxVal ? val : maxVal;
                    minVal = val < minVal ? val : minVal;
                }
            }
        }
        System.out.println(minVal);
        System.out.println(maxVal);
        scanner.close();
    }
}