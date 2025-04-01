import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().split(" ");
        int n = Integer.valueOf(firstLine[0]);
        int m = Integer.valueOf(firstLine[1]);
        int[][] map = new int[n][m];
        boolean[][] isRunned = new boolean[n][m];

        // Min Location value
        int minVal = 0;
        int locateY = 0;
        int locateX = 0;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                int value = Integer.valueOf(line[j]);
                map[i][j] = value;
            
                if (minVal > value || (i == 0 && j == 0)) {
                    minVal = value;
                    locateY = i;
                    locateX = j;
                }
            }
        }

        // Robot Run
        while (true) {
            boolean hasRoad = false;

            // Rage value
            int upVal = -1;
            int downVal = -1;
            int leftVal = -1;
            int rightVal = -1;

            // Up
            if (locateY + 1 < n) {
                if (!isRunned[locateY + 1][locateX]) {
                    upVal = map[locateY + 1][locateX];
                    hasRoad = true;
                }
            }
            // Down
            if (locateY - 1 >= 0) {
                if (!isRunned[locateY - 1][locateX]) {
                    downVal = map[locateY - 1][locateX];
                    hasRoad = true;
                }
            }
            // Left
            if (locateX - 1 >= 0) {
                if (!isRunned[locateY][locateX - 1]) {
                    leftVal = map[locateY][locateX - 1];
                    hasRoad = true;
                }
            }
            // Right
            if (locateX + 1 < m) {
                if (!isRunned[locateY][locateX + 1]) {
                    rightVal = map[locateY][locateX + 1];
                    hasRoad = true;
                }
            }

            int cache = Integer.MAX_VALUE;
            int cacheX = 0;
            int cacheY = 0;
            if (upVal != -1 && upVal < cache) {
                cache = upVal;
                cacheX = 0;
                cacheY += 1;
            }
            if (downVal != -1 && downVal < cache) {
                cache = downVal;
                cacheX = 0;
                cacheY = -1;
            }
            if (leftVal != -1  && leftVal < cache) {
                cache = leftVal;
                cacheX = -1;
                cacheY = 0;
            }
            if (rightVal != -1 && rightVal < cache) {
                cache = rightVal;
                cacheX = 1;
                cacheY = 0;
            }

            // Detect has road
            if (hasRoad) {
                minVal += cache;
                isRunned[locateY][locateX] = true;
                locateX += cacheX;
                locateY += cacheY;
            }
            else break;
        }

        System.out.println(minVal);
        scanner.close();
    }
}